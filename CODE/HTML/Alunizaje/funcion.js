cohete = document.getElementById('cohete')
piso = document.getElementById('piso')
controlador = document.getElementById('controlador')
aumentarD = 0

//Obtener posicion
//console.log(cohete.getBoundingClientRect())

function onKeyDownHandler(event) {

    var codigo = event.which || event.keyCode;

    //Codigo WASD 
    //A = 65 S = 83 D = 68 W = 87

     if(codigo==68){
        aumentarD += 5
        cohete.style.transform="translateX("+String(aumentarD)+ "px)"
     }
}