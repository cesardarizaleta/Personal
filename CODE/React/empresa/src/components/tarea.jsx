import React from "react";
import './tarea.css'
import Subtarea from './subtarea'

export default function Tarea({ name, description, subtareas = [] }) {

    function displaySub(e) {
        const sub = e.target.querySelectorAll('.sub')
        sub.forEach((item) => {
            if (item.style.display === 'none') {
                item.style.display = 'flex'
            } else {
                item.style.display = 'none'
            }
        })
    }

    return (
        <section onClick={displaySub} className='flex cursor-pointer flex-col gap-2 bg-blue-50 p-4 rounded-md w-full h-fit'>
            <h2 className='text-2xl w-fit h-fit font-bold'>{name}</h2>
            <p className='text-lg w-fit h-fit'>{description}</p>
            {
                subtareas.map((item) => 
                    <Subtarea name={item.name} description={item.description} />
                )
            }
        </section>
    );
}