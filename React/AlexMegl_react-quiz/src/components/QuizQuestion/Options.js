import Option from './Option.js'

import styles from './Options.module.css'

const Options = (props) => {
  const onAnswerChosen = props.onAnswerChosen

  const optionComponent = ({ id, optionText }) => (
    <Option
      key={id}
      id={id}
      optionText={optionText}
      onAnswerChosen={onAnswerChosen}
    />
  )

  const options = props.options
    .map((val) => optionComponent(val))

  return <div className={styles.options}>{options}</div>
}

export default Options
