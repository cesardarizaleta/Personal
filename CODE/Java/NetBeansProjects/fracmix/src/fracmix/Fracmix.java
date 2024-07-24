
package fracmix;

public class Fracmix {
    protected int entero , denominador , numerador;

    public Fracmix(int entero, int denominador, int numerador) {
        this.entero = entero;
        this.denominador = denominador;
        this.numerador = numerador;
    }

    public int getEntero() {
        return entero;
    }

    public int getDenominador() {
        return denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    
    public void mostrar(){
        System.out.printf("%-3d ( %-2d/ %-2d)",this.entero,this.numerador,this.denominador);
    }
}
