import { Switch, Route, useHistory } from 'react-router-dom'
import About from '../about/About'
import FrontPage from '../front/FrontPage'
import TestPage from '../front/TestPage'

function Main() {
    return (
        <div className="main">
            <Switch>

                <Route path="/test" component={TestPage}></Route>
                <Route path="/about" component={About}></Route>
                <Route path="/kat" ><FrontPage /></Route>
                <Route path="/" render={() => <FrontPage />}></Route>
                <Route path="/" ><FrontPage /></Route>
            </Switch>

        </div>
    )
}
export default Main