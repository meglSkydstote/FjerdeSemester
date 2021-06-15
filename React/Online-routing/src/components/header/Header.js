import { useState } from 'react'
import { Link, Redirect, useHistory } from 'react-router-dom'

function Header() {
    const history = useHistory()
    const [redirect,setRedirect]=useState(false)


    function handleOnClick() {
        history.push("/test")
    }

    function handleRedirect() {
        setRedirect(true)
    }


    if (redirect) {
        return (<Redirect to="/about" />)
    }

    return (
        <div className="header">
            <Link to="/about">HEADER</Link>
            <button onClick={handleOnClick}>GOTO TESTPAGE</button>
            <button onClick={handleRedirect}>ACTIVATE REDIRECT</button>
        </div>
    )
}
export default Header