
package com.mycompany.algoritmo;

public class lista {
    nodo cabeza;
    int size;
    
    public lista(){
        cabeza = null;
        size = 0;
    }
    
    public void agregar(String obj){
        if(cabeza == null){
            cabeza = new nodo(obj);
        }
        else{
            nodo temp = cabeza;
            nodo nuevo = new nodo(obj);
            nuevo.enlzNext(temp);
            cabeza = nuevo;
        }
        size++;
    }
    
    public int size(){
        return size;
    }
    
    public boolean empty(){
        return (cabeza == null);
    }
    
    public String obtn(int index){
        int contador = 0;
        nodo temp = cabeza;
        while(contador < index){
            temp = temp.obtnNext();
            contador++;
        }
        return temp.obtnValor();
    }
    
    public void elm(int index){
        if(index == 0){
            cabeza = cabeza.obtnNext();
        }
        else{
            int contador = 0;
            nodo temp = cabeza;
            while(contador < index - 1){
                temp = temp.obtnNext();
                contador++;
            }
            temp.enlzNext(temp.obtnNext().obtnNext());
        }
        size--;
    }
}
