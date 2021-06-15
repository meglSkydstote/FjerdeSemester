import Dropdown from "../dropdown/Dropdown"
import './alarm.css'
import { useState } from 'react'
function Alarm(props) {

    const [active, setActive] = useState(false)
    const [hours, setHours] = useState(0)
    const [minutes, setMinutes] = useState(0)


    const hoursArray = Array(24).fill().map((element, index) => [index, ("0" + index).slice(-2)])
    const minutesArray = Array(60).fill().map((element, index) => [index, ("0" + index).slice(-2)])

    function handleActive(event) {
        setActive(event.target.checked)
    }
    function handleHours(value) {
        setHours(value)
    }

    function handleMinutes(value) {
        setMinutes(value)
    }

    function save() {
        let date = new Date()
        date.setHours(hours)
        date.setMinutes(minutes)
        date.setSeconds(0)
        props.updateAlarm(date, active)
    }



    return (
        <div>
            <label>ACTIVE</label>
            <input type='checkbox' checked={active} onChange={handleActive} />
            <div className="alarm">

                <Dropdown values={hoursArray} handleValue={handleHours} />
                <Dropdown values={minutesArray} handleValue={handleMinutes} />
            </div>
            <button onClick={save}>SAVE</button>
        </div>
    )
}
export default Alarm