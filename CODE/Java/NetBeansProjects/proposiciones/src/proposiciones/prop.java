
package proposiciones;

import java.util.ArrayList;


public class prop {
    private String proposicion;
    
    public prop(String proposicion){
        this.proposicion = proposicion;
    }
    
    public String getProp(){
        return proposicion;
    }
    
    public void setProp(String proposicion){
        this.proposicion = proposicion;
    }
    
    
    public String negar(){
        String palabras[] = this.getProp().split(" ");
        String tobe[] = {"soy","eres","es","somos","sois","son","estoy","estas","esta","estamos","estais","estan","tengo","voy"};
        ArrayList<String> nueva = new ArrayList<String>();

        
        for(String palabra : palabras){
            for (int i = 0; i < tobe.length; i++) {
                if(tobe[i].equals(palabra)){
                    nueva.add("no");
                }
            }
            nueva.add(palabra);
        }
        return String.join(" ", nueva);
    }
}
