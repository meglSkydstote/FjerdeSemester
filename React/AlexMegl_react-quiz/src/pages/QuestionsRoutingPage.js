import { Switch, Route, useRouteMatch } from 'react-router-dom'

import QuestionPage from './QuestionPage.js'
import QuestionsPage from './QuestionsPage.js'

const QuestionsRoutingPage = () => {
  const { path } = useRouteMatch()

  return (
    <div>
      <Switch>
        <Route path={`${path}/create`}>
          <QuestionPage editable={true} />
        </Route>
        <Route path={`${path}/:questionId/edit`}>
          <QuestionPage />
        </Route>
        <Route path={`${path}/:questionId`}>
          <QuestionPage />
        </Route>
        <Route exact path={path}>
          <QuestionsPage />
        </Route>
        <Route>
          <h1>Not found</h1>
        </Route>
      </Switch>
    </div>
  )
}

export default QuestionsRoutingPage
