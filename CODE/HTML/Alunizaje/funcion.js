cohete = document.getElementById('cohete')
piso = document.getElementById('piso')

//Obtener posicion
//console.log(cohete.getBoundingClientRect())

function onKeyDownHandler(event) {

    var codigo = event.which || event.keyCode;

    console.log("Presionada: " + codigo);
     
    if(codigo === 13){
      console.log("Tecla ENTER");
    }

    if(codigo >= 65 && codigo <= 90){
      console.log(String.fromCharCode(codigo));
    }

     
}