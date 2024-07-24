package com.mycompany.empresa;

import static com.mycompany.empresa.inventario.modelo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class combos extends JFrame {

    public combos() {
        setSize(900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Menu - Combos de Productos");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        cerrar();
        visualizar();
    }

    private DefaultListModel modelo = new DefaultListModel(),modelo2 = new DefaultListModel();
    private JButton anadir = new JButton("Añadir"), eliminar = new JButton("Eliminar"), detalles = new JButton("Detalles"),mas = new JButton("Añadir"),listo = new JButton("Listo");
    private JList listaCom,listaPro = new JList(modelo2);
    private ArrayList<String> comboPro = new ArrayList<String>();
    private String combo[] = new String[4];


    protected void visualizar() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        add(panel);

        JLabel labelInv = new JLabel("Combos");
        labelInv.setBounds(50, 50, 150, 30);
        labelInv.setFont(new Font("", Font.BOLD, 20));
        panel.add(labelInv);

        listaCom = new JList(modelo);
        listaCom.setBounds(50, 150, 800, 350);

        JScrollPane deslizar = new JScrollPane(listaCom);
        deslizar.setBounds(50, 150, 800, 350);
        panel.add(deslizar);
        
        listaPro.setBounds(925, 150, 200, 350);
        
        JScrollPane mover = new JScrollPane(listaPro);
        mover.setBounds(925, 150, 200, 350);
        panel.add(mover);        

        anadir.setBounds(50, 90, 100, 40);
        anadir.setFont(new Font("", Font.PLAIN, 15));
        panel.add(anadir);

        eliminar.setBounds(150, 90, 100, 40);
        eliminar.setFont(new Font("", Font.PLAIN, 15));
        panel.add(eliminar);

        detalles.setBounds(250, 90, 100, 40);
        detalles.setFont(new Font("", Font.PLAIN, 15));
        panel.add(detalles);
        
        mas.setBounds(925,90,100,50);
        panel.add(mas);
        
        listo.setBounds(1025,90,100,50);
        panel.add(listo);
        
        actualizar();
        eventos();
    }

    private void eventos() {
        ActionListener agregar = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSize(1200,600);
                setLocationRelativeTo(null);
                anadir.setEnabled(false);
                eliminar.setEnabled(false);
                leerPro();
                
                combo = new String[4];
                
                do{
                    combo[0] = JOptionPane.showInputDialog(null,"Ingrese el nombre del combo: ","Combo",JOptionPane.PLAIN_MESSAGE);
                }while(combo[0].equals(""));
                
                do{
                    combo[1] = JOptionPane.showInputDialog(null,"Ingrese el codigo del combo: ","Combo",JOptionPane.PLAIN_MESSAGE);
                }while(combo[1].equals(""));                
                
                JOptionPane.showMessageDialog(null, "Seleccione un producto y pulse 'Añadir'");
                
                
            }
        };
        anadir.addActionListener(agregar);
        
        ActionListener terminar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setSize(900, 600);
                setLocationRelativeTo(null);
                anadir.setEnabled(true);
                eliminar.setEnabled(true);
                
                try{
                    int precio = 0;
                    for (String producto : comboPro) {
                        Scanner lector = new Scanner(new File("productos.txt"));
                        int cont = 0,index = 0;
                        while(lector.hasNextLine()){
                            String pal = lector.nextLine();
                            if(pal.equals(producto)){
                                index = cont;
                            }
                            cont += 1;
                        }
                        lector.close();
                        
                        lector = new Scanner(new File("precio.txt"));
                        
                        cont = 0;
                        while(lector.hasNextLine()){
                            int n = Integer.parseInt(lector.nextLine());
                            if(cont == index){
                                precio += n;
                            }
                            cont += 1;
                        }
                        lector.close();
                    }
                    do{
                        combo[2] = JOptionPane.showInputDialog(null,"Ingrese el precio del combo ( >= " + precio + " ) : ","Combo",JOptionPane.PLAIN_MESSAGE);
                    }while(combo[2].equals("") || esNumero(combo[2]));                
                    
                    
                    FileWriter escritor = new FileWriter("combos.txt",true);
                    
                    String productos = String.join(":", comboPro);
                    
                    String comboCompleto[] = {combo[0],combo[1],productos,combo[2]};
                    
                    escritor.write(String.join(",",comboCompleto) + "\n");
                    
                    escritor.close();
                }
                catch(IOException egn){
                    
                }
                
                modelo2.clear();
                
                comboPro.clear();
                actualizar();
            }
        };
        listo.addActionListener(terminar);
        
        ActionListener agarrar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!listaPro.isSelectionEmpty()){
                    comboPro.add(listaPro.getSelectedValue().toString());
                    modelo2.removeElement(listaPro.getSelectedValue());
                }
            }   
        };
        mas.addActionListener(agarrar);
        
        ActionListener details = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!listaCom.isSelectionEmpty()){
                    try{
                        String comboCompleto[] = new String[4];
                        Scanner lector = new Scanner(new File("combos.txt"));
                        int cont = 0,n = listaCom.getSelectedIndex();
                        while(lector.hasNextLine()){
                            String combo = lector.nextLine();
                            if(cont == n){
                                comboCompleto = combo.split(",");
                            }
                            cont += 1;
                        }
                        lector.close();
                        JOptionPane.showMessageDialog(null, new String[]{"Nombre: " + comboCompleto[0],"Codigo: "+comboCompleto[1] ,"Productos: "+ comboCompleto[2],"Precio: "+comboCompleto[3]}, "Combo", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                    catch(IOException egn){
                        
                    }
                    
                }
            }
            
        };
        detalles.addActionListener(details);
        ActionListener delete = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                    Scanner lector = new Scanner(new File("combos.txt"));
                    FileWriter escritor = new FileWriter("apoyo.txt");
                    
                    int n = listaCom.getSelectedIndex(),cont = 0;
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
                    escritor = new FileWriter("combos.txt");
                    
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
    
    private void actualizar(){
        modelo.clear();
        
        try{
            Scanner lector = new Scanner(new File("combos.txt"));

            while(lector.hasNextLine()){
                modelo.addElement(lector.nextLine().split(",")[0]);
            }
            lector.close();
        }
        catch(IOException enm){
        }        
    }

    private void leerPro(){
        try{
            Scanner lector = new Scanner(new File("productos.txt"));
            
            while(lector.hasNextLine()){
                modelo2.addElement(lector.nextLine());
            }
            
            lector.close();
        }
        catch(IOException env){
            
        }
    }

    protected static boolean esNumero(String numero) {
        try {
            int num = Integer.parseInt(numero);
            return false;
        } catch (NumberFormatException evne) {
            return true;
        }
    }
    


    private void cerrar() {
        WindowListener cierre = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Empresa centro = new Empresa();
                centro.setVisible(true);
                dispose();
            }
        };
        addWindowListener(cierre);
    }
}
