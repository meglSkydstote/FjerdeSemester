import Name from './Name'
import { useState } from "react"
function NameApp() {
    const [user,setUser]=useState("hans")


    const handleClick=(event)=>{
        setUser("peter")
    }

    return (
        <div>
            <Name userName={user} />
            <button onClick={handleClick}>Change User</button>
        </div>
    )
}
export default NameApp