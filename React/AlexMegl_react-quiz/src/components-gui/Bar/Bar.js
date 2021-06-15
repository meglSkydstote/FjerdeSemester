import styles from './Bar.module.css'

const Bar = ( { children, className } ) => {

  return (
      <div className={`${styles.bar} ${className}`}>
        { children }
      </div>
    )
}

export default Bar
