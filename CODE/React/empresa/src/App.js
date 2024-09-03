import './App.css';
import React, { useState } from 'react';
import Navbar from './components/navbar';
import Data from './data/tareas.json'

function App() {

  const [data, setData] = useState(Data)


  return (
    <div className="w-full relative h-screen flex justify-center">
      <Navbar />
      <main className='w-1/2 h-fit p-4'>
        <h1 className='text-4xl text-center mt-20 font-bold'>Empresa</h1>
        {
          data.map((item) => {
            return (
              <div className='flex flex-col mt-4'>
                <h2 className='text-2xl font-bold'>{item.name}</h2>
                <p className='text-lg'>{item.description}</p>
              </div>
            )
          })
        }
      </main> 
    </div>
  );
}

export default App;
