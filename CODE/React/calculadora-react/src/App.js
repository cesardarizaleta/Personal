import Botones from './botones'
import './calculadora.css'



function App() {

  return (
    //Test
    //Ese <> sirve para un div vacio\
    <div className='body'>
      <input readOnly></input>
      <Botones />
    </div>
  );
}

export default App;

console.log(document.querySelectorAll('button'))

document.querySelectorAll('button').forEach(button => {
  button.addEventListener('click', function () {
    if(this.innerText === '=') {
      document.querySelector('input').value = eval(document.querySelector('input').value)
      return
    }
    if(this.innerText === 'C') {
      document.querySelector('input').value = ''
      return
    }
    else {
      document.querySelector('input').value += this.innerText
    }
  })
})