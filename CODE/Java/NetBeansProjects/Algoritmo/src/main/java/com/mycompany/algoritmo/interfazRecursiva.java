
package com.mycompany.algoritmo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class interfazRecursiva extends JFrame{
    public interfazRecursiva(){
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Sistema Matrices");
        setLocationRelativeTo(null);
        setResizable(false);  
        cerrar();
        visual();
    }
    private JButton borrar = new JButton("Borrar"),ejecutar = new JButton("Ejecutar");
    private JTextField texto = new JTextField();
    private JTextArea factRes = new JTextArea(),matrizMostrar = new JTextArea();
    private JLabel res1,res2,res3,res4;
    private Random ran = new Random();
    private Integer diagPrinci = 1,mayor = 0,promSuma = 0,contador = 0;
    private double ultimaCol;
    private JScrollPane deslizar;
    
    private void visual(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.add(panel);
        
        texto.setBounds(50, 50, 350, 50);
        panel.add(texto);
        
        ejecutar.setBounds(400, 50, 100, 50);
        panel.add(ejecutar);
        
        borrar.setBounds(500, 50, 100, 50);
        panel.add(borrar);
        
        JLabel restriccion = new JLabel("Crear Matriz - solo numeros enteros entre 3 y 10: ");
        restriccion.setBounds(50, 35, 500, 15);
        panel.add(restriccion); 
        
        JLabel prgt1 = new JLabel("1 > Resultado de la multi. de la diagonal principal");
        prgt1.setBounds(50, 150, 500, 25);
        panel.add(prgt1);
        
        JLabel prgt2 = new JLabel("2 > Promedio de la suma de la ultima columna");
        prgt2.setBounds(50, 200, 500, 25);
        panel.add(prgt2);
        
        JLabel prgt3 = new JLabel("3 > Factorial del numero mayor de la Matriz");
        prgt3.setBounds(50, 250, 500, 25);
        panel.add(prgt3);
        
        JLabel prgt4 = new JLabel("4 > Fibonacci del valor prome. de la suma de la matriz");
        prgt4.setBounds(50, 300, 500, 25);
        panel.add(prgt4);

        res1 = new JLabel("");
        res1.setBounds(50, 170, 500, 25);
        res1.setEnabled(false);
        res1.setVisible(false);
        panel.add(res1);
        
        res2 = new JLabel("");
        res2.setBounds(50, 220, 500, 25);
        res2.setEnabled(false);
        res2.setVisible(false);
        panel.add(res2);
        
        res3 = new JLabel("3 > Factorial");
        res3.setBounds(560, 150, 500, 25);
        res3.setVisible(false);
        panel.add(res3);
        
        factRes.setBounds(560, 190, 150, 300);
        factRes.setBorder(null);
        factRes.setEnabled(false);
        factRes.setLineWrap(true);
        
        deslizar = new JScrollPane(factRes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);      
        deslizar.setBorder(null);
        deslizar.setVisible(false);
        deslizar.setBounds(560, 190, 150, 300);
        deslizar.setEnabled(true);
        panel.add(deslizar);  
        
        res4 = new JLabel("");
        res4.setBounds(50, 320, 500, 25);
        res4.setEnabled(false);
        res4.setVisible(false);
        panel.add(res4);
        
        matrizMostrar.setBounds(50, 360, 450, 450);
        matrizMostrar.setEnabled(false);
        panel.add(matrizMostrar);        
        
        eventos();
    }
    
    private void eventos(){
        KeyListener validador = new KeyAdapter(){
            public void keyReleased(KeyEvent e) {
                String letra = texto.getText();
                if (!letra.matches("[3-9]|10")) {
                    texto.setText("");
                }
            }
        };
        texto.addKeyListener(validador);
        
        ActionListener comenzar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!(texto.getText().equals(""))){
                    ArrayList<Integer> secuencia = new ArrayList<>();
                
                    int matriz[][] = new int[Integer.parseInt(texto.getText())][Integer.parseInt(texto.getText())];
                    recorrer(matriz,0,0);
                    ejecutar.setEnabled(false);
                    texto.setEnabled(false);
                    res1.setVisible(true);
                    res2.setVisible(true);
                    res3.setVisible(true);
                    res4.setVisible(true);
                    factRes.setVisible(true);
                    deslizar.setVisible(true);
                    res1.setText(diagPrinci.toString());
                    res2.setText(Double.toString((Math.round(ultimaCol / matriz.length))));
                    factRes.setText(factorial(BigInteger.valueOf(mayor)).toString());
                    fibonacci(promSuma/contador,secuencia,0,1);
                    res4.setText(secuencia.toString());
                }
            }
        };
        ejecutar.addActionListener(comenzar);
        ActionListener terminar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ejecutar.setEnabled(true); 
                texto.setEnabled(true);
                texto.setText("");
                res1.setVisible(false);
                res2.setVisible(false);
                res3.setVisible(false);
                res4.setVisible(false);
                factRes.setVisible(false);
                deslizar.setVisible(false);
                ultimaCol = 0;
                matrizMostrar.setText("");
                diagPrinci = 1;
                mayor = 0;
                promSuma = 0;
                contador = 0;
                
            }
        };
        borrar.addActionListener(terminar);
    }
    
    private void recorrer(int matriz[][], int i, int j){
        if(i < matriz.length){
            if(j < matriz[0].length){
                matriz[i][j] =ran.nextInt(2 * 999) - 999;
                if(matriz[i][j] < 0){
                    matrizMostrar.append("           ".substring(0,7-(Integer.toString(matriz[i][j])).length()) + Integer.toString(matriz[i][j]));
                }
                else{
                    matrizMostrar.append("           ".substring(0,8-(Integer.toString(matriz[i][j])).length()) + Integer.toString(matriz[i][j]));
                }
                if(i == j){
                    diagPrinci *= matriz[i][j];
                }
                if(mayor < matriz[i][j]){
                    mayor = matriz[i][j];
                }
                if(matriz[i][j] > 0){
                    promSuma += matriz[i][j];
                    contador = contador + 1;
                }
                recorrer(matriz,i,j + 1);
            }
            else{
                ultimaCol += matriz[i][matriz.length - 1];
                matrizMostrar.append("\n");
                recorrer(matriz,i + 1,0);
            }
        }
    }
    
    private BigInteger factorial(BigInteger n){
        if(n.equals(BigInteger.ZERO)){
            return BigInteger.ONE;
        }
        else{
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
        
    }
    
    private void fibonacci(int n,ArrayList secuencia,int temp1,int temp2){
        if(temp2 <= n){
            secuencia.add(temp2);
            int numeroNew = temp1 + temp2;
            fibonacci(n,secuencia,temp2,numeroNew);
        }
    }
    
    private void cerrar(){
        WindowListener cierre = new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                menu centro = new menu();
                centro.setVisible(true);
                dispose();
            }
        };
        addWindowListener(cierre);          
    }
}
