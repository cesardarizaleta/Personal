import React from "react";

export default function Subtarea({ name, description }) {
    return (
        <section className='flex-col sub bg-blue-100 p-4 rounded-md w-full h-fit'>
            <h2 className='text-xl font-bold'>{name}</h2>
            <p className='text-md'>{description}</p>
        </section>
    )
}