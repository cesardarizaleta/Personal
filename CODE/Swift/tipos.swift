//
//  steps.swift
//  Swift
//
//  Created by Cesar on 31/7/24.
//

import Foundation

print("Hola")

//VARIABLES
//String
var nombre = "Cesar"
//Int
var edad = 24
//Double
var altura = 1.75
//Bool
var esHombre = true

//CONSTANTES
//No se le puede cambiar el valor despues de asignarlo
let pi = 3.1416

//Nulo es nil
nada = nil

//ARRAYS
var nombres = ["Cesar", "Juan", "Pedro"]
var edades = [24, 25, 26]
var alturas = [1.75, 1.80, 1.85]
var esHombre = [true, false, true]

//DICCIONARIOS
var persona = ["nombre": "Cesar", "edad": 24, "altura": 1.75, "esHombre": true]

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
