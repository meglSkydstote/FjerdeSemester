import React from 'react'
import Clock from './TheClock'
class TheClockApp extends React.Component {
    constructor() {
        super()
        this.state = { mounted: true }
    }
    handleOnClick = (event) => {
        this.setState((prevState) => { return { mounted: !prevState.mounted } })
    }

    render() {
        if (this.state.mounted) {
            return (
                <>
                    <Clock />
                    <button onClick={this.handleOnClick}>UNMOUNT</button>
                </>
            )
        } else {
            return (
                <>
                    <button onClick={this.handleOnClick}>UNMOUNT</button>
                </>
            )
        }
    }
}
export default TheClockApp