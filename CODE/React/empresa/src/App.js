import './App.css';
import React, { useState } from 'react';
import Navbar from './components/navbar';
import Data from './data/tareas.json'
import Tarea from './components/tarea';

function App() {

  const [data, setData] = useState(Data)


  return (
    <div className="w-full relative h-screen flex justify-center">
      <Navbar />
      <main className='w-1/2 h-fit p-4 flex flex-col gap-4'>
        <h1 className='text-4xl text-center mt-20 font-bold'>Empresa</h1>
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
