import React from "react";

export default function Tarea({ name, description }) {
    return (
        <section className='flex flex-col bg-blue-50 p-4 rounded-md w-full h-fit'>
            <h2 className='text-2xl font-bold'>{name}</h2>
            <p className='text-lg'>{description}</p>
        </section>
    );
}