import { Route, Switch } from 'react-router-dom'
import { UrlProvider } from './context/url-context'

import Header from './components/Header/Header'
import Footer from './components/Footer/Footer'
import AboutAssignmentPage from './pages/AboutAssignmentPage'
import GamePage from './pages/GamePage'
import QuestionsRoutingPage from './pages/QuestionsRoutingPage'
import NoMatchPage from './pages/NoMatchPage'

import styles from './App.css'

function App() {
  return (
    <div className="App">
      <Header />
      <div className={(styles.body, 'content')}>
        <UrlProvider>
          <Switch>
            <Route path="/about">
              <AboutAssignmentPage />
            </Route>
            <Route path="/game">
              <GamePage />
            </Route>
            <Route path="/questions">
              <QuestionsRoutingPage />
            </Route>
            <Route path="/">
              <h1>Home</h1>
            </Route>
            <Route>
              <NoMatchPage />
            </Route>
          </Switch>
        </UrlProvider>
      </div>
      <Footer />
    </div>
  )
}

export default App
