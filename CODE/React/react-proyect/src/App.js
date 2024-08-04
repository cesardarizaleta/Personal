//import logo from './logo.svg';
import './App.css';
//import Components from './components';
//Creando Navbar components
import Navbar from './navbar';
//Primero Importarlo y despues usarlo

//Se puede unir con el export de abajo
function App() {
  return (
    <>
      <Navbar />
      <h1>React</h1>
    </>
  );
}

export default App;
