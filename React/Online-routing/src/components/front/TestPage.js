import React from 'react'
import { Redirect } from 'react-router-dom'
class TestPage extends React.Component {
    constructor(props) {
        super(props)
        this.state = { redirect: false }
    }

    handleOnClick = () => {
        this.props.history.push("/about")
    }

    handleGed = () => {
        console.log("KÆLJÆLSKÆLK")
        this.setState({ redirect: true })
    }

    render() {

        if (this.state.redirect) {
            return (<Redirect to="/about" />)
        }

        return (<div>
            TEST PAGE
            < button onClick={this.handleOnClick} > HEST</button >
            < button onClick={this.handleGed} > GED</button >
        </div >)
    }
}
export default TestPage