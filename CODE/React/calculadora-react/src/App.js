import Botones from './botones'
import './calculadora.css'

function App() {
  return (
    //Ese <> sirve para un div vacio
    <div className='body'>
      <input readOnly></input>
      <Botones />
    </div>
  );
}

export default App;
