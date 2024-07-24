/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author cesar
 */
public class Calculator extends JFrame{
    
    private JButton uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,cero,mas,menos,mult,div,igual,borrar;
    private JTextField texto;
    private int numero;

    public Calculator(){
        setSize(200,350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setTitle("Calculator");
        init();
    }
    
    private void init(){
        Container c = new Container();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        this.add(c);
        
        texto = new JTextField();
        texto.setBounds(20,20,160,40);
        texto.setHorizontalAlignment(JTextField.RIGHT);
        texto.setEditable(false);
        c.add(texto);
        
        uno = new JButton("1");
        uno.setBounds(20,90,40,40);
        c.add(uno);
        
        dos = new JButton("2");
        dos.setBounds(60,90,40,40);
        c.add(dos);
        
        tres = new JButton("3");
        tres.setBounds(100,90,40,40);
        c.add(tres);       
        
        cuatro = new JButton("4");
        cuatro.setBounds(20,130,40,40);
        c.add(cuatro);
        
        cinco = new JButton("5");
        cinco.setBounds(60,130,40,40);
        c.add(cinco);
        
        seis = new JButton("6");
        seis.setBounds(100,130,40,40);
        c.add(seis);   
        
        siete = new JButton("7");
        siete.setBounds(20,170,40,40);
        c.add(siete);
        
        ocho = new JButton("8");
        ocho.setBounds(60,170,40,40);
        c.add(ocho);
        
        nueve = new JButton("9");
        nueve.setBounds(100,170,40,40);
        c.add(nueve);
        
        cero = new JButton("0");
        cero.setBounds(20,210,120,40);
        c.add(cero);
        
        mult = new JButton("x");
        mult.setBounds(140,210,40,40);
        c.add(mult);
        
        div = new JButton("/");
        div.setBounds(140,170,40,40);
        c.add(div);
        
        menos = new JButton("-");
        menos.setBounds(140,130,40,40);
        c.add(menos);
        
        mas = new JButton("+");
        mas.setBounds(140,90,40,40);
        c.add(mas);
        
        borrar = new JButton("AC");
        borrar.setBounds(20,250,80,40);
        c.add(borrar);
        
        igual = new JButton("=");
        igual.setBounds(100,250,80,40);
        c.add(igual);
        
        events();
    }
    
    private void events(){
        ActionListener numeros = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == cero && texto.getText().equals("")){
                }
                else{
                    texto.setText(texto.getText() + ((JButton)e.getSource()).getText());
                }
            }
        };
        uno.addActionListener(numeros);
        dos.addActionListener(numeros);
        tres.addActionListener(numeros);
        cuatro.addActionListener(numeros);
        cinco.addActionListener(numeros);
        seis.addActionListener(numeros);
        siete.addActionListener(numeros);
        ocho.addActionListener(numeros);
        nueve.addActionListener(numeros);
        cero.addActionListener(numeros);
        
        ActionListener delete = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                texto.setText("");
                numero = 0;
            }
        };
        borrar.addActionListener(delete);
        
        ActionListener operacion = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == mult && !texto.getText().equals("")){
                    numero = Integer.parseInt(texto.getText());
                    texto.setText("");
                }
                if(e.getSource() == igual && numero != 0){
                    texto.setText(Integer.toString(Integer.parseInt(texto.getText()) * numero));
                }
            }
        };
        mult.addActionListener(operacion);
        div.addActionListener(operacion);
        mas.addActionListener(operacion);
        menos.addActionListener(operacion);
        igual.addActionListener(operacion);
    }
    
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.setVisible(true);
    }
    
}
