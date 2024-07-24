
package plano;

public class apoyo {
    public Plano p1,p2;
    public double a,b,c,m;
    public String orien,ecu;
    
    public apoyo(Plano p1,Plano p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public void calcular(){
        if(Double.isInfinite((p2.getY() - p1.getY())/(p2.getX() - p1.getX()))){
        }
        else{
            m = (p2.getY() - p1.getY())/(p2.getX() - p1.getX()); 
        }
        
        for (int i = 0; i < vectorpolares.length; i++) {
            
            System.out.printf("%-5s",vectorpolares[i]);
            for (int j = 0; j < 2; j++) {
                System.out.printf("-15s",matrizpolares[i][j]);
            }
            
            for (int h = 0; h < 2; h++) {
                System.out.printf("%-15s",matrizcartesiana[i][j]);
                
            }
            System.out.println("");
        }
        
    }
}
