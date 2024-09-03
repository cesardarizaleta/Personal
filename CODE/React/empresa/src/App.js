import './App.css';
import React from 'react';
import Navbar from './components/navbar';

function App() {
  return (
    <div className="w-full relative h-screen flex justify-center">
      <Navbar />
      <main className='w-1/2 h-full'>
        <h1 className='text-4xl text-center mt-20'></h1>
      </main> 
    </div>
  );
}

export default App;
