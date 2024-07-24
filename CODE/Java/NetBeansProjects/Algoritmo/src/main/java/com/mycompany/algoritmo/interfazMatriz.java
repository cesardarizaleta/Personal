
package com.mycompany.algoritmo;

//Se Importan todas las librerias necesarias
import java.math.BigInteger;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Random;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class interfazMatriz extends JFrame {
    
    //Se crea la ventana inicial
    public interfazMatriz(){
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Sistema Matrices");
        setLocationRelativeTo(null);    //Ubicar al centro al abrir
        setResizable(false);  
        WindowListener cierre = new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                menu centro = new menu();
                centro.setVisible(true);
                dispose();
            }
        };
        addWindowListener(cierre);
        inicializar();
    }
    
    //Dentro de este metodo se crearan todos elementos visuales
    public void inicializar(){
        
        //Crear y aplicar un panel a la ventana 
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(Color.WHITE);
        
        //TextField - Campo de texto
        JTextField texto = new JTextField();
        texto.setBounds(50, 50, 350, 50);
        panel.add(texto);
                
        //Boton de Ejecutar
        JButton ejecutar = new JButton("Ejecutar");
        ejecutar.setBounds(400, 50, 100, 50);
        panel.add(ejecutar);

        //Boton de borrar
        JButton borrar = new JButton("Borrar");
        borrar.setBounds(500, 50, 100, 50);
        panel.add(borrar);
        
        //Escribir la restriccion
        JLabel res = new JLabel("Crear Matriz - solo numeros enteros entre 3 y 10: ");
        res.setBounds(50, 35, 500, 15);
        panel.add(res);

        //Pregunta 1
        JLabel uno = new JLabel("1 > Resultado de la multi. de la diagonal principal");
        uno.setBounds(50, 150, 500, 20);
        panel.add(uno);
        //Pregunta 2
        JLabel dos = new JLabel("2 > Promedio de la suma de la ultima columna");
        dos.setBounds(50, 200, 500, 20);
        panel.add(dos);
        //Pregunta 3
        JLabel tres = new JLabel("3 > Factorial del numero mayor de la Matriz");
        tres.setBounds(50, 250, 500, 20);
        tres.setVisible(true);
        panel.add(tres);
        
        //Pregunta 4
        JLabel cuatro = new JLabel("4 > Fibonacci del valor prome. de la suma de la matriz");
        cuatro.setBounds(50, 300, 500, 20);
        
        panel.add(cuatro);
        
        //Respuesta 3
        JLabel fact = new JLabel("3 > Factorial");
        fact.setBounds(560, 150, 500, 20);
        panel.add(fact);
        fact.setVisible(false);
        
        //TextArea - Respuesta 3
        JTextArea tresR = new JTextArea();
        tresR.setBounds(560, 190, 150, 300);
        tresR.setLayout(null);    
        tresR.setBorder(null);
        tresR.setEnabled(false);
        tresR.setVisible(false);
        tresR.setLineWrap(true);
        
        //Para poder deslizar todo el textarea para ver todo el numero
        JScrollPane deslizar = new JScrollPane(tresR, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);      
        deslizar.setVisible(false);
        deslizar.setBorder(null);
        deslizar.setBounds(560, 190, 150, 300);
        deslizar.setEnabled(true);
        panel.add(deslizar);  
        
        //TextArea - Se usara mas Adelante para la Visualizacion de la matriz
        JTextArea textoMatriz = new JTextArea();
        textoMatriz.setBounds(50, 360, 450, 450);
        textoMatriz.setEnabled(false);
        panel.add(textoMatriz);
        
        //Respuesta 1
        JLabel unoR = new JLabel("");
        unoR.setBounds(50, 170, 500, 20);
        unoR.setEnabled(false);
        panel.add(unoR);
        unoR.setVisible(false);
        
        //Respuesta 2
        JLabel dosR = new JLabel("");
        dosR.setBounds(50, 220, 500, 20);
        dosR.setEnabled(false);
        panel.add(dosR);
        dosR.setVisible(false);
        
        //Respuesta 4
        JLabel cuatroR = new JLabel("");
        cuatroR.setBounds(50, 320, 500, 20);
        cuatroR.setEnabled(false);
        panel.add(cuatroR);   
        cuatroR.setVisible(false);
        
        //EVENTOS
        eventos(ejecutar,borrar,texto,textoMatriz,unoR,dosR,tresR,cuatroR,deslizar,fact);
    }
    
    //Se crea un metodo que contenga todos los eventos a ocurrir y restricciones
    public void eventos(JButton ejecutar,JButton borrar,JTextField texto,JTextArea textoMatriz,JLabel unoR,JLabel dosR,JTextArea tresR,JLabel cuatroR,JScrollPane deslizar,JLabel fact){
        //Boton ejecutar - Evento
        ActionListener atrapar = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ejecutar.setEnabled(false);
                texto.setEnabled(false);
                int t = Integer.parseInt(texto.getText());
                int matriz[][] = hacerMatriz(t,textoMatriz);
                respuestas(matriz,unoR,dosR,tresR,cuatroR,deslizar,fact);
            }            
        };
        ejecutar.addActionListener(atrapar);
        
        //Boton Borrar - Evento        
        ActionListener eliminar = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ejecutar.setEnabled(true);
                texto.setEnabled(true);
                textoMatriz.setText("");
                texto.setText("");
                unoR.setVisible(false);
                dosR.setVisible(false);
                tresR.setVisible(false);
                cuatroR.setVisible(false);
                deslizar.setVisible(false);
                fact.setVisible(false);
            }
        };
        borrar.addActionListener(eliminar);

        //Textfield Restricciones - Evento
        KeyListener teclado = new KeyListener() {
            public void keyReleased(KeyEvent e) {
                String letra = texto.getText();
                if (!letra.matches("[3-9]|10")) {
                    texto.setText("");
                }
            }
            
            public void keyTyped(KeyEvent e) {
            }
            
            public void keyPressed(KeyEvent e) {
            }
        };
        texto.addKeyListener(teclado);    
    }
    
    //Metodo para crear e imprimir la matriz por pantalla
    public int[][] hacerMatriz(int t,JTextArea textoMatriz){
        
        Random random = new Random();
        int matriz[][] = new int[t][t];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                matriz[i][j] = random.nextInt(2 * 999) - 999;
                if(matriz[i][j] < 0){
                    textoMatriz.append("           ".substring(0,7-(Integer.toString(matriz[i][j])).length()) + Integer.toString(matriz[i][j]));
                }
                else{
                    textoMatriz.append("           ".substring(0,8-(Integer.toString(matriz[i][j])).length()) + Integer.toString(matriz[i][j]));
                }
                    
            }
            textoMatriz.append("\n");
        }
        return matriz;
    }
    
    //Se inicia un metodo que calcule e imprima por pantalla los resultados a las preguntas
    public void respuestas(int[][] matriz,JLabel unoR,JLabel dosR, JTextArea tresR,JLabel cuatroR,JScrollPane deslizar,JLabel fact){
        
        int mayor = matriz[0][0];
        int promedio = 0;
        int promeToda = 0;
        int n =0; //Contador
        int dp = 1;
        
        //Recorrido de la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                //Diagonal Principal
                if (i == j) {
                    dp = dp * matriz[i][j];
                }
                //Ultima columna
                if (j == matriz.length - 1) {
                    promedio = promedio + matriz[i][j];
                }
                //Factorial
                if (mayor < matriz[i][j]) {
                    mayor = matriz[i][j];
                }
                //Fibonacci
                if(matriz[i][j] > 0){
                    promeToda = promeToda + matriz[i][j];
                    n++;
                }
            }
        }
        
        unoR.setVisible(true);
        unoR.setText(Integer.toString(dp));
        
        dosR.setVisible(true);
        dosR.setText(Integer.toString(promedio / matriz.length));
        
        //Factorial
        if (mayor <= 0) {
            tresR.setVisible(true);
            deslizar.setVisible(true);
            tresR.setText("Numero mayor negativo");
        } 
        
        else {
            BigInteger factorial = new BigInteger("1");
            
            for (int i = 1; i <= mayor; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            deslizar.setVisible(true);
            tresR.setVisible(true);
            tresR.setText(factorial.toString());
        }
        fact.setVisible(true);
        
        //Fibonacci
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        int fibo1 = 0, fibo2 = 1, fibo3 = 0;
        listaNumeros.add(0);
        listaNumeros.add(1);
        while (fibo1 + fibo2 <= ((int)promeToda / (n))) {
            fibo3 = fibo1 + fibo2;
            listaNumeros.add(fibo3);
            fibo1 = fibo2;
            fibo2 = fibo3;
        }
        int vector2[] = new int[listaNumeros.size()];
        for (int i = 0; i < vector2.length; i++) {
            vector2[i] = listaNumeros.get(i);
        }
        String imprimir4 = String.join(",", Arrays.toString(vector2));
        
        cuatroR.setVisible(true);
        cuatroR.setText(imprimir4);
    }

}
