import Clock from "./components/clock/Clock";

import { useState } from 'react'
function App() {
    const [mounted, setMounted] = useState(true)

    function handleMount() {
        setMounted(prevState => !prevState)
    }

    if (mounted) {
        return (
            <div >
                <Clock />
                <button onClick={handleMount}>UNMOUNT</button>
            </div>

        )
    }
    return (
        <div >

            <button onClick={handleMount}>UNMOUNT</button>
        </div>

    )
}


export default App;
