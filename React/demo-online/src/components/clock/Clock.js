import { useState, useEffect } from 'react'
import Dropdown from '../dropdown/Dropdown'
import Alarm from './Alarm'
import ClockDisplay from './ClockDisplay'
function Clock() {
    const [time, setTime] = useState(new Date())
    const [alarm, setAlarm] = useState({ time: null, active: false })
    const [soundAlarm, setSoundAlarm] = useState(false)

    useEffect(() => {
        console.log("USEEFFECT CALLED")
        const interval = setInterval(increaseTime, 2000)

        return () => {
            console.log("CLEAN UP")
            clearInterval(interval)
        }
    }, [alarm])

    function increaseTime() {
        console.log("TICK")
        const date = new Date()
        setTime(date)
        checkAlarm(date)
    }

    function checkAlarm(date) {

        if (alarm.active) {
            if (date >= alarm.time && date <= new Date(date.getTime() + 10)) {
                setAlarm(prevState => { return { time: prevState.time, active: false } })
                doSoundAlarm()
            }
        }
    }

    function doSoundAlarm() {
        setSoundAlarm(true)
        setTimeout(() => { setSoundAlarm(false) }, 5000)
    }


    function saveAlarm(time, active) {

        setAlarm({ time: time, active: active })
    }


    return (

        <div>

            {soundAlarm && <div style={{ backgroundColor: "red" }}>ALARM ALARM</div>}
            <Alarm updateAlarm={saveAlarm} />
            <ClockDisplay time={{ hours: time.getHours(), minutes: time.getMinutes(), seconds: time.getSeconds() }} />
        </div>
    )
}
export default Clock