
package lotes;

public class Lotes {

    protected int numLote;
    protected double[] porcar,pormag;
    protected double promcar=0,prommag=0;
    protected String estatus;
    
    public Lotes(int numLote,double porcar[],double pormag[]){
        this.numLote = numLote;
        this.porcar = porcar;
        this.pormag = pormag;
        
        actualizar();
    }
    
    private void actualizar(){
        for (int i = 0; i < porcar.length; i++) {
            promcar += porcar[i];
        }
        promcar = promcar / porcar.length;
        
        for (int i = 0; i < pormag.length; i++) {
            prommag += pormag[i];
        }
        prommag = prommag / pormag.length;
        
        if(promcar > 24.92 && promcar < 27.92 && prommag > 19.84 && prommag < 25.30){
            estatus = "Aprobado";
        }
        else{
            estatus = "Reprobado";
        }
    }
    
    protected void mostrarAtri(){
        System.out.printf("%-8d",numLote);
        
        for (int i = 0; i < porcar.length; i++) {
            System.out.printf("%10.2f",porcar[i]);
        }
        for (int i = 0; i < pormag.length; i++) {
            System.out.printf("%10.2f",pormag[i]);
        }
        System.out.print("    ");
        
        System.out.printf("%-15.2f",promcar);
        System.out.printf("%-15.2f",prommag);
        System.out.printf("%-10s \n",estatus);
    }
    
}
