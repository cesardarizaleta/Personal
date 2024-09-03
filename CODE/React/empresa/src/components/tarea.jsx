import React from "react";
import './tarea.css'

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
        <section onClick={displaySub} className='flex flex-col gap-2 bg-blue-50 p-4 rounded-md w-full h-fit'>
            <h2 className='text-2xl font-bold'>{name}</h2>
            <p className='text-lg'>{description}</p>
            {
                subtareas.map((item) => 
                    <section className='flex-col sub bg-blue-100 p-4 rounded-md w-full h-fit'>
                        <h2 className='text-xl font-bold'>{item.name}</h2>
                        <p className='text-md'>{item.description}</p>
                    </section>
                )
            }
        </section>
    );
}