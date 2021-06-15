import { NavLink } from 'react-router-dom'

import styles from './Header.module.css'
import Bar from '../../components-gui/Bar/Bar'

const Header = () => {
  return (
    <Bar className={styles.header}>
      <nav>
        <ul>
          <li>
            <NavLink activeClassName={styles.active} to="/about">
              About Assignment
            </NavLink>
          </li>
          <li>
            <NavLink activeClassName={styles.active} to="/game">
              Quiz Game
            </NavLink>
          </li>
          <li>
            <NavLink activeClassName={styles.active} to="/questions">
              Questions
            </NavLink>
          </li>
        </ul>
      </nav>
    </Bar>
  )
}

export default Header
