import './App.css';
import {BrowserRouter, Routes, Route, Link, NavLink} from 'react-router-dom';
import Get from './get';

function App() {
  return (
    <BrowserRouter>
      <nav>
        <ul>
          <li>
            <NavLink to="/">Home</NavLink>
          </li>
          <li>
            <NavLink to="get">Get Started</NavLink>
          </li>
        </ul>
      </nav>
      <main>
        <Routes>
          <Route index path="/" element={<h1>Home</h1>} />
          <Route path="/get" element={<Get />} />
        </Routes>
      </main>
    </BrowserRouter>
  );
}

export default App;
