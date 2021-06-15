import React from 'react'
import SelectBox from '../select/SelectBox'
class TheAlarm extends React.Component {
    constructor(props) {
        super(props)
        this.state = { hour: this.props.alarm.hour, minute: this.props.alarm.minute, active: this.props.alarm.active }
    }

    hours = Array(24).fill().map((element, index) => [index, ("0" + index).slice(-2)])
    minutes = Array(60).fill().map((element, index) => [index, ("0" + index).slice(-2)])

    handleOnClick = (event) => {
        this.props.saveAlarm(this.state.hour, this.state.minute, this.state.active)
    }

    handleAlarmHours = (hour) => {
        this.setState({ hour: hour })
    }

    handleAlarmMinutes = (minute) => {
        this.setState({ minute: minute })
    }
    handleCheckbox = (event) => {
        const checked = event.target.checked
        this.setState({ active: checked })
    }
    shouldComponentUpdate(nextProps, nextState) {
        if (JSON.stringify(nextState) !== JSON.stringify(this.state) || nextProps.alarm.active !== this.props.alarm.active) {
            return true
        }
        return false
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if (this.props.alarm.active != prevProps.alarm.active) {
            this.setState({ active: this.props.alarm.active })
        }
    }

    render() {
        return (
            <div>
                <SelectBox data={this.hours} default={this.props.alarm.hour} onChange={this.handleAlarmHours} />
                <SelectBox data={this.minutes} default={this.props.alarm.minute} onChange={this.handleAlarmMinutes} />
                <label> Activated</label>
                <input type="checkbox" onChange={this.handleCheckbox} checked={this.state.active} />
                <button onClick={this.handleOnClick}> Save </button>
            </div>
        )
    }
}
export default TheAlarm 