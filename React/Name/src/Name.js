import React from 'react'

class Name extends React.Component {
    constructor(props) {
        super(props)
        this.state = { firstName: "", lastName: "" }
    }

    getName = (user) => {
        if (user === "hans") {
            return { firstname: "Hans", lastName: "Hansen" }
        } else {
            return { firstname: "Peter", lastName: "Petersen" }
        }
    }

    componentDidMount() {

        const name = this.getName(this.props.userName)
        this.setState({ firstName: name.firstname, lastName: name.lastName })
    }

    componentDidUpdate(prevProps) {
        if (prevProps != this.props) {
            const name = this.getName(this.props.userName)
            this.setState({ firstName: name.firstname, lastName: name.lastName })
        }
    }

    render() {
        return (
            <div>
                <h1>First name: {this.state.firstName}</h1>
                <h1>Last name: {this.state.lastName}</h1>
            </div>
        )
    }
}
export default Name