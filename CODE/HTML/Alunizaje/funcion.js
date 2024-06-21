cohete = document.getElementById('cohete')
piso = document.getElementById('piso')
controlador = document.getElementById('controlador')


//Obtener posicion
//console.log(cohete.getBoundingClientRect())

function onKeyDownHandler(event) {

    aumentarD = cohete.getBoundingClientRect().x
    aumentarA = cohete.getBoundingClientRect().x
    aumentarW = cohete.getBoundingClientRect().y
    aumentarS = cohete.getBoundingClientRect().y

    var codigo = event.which || event.keyCode;

    //Codigo WASD 
    //A = 65 S = 83 D = 68 W = 87

     if(codigo==68){
        aumentarD += 5
        cohete.style.transform="translateX("+String(aumentarD)+ "px)"
     }
     else if(codigo == 65){
        aumentarA -= 5
        cohete.style.transform="translateX("+String(aumentarA)+ "px)"
     }
}