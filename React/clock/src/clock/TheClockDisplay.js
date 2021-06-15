import React from 'react'
class TheClockDisplay extends React.Component {
    constructor(props) {
        super(props)
    }
    formatTime(date) {
        return this.leadingZero(this.props.date.getHours()) + " : " + this.leadingZero(this.props.date.getMinutes()) + " : " + this.leadingZero(this.props.date.getSeconds())
    }

    leadingZero(number) {
        return ("0" + number).slice(-2);
    }
    render() {
        return (
            <h1>{this.formatTime(this.props.date)}</h1>
        )
    }

}
export default TheClockDisplay