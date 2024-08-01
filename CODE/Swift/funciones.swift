//FUNCIONES
func saludar() {
    print("Hola")
}

func saludar(nombre: String) {
    print("Hola \(nombre)")
}

//LLAMAR FUNCIONES
saludar()

saludar(nombre: "Cesar")

//RETORNAR VALORES
func sumar(a: Int, b: Int) -> Int {
    return a + b
}

var resultado = sumar(a: 5, b: 5)

print(resultado)