import { NavLink } from 'react-router-dom'

import styles from './QuestionLink.module.css'

const QuestionLink = ({ id }) => {
  return (
    <div className={styles.container}>
      <li className={styles.link} key={id}>
        <a className={styles.ref} href={`/questions/${id}`}>
          Question Id: {id}
        </a>
        <NavLink activeClassName={styles.active} to={`/questions/${id}/edit`}>
          <button className={styles.button} type="button">
            Edit
          </button>
        </NavLink>
      </li>
    </div>
  )
}

export default QuestionLink
