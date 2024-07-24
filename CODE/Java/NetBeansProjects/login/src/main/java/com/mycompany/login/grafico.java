
package com.mycompany.login;

import java.awt.Color;
import javax.swing.*;

public class grafico extends JFrame {
    public grafico(){
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Menu");
        setLocationRelativeTo(null);
        setResizable(false);   
        visual();
    }
    
    protected JButton login,register;
    protected JTextField set;
    protected JPanel panel1,panel2;
    
    public void visual(){
        panel1.setLayout(null);
        panel1.setBackground(Color.white);
        this.add(panel1);
        
        set.setBounds(200,150,400,100);
        panel1.add(set);
    }
}
