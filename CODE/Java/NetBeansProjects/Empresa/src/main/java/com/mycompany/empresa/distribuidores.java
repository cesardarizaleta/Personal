
package com.mycompany.empresa;

import static com.mycompany.empresa.inventario.modelo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class distribuidores extends JFrame{
    public distribuidores(){
        setSize(900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Menu - Distribuidores");
        setLocationRelativeTo(null);
        setResizable(false);       
        setVisible(true);
        cerrar();
        visual();
    }
    
    protected static DefaultListModel modeloDis = new DefaultListModel();
    private JButton anadir = new JButton("Añadir"), eliminar = new JButton("Eliminar"),detalles = new JButton("Detalles");
    private JList lista;
    
    
    private void visual(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        add(panel);
        
        JLabel labelInv = new JLabel("Distribuidores");
        labelInv.setBounds(50,50,150,30);
        labelInv.setFont(new Font("",Font.BOLD,20));
        panel.add(labelInv);
        
        lista = new JList(modelo);
        lista.setBounds(50,150,800,350);
        
        JScrollPane deslizar = new JScrollPane(lista);
        deslizar.setBounds(50,150,800,350);
        panel.add(deslizar);
        
        anadir.setBounds(50,90,100,40);
        anadir.setFont(new Font("",Font.PLAIN,15));
        panel.add(anadir);
        
        eliminar.setBounds(150,90,100,40);
        eliminar.setFont(new Font("",Font.PLAIN,15));
        panel.add(eliminar);
        
        detalles.setBounds(250,90,100,40);
        detalles.setFont(new Font("",Font.PLAIN,15));
        panel.add(detalles);
        
        actualizar();
        eventos();
    }
    
    private void eventos(){
        ActionListener mas = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String dis[] = new String[4];
                do{
                    dis[0] = JOptionPane.showInputDialog(null,"Ingrese el nombre del distribuidor: ","Distribuidor",JOptionPane.PLAIN_MESSAGE);
                }while(dis[0].equals(""));
                
                do{
                    dis[1] = JOptionPane.showInputDialog(null,"Ingrese un identificador: ","Distribuidor",JOptionPane.PLAIN_MESSAGE);
                }while(dis[1].equals(""));       
                
                do{
                    dis[2] = JOptionPane.showInputDialog(null,"Ingrese una direccion corta: ","Distribuidor",JOptionPane.PLAIN_MESSAGE);
                }while(dis[2].equals(""));
                
                do{
                    dis[3] = JOptionPane.showInputDialog(null,"Ingrese un numero telefonico (04148369261) : ","Distribuidor",JOptionPane.PLAIN_MESSAGE);
                }while(dis[3].equals("") && !esNumero(dis[3]));
                
                
                try{
                    FileWriter escritor = new FileWriter("distribuidores.txt",true);
                    
                    for (int i = 0; i < dis.length; i++) {
                        escritor.write(dis[i] + ",");
                    }
                    escritor.write("\n");
                    
                    escritor.close();
                    
                }catch(IOException evn){
                }
                actualizar();
            }
            
        };
        anadir.addActionListener(mas);
        
        ActionListener details = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                    Scanner lector = new Scanner(new File("distribuidores.txt"));
                    String valores[] = new String[4];
                    int n = lista.getSelectedIndex(),cont = 0;
                    
                    while(lector.hasNextLine()){
                        
                        if(cont == n){
                            valores = lector.nextLine().split(",");

                        }
                        else{
                            lector.nextLine();
                        }
                        
                        cont += 1;
                    }
                    lector.close();
                    
                    valores[0] = "Nombre: " + valores[0];
                    valores[1] = "Identificador: " + valores[1];
                    valores[2] = "Direccion: " + valores[2];
                    valores[3] = "Numero: " + valores[3];
                    
                    JOptionPane.showMessageDialog(null, new String[]{valores[0],valores[1] , valores[2],valores[3]}, "Distribuidor", JOptionPane.INFORMATION_MESSAGE);
                }
                catch(IOException vmg){
                    
                }
            }  
        };
        detalles.addActionListener(details);
        
        ActionListener delete = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                    Scanner lector = new Scanner(new File("distribuidores.txt"));
                    FileWriter escritor = new FileWriter("apoyo.txt");
                    
                    int n = lista.getSelectedIndex(),cont = 0;
                    modelo.remove(n);
                    while(lector.hasNextLine()){
                        if(cont == n){
                            escritor.write("");
                            lector.nextLine();
                        }
                        else{
                            escritor.write(lector.nextLine() + "\n");
                        }
                        
                        cont += 1;
                        
                    }
                    lector.close();
                    escritor.close();
                    
                    lector = new Scanner(new File("apoyo.txt"));
                    escritor = new FileWriter("distribuidores.txt");
                    
                    while(lector.hasNextLine()){
                        escritor.write(lector.nextLine() + "\n");
                    }
                    
                    lector.close();
                    escritor.close();
                    
                    actualizar();
                    
                }
                catch(IOException egn){
                    
                }
            }
            
        };
        eliminar.addActionListener(delete);
    }
    
    private boolean esNumero(String numero){
        try{
            double num = Double.parseDouble(numero);
            return false;
        }
        catch(NumberFormatException evne){
            return true;
        }
    }    
    
    private void actualizar(){
        modelo.clear();
        
        try{
            Scanner lector = new Scanner(new File("distribuidores.txt"));

            while(lector.hasNextLine()){
                modelo.addElement(lector.nextLine().split(",")[0]);
                
            }
            lector.close();
        }
        catch(IOException enm){
        }
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
