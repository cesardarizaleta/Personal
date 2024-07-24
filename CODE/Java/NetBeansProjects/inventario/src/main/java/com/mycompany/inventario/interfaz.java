
package com.mycompany.inventario;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class interfaz extends JFrame {
    public interfaz() throws IOException{
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Inventario");
        setLocationRelativeTo(null);
        setResizable(false);     
        visual();
    }
    public void visual() throws IOException{
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.add(panel);
        
        JTextField buscador = new JTextField();
        buscador.setBounds(50, 50, 700, 50);
        buscador.setBackground(new Color(244,244,244));
        buscador.setBorder(new EmptyBorder(5,15,5,5));
        panel.add(buscador);
        
        DefaultListModel modelo = new DefaultListModel();
        JList items = new JList(modelo);
        items.setBounds(50,170,700,350);
        items.setBackground(new Color(244, 244, 244));
        JScrollPane deslizar = new JScrollPane(items);
        deslizar.setBounds(50,170,700,350);
        deslizar.setBorder(null);
        items.setBorder(new EmptyBorder(15,15,10,10));

        panel.add(deslizar);
        
        JButton anadir = new JButton("Añadir");
        anadir.setBounds(50,100,80,40);
        panel.add(anadir);
        
        JButton buscar = new JButton("Buscar");
        buscar.setBounds(130,100,80,40);
        panel.add(buscar);
        
        JButton eliminar = new JButton("Eliminar");
        eliminar.setBounds(210,100,80,40);
        panel.add(eliminar);
        
        JButton ordenar = new JButton("Ordenar");
        ordenar.setBounds(290,100,80,40);
        panel.add(ordenar);
        
        eventos(anadir,buscador,items,modelo,eliminar,buscar,ordenar);
}
    
    public void eventos(JButton anadir,JTextField buscador,JList items,DefaultListModel modelo,JButton eliminar,JButton buscar,JButton ordenar) throws IOException{
        
        Scanner archivo = new Scanner(new File("inventario.txt"));
        while(archivo.hasNextLine()){
            modelo.addElement(archivo.nextLine());
        }
        archivo.close();
        
        ActionListener poner = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(buscador.getText() != null){
                    modelo.addElement(buscador.getText());
                    try {
                        FileWriter escritor = new FileWriter("inventario.txt", true);
                        escritor.write(buscador.getText() + "\n");
                        escritor.close();
                    } catch (IOException i) {
                    }
                    buscador.setText("");
                    
                }
            }
        };
        anadir.addActionListener(poner);
        
        ActionListener borrar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                modelo.remove(items.getSelectedIndex());
                try {
                    FileWriter escritorNew = new FileWriter("inventario.txt");
                    for (int i = 0; i < modelo.getSize(); i++) {
                        escritorNew.write((String)modelo.getElementAt(i));
                        
                    }
                    escritorNew.close();
                    } catch (IOException i) {
                } 
                
            }
        };
        eliminar.addActionListener(borrar);
        
        ActionListener search = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                items.ensureIndexIsVisible(modelo.indexOf(buscador.getText()));
                items.setSelectedIndex(modelo.indexOf(buscador.getText()));        
            }
        };
        buscar.addActionListener(search);
    }
}
