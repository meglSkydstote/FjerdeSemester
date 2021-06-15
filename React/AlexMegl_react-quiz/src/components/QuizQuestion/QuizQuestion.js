import { useState } from 'react'

import Header from './Header.js'
import Text from './Text.js'
import Options from './Options.js'
import Explanation from './Explanation'

import Services from '../../services/Services'
import styles from './QuizQuestion.module.css'

const QuizQuestion = (props) => {
  const [getAnswer, setAnswer] = useState(null)
  const questionId = props.questions.id
  const points = props.questions.points

  const answerChosenHandler = async (chosenId) => {
    if (getAnswer) return null

    const resAnswer = await Services.quiz.getAnswerByQuestionAndOptionId(
      questionId,
      chosenId
    )

    setAnswer({
      correct: resAnswer.correct,
      explanation: resAnswer.explanation,
      source_url: resAnswer.source_url,
    })
    updatePoints(resAnswer.correct ? points : 0)
  }

  const updatePoints = (change) => {
    props.setPoints((prevState) => {
      return (prevState += change)
    })
  }

  const answerStyling =
    getAnswer !== null
      ? !getAnswer.correct
        ? styles.questionWrong
        : styles.questionCorrect
      : styles.question

  return (
    <div className={answerStyling}>
      <Header
        category={props.questions.category}
        field={props.questions.field}
        points={props.questions.points}
      />
      <Text questionText={props.questions.questionText} />
      <Options
        onAnswerChosen={answerChosenHandler}
        options={props.questions.options}
      />
      {getAnswer != null && (
        <Explanation
          setAnswer={setAnswer}
          explanation={getAnswer.explanation}
          source={getAnswer.source_url}
          onNextQuestion={props.onNextQuestion}
        />
      )}
    </div>
  )
}

export default QuizQuestion
