
//CLASES

class Persona {
    var nombre: String
    var edad: Int
    var altura: Double
    var esHombre: Bool
    
    init(nombre: String, edad: Int, altura: Double, esHombre: Bool) {
        self.nombre = nombre
        self.edad = edad
        self.altura = altura
        self.esHombre = esHombre
    }
    
    func saludar() {
        print("Hola")
    }
    
    func saludar(nombre: String) {
        print("Hola \(nombre)")
    }
    
    func sumar(a: Int, b: Int) -> Int {
        return a + b
    }
}

var cesar = Persona(nombre: "Cesar", edad: 24, altura: 1.75, esHombre: true)

cesar.saludar()

cesar.saludar(nombre: "Cesar")

var resultado = cesar.sumar(a: 5, b: 5)

print(resultado)
