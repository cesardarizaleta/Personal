
package calculator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ventana extends JFrame{
    public ventana(){
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Algoritmos y Estructura - Menu");
        setLocationRelativeTo(null);    
        setResizable(false);        
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        
        DefaultTableModel model = new DefaultTableModel();
        
        JTable tabla = new JTable(model);
        tabla.setBounds(50,50,300,400);
        panel.add(tabla);
        
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Cedula");
    }
    
    public static void main(String[] args) {
        ventana v = new ventana();
        v.setVisible(true);
    }
}
