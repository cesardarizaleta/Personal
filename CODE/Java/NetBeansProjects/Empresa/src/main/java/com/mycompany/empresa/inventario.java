
package com.mycompany.empresa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class inventario extends JFrame{
    
    public inventario(){
        setSize(900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Menu - Inventario");
        setLocationRelativeTo(null);
        setResizable(false);       
        setVisible(true);
        cerrar();
        iniInven();
    }
    
    protected static DefaultListModel modelo = new DefaultListModel();
    private JButton anadir = new JButton("Añadir"), eliminar = new JButton("Eliminar"),detalles = new JButton("Detalles");
    private JList lista;
    private JRadioButton dolares,bolivares;
    
    private void iniInven(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        add(panel);
        
        JLabel labelInv = new JLabel("Inventario");
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
        
        dolares = new JRadioButton("Dolares($)");
        dolares.setSelected(true);
        dolares.setBounds(360,90,100,40);
        panel.add(dolares);
        
        bolivares = new JRadioButton("Bolivares(Bs)");
        bolivares.setSelected(true);
        bolivares.setBounds(465,90,150,40);
        panel.add(bolivares);
        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(dolares);
        grupo.add(bolivares);
        
        
        leerPro();
        eventos();

    }
    
    private void eventos(){
        ActionListener agregar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                FileWriter escritor = null;
                String produc[] = new String[4];
                try{
                    escritor = new FileWriter("productos.txt",true);
                    
                do{
                    produc[0] = JOptionPane.showInputDialog(null,"Ingrese el nombre del producto: ","Producto",JOptionPane.PLAIN_MESSAGE);
                }while(produc[0].equals(""));
                
                do{
                    produc[1] = JOptionPane.showInputDialog(null,"Ingrese el codigo del producto: ","Producto",JOptionPane.PLAIN_MESSAGE);                    
                }while(produc[1].equals(""));
                
                do{
                    produc[2] = JOptionPane.showInputDialog(null,"Ingrese la cantidad del producto: ","Producto",JOptionPane.PLAIN_MESSAGE);                    
                }while(produc[2].equals("") || esNumero(produc[2]));        
                
                do{
                    produc[3] = JOptionPane.showInputDialog(null,"Ingrese el precio del producto($): ","Producto",JOptionPane.PLAIN_MESSAGE);                    
                }while(produc[3].equals("") || esNumero(produc[3]));                    
                
                    escritor.write(produc[0] + "\n");
                    escritor.close();
                    
                    escritor = new FileWriter("codigo.txt",true);
                    escritor.write(produc[1] + "\n");
                    escritor.close();
                    
                    escritor = new FileWriter("cantidad.txt",true);
                    escritor.write(produc[2] + "\n");
                    escritor.close();
                    
                    escritor = new FileWriter("precio.txt",true);
                    escritor.write(produc[3] + "\n");
                    escritor.close();
                
                }
                catch(IOException evm){
                }
                
                leerPro();
            }
        };
        anadir.addActionListener(agregar);
        
        ActionListener borrar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int numBorrar = lista.getSelectedIndex();
                modelo.remove(lista.getSelectedIndex());
                try {
                    
                    Scanner lectura  = new Scanner(new File("codigo.txt"));
                    FileWriter escrituraNueva = new FileWriter("apoyo.txt");
                    int contador = 0;
                    while(lectura.hasNextLine()){
                        if(contador == numBorrar){
                            lectura.nextLine();
                        }
                        else{
                            escrituraNueva.write(lectura.nextLine() + "\n");
                        }
                        contador = contador + 1;
                    }   
                    escrituraNueva.close();
                    lectura.close();
                    
                    escrituraNueva = new FileWriter("codigo.txt");
                    lectura  = new Scanner(new File("apoyo.txt"));
                    
                    while(lectura.hasNextLine()){
                        escrituraNueva.write(lectura.nextLine() + "\n");
                    }
                    escrituraNueva.close();
                    lectura.close();
                    
                    lectura  = new Scanner(new File("cantidad.txt"));
                    escrituraNueva = new FileWriter("apoyo.txt");
                    contador = 0;
                    while(lectura.hasNextLine()){
                        if(contador == numBorrar){
                            lectura.nextLine();
                        }
                        else{
                            escrituraNueva.write(lectura.nextLine() + "\n");
                        }
                        contador = contador + 1;
                    }   
                    escrituraNueva.close();
                    lectura.close();
                    
                    escrituraNueva = new FileWriter("cantidad.txt");
                    lectura  = new Scanner(new File("apoyo.txt"));
                    
                    while(lectura.hasNextLine()){
                        escrituraNueva.write(lectura.nextLine() + "\n");
                    }
                    escrituraNueva.close();
                    lectura.close();
                    
                    lectura  = new Scanner(new File("precio.txt"));
                    escrituraNueva = new FileWriter("apoyo.txt");
                    contador = 0;
                    while(lectura.hasNextLine()){
                        if(contador == numBorrar){
                            lectura.nextLine();
                        }
                        else{
                            escrituraNueva.write(lectura.nextLine() + "\n");
                        }
                        contador = contador + 1;
                    }   
                    escrituraNueva.close();
                    lectura.close();
                    
                    escrituraNueva = new FileWriter("precio.txt");
                    lectura  = new Scanner(new File("apoyo.txt"));
                    
                    while(lectura.hasNextLine()){
                        escrituraNueva.write(lectura.nextLine() + "\n");
                    }
                    escrituraNueva.close();
                    lectura.close();
                    
                    FileWriter sobreescritorName = new FileWriter("productos.txt");

                    for (int i = 0; i < modelo.getSize(); i++) {
                        sobreescritorName.write((String)modelo.getElementAt(i) + "\n");
                    }
                    sobreescritorName.close();
                    
                    } 
                    
                    
                catch (IOException i) {} 
            }
        };
        eliminar.addActionListener(borrar);
        
        ActionListener details = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int busqueda = lista.getSelectedIndex(),contar = 0;
                String objDetalles[] = new String[4];
                try{
                    Scanner buscar = new Scanner(new File("productos.txt"));
                    while(buscar.hasNextLine()){
                        if(contar == busqueda){
                            objDetalles[0] = buscar.nextLine();
                        }
                        else{
                            buscar.nextLine();
                        }
                        contar = contar + 1;
                    }
                    buscar = new Scanner(new File("codigo.txt"));
                    contar = 0;
                    while(buscar.hasNextLine()){
                        if(contar == busqueda){
                            objDetalles[1] = buscar.nextLine();
                        }
                        else{
                            buscar.nextLine();
                        }
                        contar = contar + 1;
                    }
                    buscar = new Scanner(new File("cantidad.txt"));
                    contar = 0;
                    while(buscar.hasNextLine()){
                        if(contar == busqueda){
                            objDetalles[2] = buscar.nextLine();
                        }
                        else{
                            buscar.nextLine();
                        }
                        contar = contar + 1;
                    }
                    buscar = new Scanner(new File("precio.txt"));
                    contar = 0;
                    while(buscar.hasNextLine()){
                        if(contar == busqueda){
                            objDetalles[3] = buscar.nextLine();
                        }
                        else{
                            buscar.nextLine();
                        }
                        contar = contar + 1;
                    }
                }
                catch(IOException envmg){
                }
                String detalleName = "Nombre: " + objDetalles[0];
                String detalleCod = "Codigo: " + objDetalles[1];
                String detalleCant = "Cantidad: " + objDetalles[2];
                String detallePre;
                
                if(dolares.isSelected()){
                    detallePre = "Precio: " + objDetalles[3] + " $";
                }
                else{
                    if(tasa.dolar.getText().equals("")){
                        detallePre = "Precio: " + Double.parseDouble(objDetalles[3]) * 37 + " Bs";
                    }
                    else{
                        detallePre = "Precio: " + Double.parseDouble(objDetalles[3]) * Integer.parseInt(tasa.dolar.getText()) + " Bs";
                    }
                    
                }
                
                JOptionPane.showMessageDialog(null, new String[]{detalleName,detalleCod , detalleCant,detallePre}, "Producto", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        detalles.addActionListener(details);
    }
    
    private void leerPro(){
        modelo.clear();
        Scanner fileinv = null;
        try {
            fileinv = new Scanner(new File("productos.txt"));
        }
        catch(IOException env){
        }
        
        while(fileinv.hasNextLine()){
            modelo.addElement(fileinv.nextLine());
        }
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
