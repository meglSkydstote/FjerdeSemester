import React from 'react'
import './selectBox.css'
class SelectBox extends React.Component {
    constructor(props) {
        super(props)
    }

    getOptions() {
        return this.props.data.map(([value, display]) => <option key={value} value={value} >{display}</option>)
    }

    handleonChange=(event) =>{
        if (this.props.onChange) {
            const { value } = event.target
            this.props.onChange(value)
        }
    }

    render() {

        return (
            <div className="custom-select">
                <label className="drop-list-label">{this.props.label}</label>
                <select onChange={this.handleonChange} defaultValue={this.props.default}>
                    {this.getOptions()}
                </select>
            </div>
        )
    }
}
export default SelectBox