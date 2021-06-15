import styles from './NoMatchPage.module.css'

const NoMatchPage = () => {
  const pathname = window.location.pathname
  return (
    <div className={styles.noMatch}>
      <div className={styles.noMatchDiddle}>
        <h3 className={styles['noMatch-text']}>
          No match for path: {pathname}
        </h3>
      </div>
    </div>
  )
}

export default NoMatchPage
