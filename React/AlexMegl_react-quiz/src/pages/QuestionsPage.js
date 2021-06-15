import { useState, useEffect } from 'react'
import { NavLink } from 'react-router-dom'

import QuestionLink from '../components/Question/QuestionLink'

import Services from '../services/Services'
import styles from './QuestionsPage.module.css'
import Card from '../components-gui/Card'

const QuestionsPage = () => {
  const [questions, setQuestions] = useState(null)
  useEffect(() => {
    async function fetchQuestions() {
      const questions = await Services.quiz.getQuestionIds()
      setQuestions(questions)
    }
    if (questions === null) fetchQuestions()
  }, [questions])

  const questionsList = (questions) => {
    return questions.map((id) => <QuestionLink key={id} id={id} />)
  }

  return (
    <Card>
      {questions ? (
        <ul className={styles.background}> {questionsList(questions)} </ul>
      ) : (
        <p>No Questions</p>
      )}
      <NavLink to="/questions/create">
        <button className={styles.button}>Create</button>
      </NavLink>
    </Card>
  )
}

export default QuestionsPage
