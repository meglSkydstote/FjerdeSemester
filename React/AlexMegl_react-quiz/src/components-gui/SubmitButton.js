const SubmitButton = ({ submitAction, isEnabled, styles }) => {
  return (
    <div className={styles.row100}>
      <div className={styles.col}>
        <div className={styles.inputBox}>
          <input
            className={styles.submit}
            type="submit"
            value="EXPLODE"
            disabled={!isEnabled}
            onClick={submitAction}
          ></input>
        </div>
      </div>
    </div>
  )
}

export default SubmitButton
