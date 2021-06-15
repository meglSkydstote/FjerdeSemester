function Dropdown(props) { //values:[[value,display],[],[]]

    function getOptions() {

        return props.values.map((element, index) => {
            return <option key={index} value={element[0]}>{element[1]}</option>
        })
    }

    function handleOnChange(event) {
        props.handleValue(event.target.value)
        
    }

    return (
        <div>
            <select style={{ width: "100px" }} onChange={handleOnChange}>
                {getOptions()}
            </select>
        </div>
    )
}
export default Dropdown