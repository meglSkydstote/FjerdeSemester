import styles from './Option.module.css'

const Option = (props) => {
  const optionText = props.optionText

  const onAnswer = () => {
    props.onAnswerChosen(props.id)
  }

  if (props.onAnswerChosen === true) {
    return (
      <div value={optionText} className={styles.option}>
        <div className={styles['option-text']}>{optionText}</div>
      </div>
    )
  }

  return (
    <div value={optionText} onClick={onAnswer} className={styles.option}>
      <div className={styles['option-text']}>{optionText}</div>
    </div>
  )
}

export default Option
