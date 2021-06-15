const Options = ({ optionList, setOptionList, styles, isEditable }) => {
  const handleRemoveClick = (index) => {
    const list = [...optionList]
    list.splice(index, 1)
    setOptionList(list)
  }

  const handleAddClick = () => {
    if (optionList.find((option) => option.correct)) {
      setOptionList([...optionList, { optionText: '', correct: 0 }])
    } else {
      setOptionList([...optionList, { optionText: '', correct: 1 }])
    }
  }

  const onChangeOptionsProperty = (id, value) => {
    const newOptionList = optionList.map((option, index) => {
      if (index === id) {
        const updatedOption = {
          ...option,
          optionText: value,
        }
        return updatedOption
      }
      return option
    })
    setOptionList(newOptionList)
  }

  return (
    <>
      {optionList.map((option, index) => {
        return (
          <div key={index} className={styles.row100}>
            <div className={styles.col}>
              <div className={styles.optionBox}>
                <input
                  id={index}
                  type="text"
                  value={option.optionText}
                  disabled={!isEditable}
                  onChange={(e) =>
                    onChangeOptionsProperty(index, e.target.value)
                  }
                  autoComplete="off"
                  required="required"
                ></input>
                <span className={styles.text}>
                  {option.correct ? 'Correct Answer' : 'Wrong Answer'}
                </span>
                {isEditable && (
                  <div className={styles['btn-div']}>
                    {optionList.length - 1 === index && (
                      <button
                        type="button"
                        className={styles.btn}
                        onClick={handleAddClick}
                        disabled={!isEditable}
                      >
                        Add
                      </button>
                    )}
                    {optionList.length !== 1 && (
                      <button
                        type="button"
                        className={styles.btn}
                        onClick={() => handleRemoveClick(index)}
                      >
                        Remove
                      </button>
                    )}
                  </div>
                )}
                <span className={styles.line}></span>
              </div>
            </div>
          </div>
        )
      })}
    </>
  )
}

export default Options
