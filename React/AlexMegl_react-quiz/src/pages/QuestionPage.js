import { useState, useEffect } from 'react'
import { useParams, useRouteMatch, Link } from 'react-router-dom'
import { UrlConsume } from '../context/url-context'

import Question from '../components/Question/Question'
import Options from '../components/Question/Options'
import SubmitButton from '../components-gui/SubmitButton'

import Services from '../services/Services'
import styles from './QuestionPage.module.css'
import Card from '../components-gui/Card'

const QuestionPage = (props) => {
  const { questionId } = useParams()
  const { path } = useRouteMatch()
  const [question, setQuestion] = useState(null)
  const questionUrl = UrlConsume().questionUrl
  const [isEditable, setIsEditable] = useState(props.editable)
  const [optionList, setOptionList] = useState([
    { optionText: '', correct: true },
    { optionText: '', correct: false },
  ])

  const [hasFetched, setHasFetched] = useState(0) // Bruger den til at begrænse genkald af setOptionList

  useEffect(() => {
    async function fetchData() {
      const question = await Services.question.getById(questionId)
      setQuestion(question)
    }

    if (!question && questionId) fetchData()
    if (question && hasFetched === 0) {
      setOptionList(question.options)
      setHasFetched(1)
    }
    if (!isEditable) setIsEditable(path.match(/([^/])+$/)[0] === 'edit') // if path ends with /edit
  }, [
    question,
    setQuestion,
    questionId,
    setIsEditable,
    path,
    questionUrl,
    optionList,
    hasFetched,
    isEditable,
  ])

  // Keeps the question state immutable
  const onChangeQuestionProperty = (property, value) => {
    let newQuestion = null
    if (!question) {
      newQuestion = {
        category: '',
        questionText: '',
        field: '',
        points: 1,
        explanation: '',
        source_url: '',
        options: optionList,
      }
    } else newQuestion = { ...question }
    newQuestion[property] = value
    setQuestion(newQuestion)
  }

  const submitQuestion = async (e) => {
    e.preventDefault() // disable page reload
    const questionToSubmit = { ...question, options: [...optionList] }

    // Update or create question
    questionId != null
      ? await Services.question.updateQuestion(questionId, questionToSubmit)
      : await Services.question.createQuestion(questionToSubmit)

    // >:( dårlig løsning
    window.location.href = '/questions'
  }

  return (
    <Card>
      <form onSubmit={submitQuestion}>
        <Question
          question={question}
          styles={styles}
          onChangeQuestionProperty={onChangeQuestionProperty}
          isEditable={isEditable}
        >
          <Options
            optionList={optionList}
            setOptionList={setOptionList}
            styles={styles}
            isEditable={isEditable}
          />
          <Link to="/questions">
            <SubmitButton
              submitAction={submitQuestion}
              isEnabled={isEditable}
              styles={styles}
            />
          </Link>
        </Question>
      </form>
    </Card>
  )
}

export default QuestionPage
