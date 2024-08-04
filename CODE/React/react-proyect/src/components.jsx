import React, {useState} from 'react'
//Usar estados
// import React, { useState } from 'react'

export default function Components() {
    const [text, setText] = useState()

    const textOnChange = (event) => {
        setText(event.target.value)
    }

    return (
        <div>
            <input type="text" value={text} onChange={textOnChange} />
            <p>Texto: {text}</p>
        </div>
    )
}
