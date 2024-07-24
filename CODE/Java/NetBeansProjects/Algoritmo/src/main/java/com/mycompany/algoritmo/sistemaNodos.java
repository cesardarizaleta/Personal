package com.mycompany.algoritmo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class sistemaNodos extends JFrame {

    public sistemaNodos() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Listas Entrelazadas");
        setLocationRelativeTo(null);
        setResizable(false);
        cerrar();
        interfaz();
    }

    private JTextField pal, index, letra;
    private JButton agregar, ope, elim;
    private JLabel p1, p2, p3, p4,r1,r2,r3,r4;
    private JTextArea lista;
    private boolean hay = false;

    private void interfaz() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.add(panel);

        pal = new JTextField();
        pal.setBounds(240, 50, 200, 40);
        pal.setHorizontalAlignment(JTextField.CENTER);
        panel.add(pal);

        agregar = new JButton("Agregar");
        agregar.setBounds(440, 50, 100, 40);
        panel.add(agregar);

        index = new JTextField();
        index.setBounds(190, 150, 100, 40);
        index.setHorizontalAlignment(JTextField.CENTER);
        panel.add(index);

        letra = new JTextField();
        letra.setBounds(290, 150, 100, 40);
        letra.setHorizontalAlignment(JTextField.CENTER);
        panel.add(letra);

        ope = new JButton("Operar");
        ope.setBounds(390, 150, 100, 40);
        panel.add(ope);

        elim = new JButton("Eliminar");
        elim.setBounds(490, 150, 100, 40);
        panel.add(elim);

        JLabel in = new JLabel("Index/Indice");
        in.setBounds(200, 190, 100, 20);
        panel.add(in);

        JLabel le = new JLabel("Letra");
        le.setBounds(325, 190, 100, 20);
        panel.add(le);

        p1 = new JLabel("Alfabeticamente ordenado: ");
        p1.setBounds(150, 300, 200, 30);
        p1.setVisible(false);
        p2 = new JLabel("Tamaño: ");
        p2.setBounds(150, 350, 200, 30);
        p2.setVisible(false);
        p3 = new JLabel("En mayusculas: ");
        p3.setBounds(150, 400, 200, 30);
        p3.setVisible(false);
        p4 = new JLabel("Letra eliminada: ");
        p4.setBounds(150, 450, 200, 30);
        p4.setVisible(false);
        
        r1 = new JLabel("");
        r1.setBounds(400, 300, 200, 30);
        r2 = new JLabel("");
        r2.setBounds(400, 350, 200, 30);
        r3 = new JLabel("");
        r3.setBounds(400, 400, 200, 30);
        r4 = new JLabel("");
        r4.setBounds(400, 450, 200, 30);        

        panel.add(r1);
        panel.add(r2);
        panel.add(r3);
        panel.add(r4);
        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        panel.add(p4);
        
        lista = new JTextArea("");
        lista.setEnabled(false);
        lista.setDisabledTextColor(Color.BLACK);
        lista.setBounds(100,100,600,40);
        panel.add(lista);
        
        JScrollPane deslizar = new JScrollPane(lista);
        deslizar.setBounds(100,100,600,40);
        deslizar.setBorder(null);
        panel.add(deslizar);

        acciones();

    }

    private void acciones() {
        KeyListener tecla1 = new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }
            public void keyReleased(KeyEvent e) {
                if (!(e.getKeyCode() > 64 && e.getKeyCode() < 91 || e.getKeyCode() == 32 || e.getKeyCode() == 16 || e.getKeyCode() == 8)) {
                    if (pal.getText().length() == 0) {
                        pal.setText("");
                    } else {
                        pal.setText(pal.getText().substring(0, pal.getText().length() - 1));
                    }
                }
            }
        };
        pal.addKeyListener(tecla1);

        lista li = new lista();

        ActionListener nuevo = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!pal.getText().isEmpty()) {
                    li.agregar(pal.getText());
                    pal.setText("");
                    
                    String nodos[] = new String[li.size];
                    
                    for (int i = 0; i < nodos.length; i++) {
                        nodos[i] = li.obtn(i);
                    }
                    
                    lista.setText(String.join(",", nodos));
                }
            }
        };
        agregar.addActionListener(nuevo);

        KeyListener indice = new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                if (!(e.getKeyCode() > 47 && e.getKeyCode() < 58 || e.getKeyCode() == 8)) {
                    if (index.getText().length() == 1) {
                        index.setText("");
                    } else {
                        index.setText(index.getText().substring(0, index.getText().length() - 1));
                    }
                }
            }
        };
        index.addKeyListener(indice);

        KeyListener tecladoletra = new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                if (!(e.getKeyCode() > 64 && e.getKeyCode() < 91 || e.getKeyCode() == 32 || e.getKeyCode() == 16 || e.getKeyCode() == 8)) {
                    letra.setText("");
                }
                if (letra.getText().length() > 1) {
                    letra.setText(letra.getText().substring(0, letra.getText().length() - 1));
                }
            }
        };
        letra.addKeyListener(tecladoletra);
        
        ActionListener ejecutar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!index.getText().equals("") && !letra.getText().equals("")){
                    if(Integer.parseInt(index.getText()) < li.size()){
                        p1.setVisible(true);
                        p2.setVisible(true);
                        p3.setVisible(true);
                        p4.setVisible(true);
                        r1.setText(ordenado(li.obtn(Integer.parseInt(index.getText()))));
                        r2.setText(tamano(li.obtn(Integer.parseInt(index.getText()))));
                        r3.setText(li.obtn(Integer.parseInt(index.getText())).toUpperCase());
                        hasLetra(li.obtn(Integer.parseInt(index.getText())));
                        if(hay == true){
                            r4.setText(elimLetra(li.obtn(Integer.parseInt(index.getText()))));
                        }
                        else{
                            r4.setText("Palabra sin letra ingresada");
                        }
                        
                    }
                }
            }
        };
        ope.addActionListener(ejecutar);
        
        ActionListener delete = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!index.getText().equals("") && li.size() > 0 && Integer.parseInt(index.getText()) < li.size()){
                    li.elm(Integer.parseInt(index.getText()));
                    String nodos[] = new String[li.size];
                    
                    for (int i = 0; i < nodos.length; i++) {
                        nodos[i] = li.obtn(i);
                    }
                    
                    lista.setText(String.join(",", nodos));
                }
            }
        };
        elim.addActionListener(delete);
    }
    
    private void hasLetra(String palabra){

        if(palabra.toLowerCase().contains(String.valueOf(letra.getText().toLowerCase().charAt(0)))){
            hay = true;
        }
        else{
            hay = false;
        }
    }

    private String ordenado(String palabra) {
        char cadena[] = palabra.toLowerCase().toCharArray();
        int n = cadena.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (cadena[j] > cadena[j + 1]) {
                    char temp = cadena[j];
                    cadena[j] = cadena[j + 1];
                    cadena[j + 1] = temp;
                }
            }
        }
        return String.valueOf(cadena);
    }
    
    private String tamano(String palabra){
        char cadena[] = palabra.toLowerCase().toCharArray();
        
        return Integer.toString(cadena.length);
        
    }
    
    private String elimLetra(String palabra){
        char cadena[] = palabra.toLowerCase().toCharArray();
        char cadenaNueva[] = new char[cadena.length];
        char caracter = letra.getText().toLowerCase().charAt(0);

        for (int i = 0; i < cadena.length; i++) {
            if(cadena[i] == caracter){
                
            }
            else{
                cadenaNueva[i] = cadena[i];
            }
        }
        return String.valueOf(cadenaNueva);
    }
    

    private void cerrar() {
        WindowListener cierre = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                menu centro = new menu();
                centro.setVisible(true);
                dispose();
            }
        };
        addWindowListener(cierre);
    }
}
