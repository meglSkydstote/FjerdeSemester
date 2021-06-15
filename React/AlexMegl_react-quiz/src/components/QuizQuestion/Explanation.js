import styles from './Explanation.module.css'

const Explanation = (props) => {
  const explanation = props.explanation
  const source = props.source
  const nextQuestionHandler = () => {
    props.onNextQuestion()
    props.setAnswer(null)
  }

  return (
    <div className={styles.explanation}>
      <p>{explanation}</p>
      <br />
      <div className={styles['source-next']}>
        <span>
          Source: <a href={source}>{source}</a>
        </span>
        <button className={styles.button} onClick={nextQuestionHandler}>
          Next
        </button>
      </div>
    </div>
  )
}

export default Explanation
