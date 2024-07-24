
package com.mycompany.algoritmo;


public class nodo {
    String valor;
    nodo siguiente;
    
    public nodo(String valor){
        this.valor = valor;
        this.siguiente = null;
    }
    
    public String obtnValor(){
        return valor;
    }
    
    public void enlzNext(nodo n){
        siguiente = n;
    }
    
    public nodo obtnNext(){
        return siguiente;
    }
}
