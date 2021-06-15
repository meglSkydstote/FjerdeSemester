import { useRef, useState } from 'react'

import QuizQuestion from '../components/QuizQuestion/QuizQuestion'

import Services from '../services/Services'
import styles from './GamePage.module.css'
import Card from '../components-gui/Card'

const GamePage = () => {
  const [currentQuestion, setCurrentQuestion] = useState(null)
  const [points, setPoints] = useState(-1)
  const queueQuestionIds = useRef()

  const nextQuestionHandler = async () => {
    const questionId = queueQuestionIds.current.pop()

    const question = questionId
      ? await Services.quiz.getQuestionById(questionId)
      : null
    setCurrentQuestion(question)
  }

  const startQuiz = async () => {
    setPoints(0)
    queueQuestionIds.current = await Services.quiz.getQuestionIds()
    queueQuestionIds.current.sort(() => Math.floor(Math.random() * 2) - 1) // "Randomize"
    nextQuestionHandler()
  }

  const questionComponent = (
    <QuizQuestion
      setNextQuestion={setCurrentQuestion}
      onNextQuestion={nextQuestionHandler}
      questions={currentQuestion}
      setPoints={setPoints}
    />
  )

  const newQuizComponent = (
    <Card>
      <div className={styles.container}>
        <button className={styles.button} onClick={startQuiz}>
          New Quiz!
        </button>
        {points !== -1 ? (
          points !== 0 ? (
            <div className={styles.points}>
              YOU WON BIG POINTS! maybe? : {points}
            </div>
          ) : (
            <div className={styles.points}>You're not that smart</div>
          )
        ) : (
          <></>
        )}
      </div>
    </Card>
  )

  return (
    <div>{currentQuestion !== null ? questionComponent : newQuizComponent}</div>
  )
}

export default GamePage
