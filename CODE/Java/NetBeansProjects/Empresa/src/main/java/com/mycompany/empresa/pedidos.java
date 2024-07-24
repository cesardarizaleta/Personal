
package com.mycompany.empresa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.*;

public class pedidos extends JFrame{
    public pedidos(){
        setSize(900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Menu - Pedidos");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);   
        cerrar();
        init();
    }
    
    private DefaultListModel modelo = new DefaultListModel(),modelo2 = new DefaultListModel();
    private JButton anadir = new JButton("Añadir"), eliminar = new JButton("Eliminar"), detalles = new JButton("Detalles"),mas = new JButton("Añadir"),listo = new JButton("Listo"),listo2 = new JButton("Listo");
    private JList listaPed,listaCom = new JList(modelo2);
    private String pedido[] = new String[4];
    private ArrayList<String> lista = new ArrayList<String>();
    
    private void init(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        add(panel);

        JLabel labelInv = new JLabel("Pedidos");
        labelInv.setBounds(50, 50, 150, 30);
        labelInv.setFont(new Font("", Font.BOLD, 20));
        panel.add(labelInv);

        listaPed = new JList(modelo);
        listaPed.setBounds(50, 150, 800, 350);

        JScrollPane deslizar = new JScrollPane(listaPed);
        deslizar.setBounds(50, 150, 800, 350);
        panel.add(deslizar);     
        
        listaCom.setBounds(925, 150, 200, 350);
        
        JScrollPane mover = new JScrollPane(listaCom);
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
        
        listo2.setBounds(1025,90,100,50);
        panel.add(listo2);
        listo2.setVisible(false);
        
        actualizar();
        evento();
    }
    
    private void evento(){
        ActionListener agregar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setSize(1200,600);
                setLocationRelativeTo(null);
                anadir.setEnabled(false);
                eliminar.setEnabled(false);    
                leerDis();
                
                listo.setBounds(925,90,200,50);
                mas.setVisible(false);
                
                
                pedido = new String[4];
                
                do{
                    pedido[0] = JOptionPane.showInputDialog(null,"Ingrese la fecha de solicitud (DD/MM/AAAA) : ","Pedido",JOptionPane.PLAIN_MESSAGE);
                }while(pedido[0].equals("") || !Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((19|20)\\d\\d)$").matcher(pedido[0]).matches());

                do{
                    pedido[1] = JOptionPane.showInputDialog(null,"Ingrese la fecha de entrega (DD/MM/AAAA) : ","Pedido",JOptionPane.PLAIN_MESSAGE);
                }while(pedido[1].equals("") || !Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((19|20)\\d\\d)$").matcher(pedido[1]).matches());

                mas.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Seleccione un distribuidor y pulse 'Listo'");
                

            }
        };
        anadir.addActionListener(agregar);
        
        ActionListener terminado = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!listaCom.isSelectionEmpty()){
                    if((pedido[2] == null)){
                        
                        pedido[2] = listaCom.getSelectedValue().toString();
                        
                        
                        listo2.setBounds(1025,90,100,50);
                        mas.setVisible(true);
                        mas.setEnabled(true);
                        leerCom();
                        listo.setVisible(false);
                        listo2.setVisible(true);
                    }
                }
            }
        };
        listo.addActionListener(terminado);
        
        ActionListener terminado2 = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                int precio = buscarPre();
                
                do{
                    pedido[3] = JOptionPane.showInputDialog(null,"Ingrese el precio ( >= " + precio + " $) : ","Pedido",JOptionPane.PLAIN_MESSAGE);
                }while(pedido[3].equals(""));
                
                try{
                    FileWriter escritor = new FileWriter("pedidos.txt",true);
                    String combosTodos = String.join(":", lista);
                    String pedidoCompleto[] = {pedido[0],pedido[1],combosTodos,pedido[2],pedido[3]};
                    
                    escritor.write(String.join(",", pedidoCompleto) + "\n");
                    
                    escritor.close();
                }
                catch(IOException ehb){
                }
                
                pedido = new String[4];
                
                actualizar();
                        
                lista.clear();
                setSize(900, 600);
                setLocationRelativeTo(null);     
                anadir.setEnabled(true);
                eliminar.setEnabled(true);
            }
        };
        listo2.addActionListener(terminado2);
        
        ActionListener agarrar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!(listaCom.isSelectionEmpty())){
                    lista.add(listaCom.getSelectedValue().toString());
                    modelo2.remove(listaCom.getSelectedIndex());
                }
            }
            
        };
        mas.addActionListener(agarrar);
        
        ActionListener delete = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!(listaPed.isSelectionEmpty())){
                    try{
                        Scanner lector = new Scanner(new File("pedidos.txt"));
                        FileWriter escritor = new FileWriter("apoyo.txt");
                        modelo.clear();
                        int n = listaPed.getSelectedIndex(),cont = 0;
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
                        escritor = new FileWriter("pedidos.txt");
                        
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
            }
        };
        eliminar.addActionListener(delete);
        
        ActionListener details = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!(listaPed.isSelectionEmpty())){
                    try{
                        String pedidoCompleto[] = new String[4];
                        Scanner lector = new Scanner(new File("pedidos.txt"));
                        int cont = 0,n = listaPed.getSelectedIndex();
                        while(lector.hasNextLine()){
                            String pedido = lector.nextLine();
                            if(cont == n){
                                pedidoCompleto = pedido.split(",");
                            }
                            cont += 1;
                        }
                        lector.close();
                        String.join(",", pedidoCompleto);
                        JOptionPane.showMessageDialog(null, new String[]{"Fecha de Solicitud: " + pedidoCompleto[0],"Fecha de Entrega: "+pedidoCompleto[1] ,"Combos: "+ pedidoCompleto[2],"Distribuidor: "+pedidoCompleto[3],"Total: "+pedidoCompleto[4] + " $"}, "Pedido", JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(IOException ehn){
                        
                    }
                }
            }
        };
        detalles.addActionListener(details);
    }
    
    
    private int buscarPre(){
        int precio = 0;
        
        
        try{
            for (String combo : lista) {
                Scanner lector = new Scanner(new File("combos.txt"));
            
                while(lector.hasNextLine()){
                    String nombre = lector.nextLine();
                    if(nombre.split(",")[0].equals(combo)){
                        precio += Integer.parseInt(nombre.split(",")[3]);
                    }
                }
                lector.close();
            }

            
        }
        catch(IOException ebn){
        }
        
        return precio;
    }
    
    private void actualizar(){
        try{
            Scanner lector = new Scanner(new File("pedidos.txt"));

            while(lector.hasNextLine()){
                modelo.addElement(lector.nextLine().split(",")[2]);
            }
            lector.close();
        }
        catch(IOException enm){
        }            
    }
    
    private void leerCom(){
        modelo2.clear();
        try{
            Scanner lector = new Scanner(new File("combos.txt"));
            
            while(lector.hasNextLine()){
                modelo2.addElement(lector.nextLine().split(",")[0]);
            }
            lector.close();
        }
        catch(IOException egb){
        }        
    }
    
    private void leerDis(){
        modelo2.clear();
        try{
            Scanner lector = new Scanner(new File("distribuidores.txt"));
            
            while(lector.hasNextLine()){
                modelo2.addElement(lector.nextLine().split(",")[0]);
            }
            lector.close();
        }
        catch(IOException egb){
            
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
