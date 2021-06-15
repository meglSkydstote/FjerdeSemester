const QuizService = {
  questionUrl: 'http://localhost:8096',

  getQuestionIds: async () => {
    const response = await fetch(`http://localhost:8096/quiz`, {})
    const ids = await response.json()
    return ids
  },

  getQuestionById: async (id) => {
    const response = await fetch(`http://localhost:8096/quiz/${id}`)
    return await response.json()
  },

  getAnswerByQuestionAndOptionId: async (questionId, optionId) => {
    const response = await fetch(
      `http://localhost:8096/quiz/${questionId}/answer?optionId=${optionId}`,
      {
        method: 'POST',
      }
    )
    return await response.json()
  },
}

export default QuizService
