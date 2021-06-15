import ClockDisplay from './TheClockDisplay'
import React from "react";
import Alarm from './TheAlarm'
class TheClock extends React.Component {
    constructor() {
        super()
        this.state = { time: new Date(), intervalId: null, alarmIsOn: false, alarm: { time: new Date(), active: false } }
    }

    updateTime = () => {
        const date = new Date()
        if (this.state.alarm.active && (this.state.alarm.time <= date)) {
            this.soundAlarm()
        }
        this.setState({ time: date })
    }
    soundAlarm = () => {
        this.setState((prevState) => {
            return { alarmIsOn: true, alarm: { time: prevState.alarm.time, active: false } }
        })

        setTimeout(this.shutOffAlarm, 10000)
    }

    shutOffAlarm = () => {
        this.setState({ alarmIsOn: false })
    }

    componentDidMount() {
        const id = setInterval(this.updateTime, 1000);
        this.setState({ intervalId: id })
    }

    componentWillUnmount() {
        clearInterval(this.state.intervalId);
    }

    saveAlarm = (hour, minute, active) => {
        let date = new Date();
        date.setHours(hour)
        date.setMinutes(minute)
        date.setSeconds(0)
        this.setState({ alarm: { time: date, active: active } })
    }
    render() {

        return (
            <div style={this.state.alarmIsOn ? { backgroundColor: "red" } : { backgroundColor: "white" }}>
                <ClockDisplay date={this.state.time} />
                <Alarm alarm={{ hour: this.state.alarm.time.getHours(), minute: this.state.alarm.time.getMinutes(), active: this.state.alarm.active }} saveAlarm={this.saveAlarm} />
            </div>
        )
    }
}
export default TheClock