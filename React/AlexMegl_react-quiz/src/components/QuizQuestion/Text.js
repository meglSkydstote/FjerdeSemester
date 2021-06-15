import styles from './Text.module.css'

const Text = (props) => {
  return (
    <div className={styles['text-area']}>
      <p className={styles.text}>{props.questionText}</p>
    </div>
  )
}

export default Text
