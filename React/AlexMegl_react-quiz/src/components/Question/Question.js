import styles from '../../pages/QuestionPage.module.css'

const Question = (props) => {
  const onChangeHandler = (property, value) => {
    props.onChangeQuestionProperty(property, value)
  }

  return (
    <div className={styles.body}>
      <div className={styles.container}>
        <h2>{props.question ? props.question.questionText : ''}</h2>
        <div className={styles.row100}>
          <div className={styles.col}>
            <div className={styles.inputBox}>
              <input
                type="text"
                value={props.question ? props.question.category : ''}
                onChange={(e) => onChangeHandler('category', e.target.value)}
                disabled={!props.isEditable}
                required="required"
              ></input>
              <span className={styles.text}>Category</span>
              <span className={styles.line}></span>
            </div>
          </div>

          <div className={styles.col}>
            <div className={styles.inputBox}>
              <input
                type="text"
                value={props.question ? props.question.questionText : ''}
                onChange={(e) =>
                  onChangeHandler('questionText', e.target.value)
                }
                disabled={!props.isEditable}
                required="required"
              ></input>
              <span className={styles.text}>Question Text</span>
              <span className={styles.line}></span>
            </div>
          </div>
        </div>

        <div className={styles.row100}>
          <div className={styles.col}>
            <div className={styles.inputBox}>
              <input
                type="text"
                value={props.question ? props.question.field : ''}
                onChange={(e) => onChangeHandler('field', e.target.value)}
                disabled={!props.isEditable}
                required="required"
              ></input>
              <span className={styles.text}>Field</span>
              <span className={styles.line}></span>
            </div>
          </div>

          <div className={styles.col}>
            <div className={styles.inputBox}>
              <input
                type="number"
                min="1"
                step="1"
                value={props.question ? props.question.points : ''}
                onChange={(e) => onChangeHandler('points', e.target.value)}
                disabled={!props.isEditable}
                required="required"
              ></input>
              <span className={styles.text}>Points</span>
              <span className={styles.line}></span>
            </div>
          </div>
        </div>

        <div className={styles.row100}>
          <div className={styles.col}>
            <div className={styles.inputBox}>
              <input
                type="text"
                value={props.question ? props.question.explanation : ''}
                onChange={(e) => onChangeHandler('explanation', e.target.value)}
                disabled={!props.isEditable}
                required="required"
              ></input>
              <span className={styles.text}>Explanation</span>
              <span className={styles.line}></span>
            </div>
          </div>
        </div>
        <div className={styles.row100}>
          <div className={styles.col}>
            <div className={styles.inputBox}>
              <input
                type="text"
                value={props.question ? props.question.source_url : ''}
                onChange={(e) => onChangeHandler('source_url', e.target.value)}
                disabled={!props.isEditable}
                required="required"
              ></input>
              <span className={styles.text}>Source</span>
              <span className={styles.line}></span>
            </div>
          </div>
        </div>
        {props.children}
      </div>
    </div>
  )
}

export default Question
