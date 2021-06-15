import './clock.css'
function ClockDisplay(props) {
    return (
        <div className="clock">
            {props.time.hours}:{props.time.minutes}:{props.time.seconds}
        </div>
    )
}
export default ClockDisplay