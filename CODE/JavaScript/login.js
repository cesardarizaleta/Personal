//Obtener Valores por su Clase
//console.log(document.getElementsByClassName('inputs'))

//Obtener Valor por su ID
//console.log(document.getElementById('title'))

let inputs = document.getElementsByClassName('inputs')

//Obtener valor de input
//console.log(inputs[0].value)

//Ejemplo Ciclo
//	for(i = 0; i < 10;i++){
//		console.log(i)
//	}

//Recorriendo inputs al darle al boton
//Creando funcion
function alerta(){

	//Validando inputs Vacios
	let n = 0

	for(let i=0;i <= inputs.length - 1;i++){
		if(inputs[i].value === ''){
			break
		}
		else{
			n += 1
		}
	}

	if(n == inputs.length){
		alert('Correcto')
	}
}

//Funcion Anonima
//	btn.addEventListener("click",
//		function(){
//			//Agregar
//		})








