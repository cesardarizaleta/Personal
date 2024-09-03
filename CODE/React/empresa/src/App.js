import './App.css';
import React, { useState } from 'react';
import Data from './data/tareas.json'
import Tarea from './components/tarea';

function App() {

  const [data, setData] = useState(Data)

  function addTarea() {
    let name = document.querySelector('input[placeholder="Nombre de la Tarea"]').value
    let description = document.querySelector('input[placeholder="Descripcion de la Tarea"]').value
    const newData = [...data, {name, description}]
    setData(newData)
    Data.push({name, description})
    console.log(Data)
    document.querySelector('input[placeholder="Nombre de la Tarea"]').value = ''
    document.querySelector('input[placeholder="Descripcion de la Tarea"]').value = ''
    alert('Tarea Agregada')
  }

  return (
    <div className="w-full relative h-screen flex justify-center">
      <main className='md:w-1/2 h-fit p-4 flex flex-col gap-4'>
        <h1 className='text-4xl text-center mt-20 font-bold'>Empresa</h1>
        <input className='w-full border p-2 rounded-md outline-none' placeholder='Nombre de la Tarea'></input>
        <input className='w-full border p-2 rounded-md outline-none' placeholder='Descripcion de la Tarea'></input>
        <button onClick={addTarea} className='w-full bg-blue-500 text-white p-2 rounded-md'>Agregar Tarea</button>
        {
          data.map((item) => 
            <Tarea key={item.id} name={item.name} description={item.description} />
          )
        }
      </main> 
    </div>
  );
}

export default App;
