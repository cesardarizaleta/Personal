
package com.mycompany.empresa;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class tasa extends JFrame{
    public tasa(){
        setSize(500, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Menu - Tasa Dolar");
        setLocationRelativeTo(null);
        setResizable(false);       
        setVisible(true);
        cerrar();
        visual();
    }  
    
    protected static JTextField dolar = new JTextField("37");
    
    private void visual(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        add(panel);
        
        JLabel labelTas = new JLabel("Tasa Dolar");
        labelTas.setBounds(190,40,250,30);
        labelTas.setFont(new Font("",Font.BOLD,20));
        
        panel.add(labelTas);
        
        dolar.setBounds(175,90,150,50);
        dolar.setHorizontalAlignment(JTextField.CENTER);
        panel.add(dolar);
        
        evento();
    }
    
    private void evento(){
        KeyListener teclado = new KeyListener(){
            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
            }
            public void keyReleased(KeyEvent e) {
                try{
                    int tecla = Integer.parseInt(dolar.getText());
                }
                catch (NumberFormatException evne){
                    dolar.setText("");
                }
            }     
        };
        dolar.addKeyListener(teclado);
    }
    
    private void cerrar(){
        WindowListener cierre = new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                Empresa centro = new Empresa();
                centro.setVisible(true);
                dispose();
            }
        };
        addWindowListener(cierre);          
    }
}
