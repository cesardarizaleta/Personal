/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lotes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author cesar
 */
public class almacen {
    protected static int regis() throws FileNotFoundException{
        Scanner file = new Scanner(new File("lotes.txt"));
        
        int n = 0;
        
        while(file.hasNextLine()){
            file.nextLine();
            n = n + 1;
        }
        file.close();
        
        return n;
    }
    
    protected void almacenar() throws FileNotFoundException{
        
        Scanner file = new Scanner(new File("lotes.txt"));
        
    
        System.out.println("Lote                %Carbono                        %Magnesio           %PromC        %PromM          Estatus");
        
        while(file.hasNextLine()){
            int numLote;
            double mag[] = new double[3];
            double ca[] = new double[3];
            
            numLote = file.nextInt();

            
            for (int i = 0; i < ca.length; i++) {
                ca[i] = Double.parseDouble(file.next().replace(',', '.'));
                
            }
            
            for (int i = 0; i < mag.length; i++) {
                mag[i] = Double.parseDouble(file.next().replace(',', '.'));
            }
            Lotes l1 = new Lotes(numLote,ca,mag);
            l1.mostrarAtri();

        }
        file.close();
    }
}
