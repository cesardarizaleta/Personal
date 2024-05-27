//Obtener Valores por su Clase
//console.log(document.getElementsByClassName('inputs'))

//Obtener Valor por su ID
//console.log(document.getElementById('title'))

let inputs = document.getElementsByClassName('inputs')

//Obtener valor de input
console.log(inputs[0].value)

//Ejemplo Ciclo
//	for(i = 0; i < 10;i++){
//		console.log(i)
//	}

inputs[0].value = 57
inputs[1].value = 'Hola'

//Recorriendo inputs al darle al boton
function alerta(){
	for(let i=0;i <= inputs.length - 1;i++){
		console.log(inputs[i].value)
	}
}