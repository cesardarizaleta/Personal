
package com.mycompany.empresaMenu;

import java.awt.Color;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EmpresaMenu extends JFrame{
    
    public EmpresaMenu(){
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Menu");
        setLocationRelativeTo(null);
        setResizable(false);    
        setVisible(true);
        inicializacion();
    }
    
    private JMenuItem inv;
    
    private void inicializacion(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.add(panel);
        
        JMenuBar barra = new JMenuBar();
        this.setJMenuBar(barra);
        
        JMenu gnl = new JMenu("Herramientas");
        barra.add(gnl);
        
        inv = new JMenuItem("Inventario");
        gnl.add(inv);
    }

    public static void main(String[] args) {
        EmpresaMenu vtn = new EmpresaMenu();
    }
}
