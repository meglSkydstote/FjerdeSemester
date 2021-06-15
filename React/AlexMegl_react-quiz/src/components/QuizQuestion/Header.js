import styles from './Header.module.css'

const Header = (props) => {
  return (
    <div className={styles.header}>
      <div className={styles.category}>{props.category}</div>
      <div className={styles.field}>{props.field}</div>
      <div className={styles.points}>Point: {props.points}</div>
    </div>
  )
}

export default Header
