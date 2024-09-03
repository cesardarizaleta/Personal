import './App.css';
import Background from './components/background';
import React from 'react';
import Downloader from './components/downloader';

function App() {

  return (
    <div className="App">
      <Background />
      <main className='flex justify-center items-center w-screen h-screen flex-col
      text-white gap-4'>
        <h1 className='font-bold text-3xl'>Youtube Downloader</h1>
        <Downloader />
      </main>
    </div>
  );
}

export default App;
