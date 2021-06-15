const QuestionService = {
  questionUrl: 'http://localhost:8096',

  getById: async (id) => {
    const response = await fetch(`http://localhost:8096/questions/${id}`)
    return await response.json()
  },

  createQuestion: async (question) => {
    await fetch(`http://localhost:8096/questions`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
      },
      body: JSON.stringify(question),
    })
  },

  updateQuestion: async (questionId, question) => {
    await fetch(`http://localhost:8096/questions/${questionId}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
      },
      body: JSON.stringify(question),
    })
  },
}

export default QuestionService
