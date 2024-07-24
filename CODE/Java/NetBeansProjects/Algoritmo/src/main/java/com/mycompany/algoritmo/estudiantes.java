
package com.mycompany.algoritmo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class estudiantes extends JFrame{
    private JLabel titulo,nombre,apellido,cedula,fecha,telefono,correo;
    private JButton foto,save,borrar,ver,nuevo;
    private JTextField nom,ape,ci,tlf,gmail;
    private com.toedter.calendar.JDateChooser date;
    private JTable tabla;
    private JComboBox nums;
    private String ruta;
    private DefaultTableModel model;
    
    public estudiantes(){
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Algoritmos y Estructura - SQL");
        setLocationRelativeTo(null);    
        setResizable(false);     
        cerrar();
        initEti();
    }
    
    private void initEti(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.add(panel);
        
        titulo = new JLabel("Estudiantes");
        titulo.setBounds(100,40,250,40);
        titulo.setFont(new Font("",Font.BOLD,20));
        panel.add(titulo);
        
        nombre = new JLabel("Nombre: ");
        nombre.setBounds(100,210,250,40);
        nombre.setFont(new Font("",Font.BOLD,15));
        panel.add(nombre);
        
        apellido = new JLabel("Apellido: ");
        apellido.setBounds(100,240,250,40);
        apellido.setFont(new Font("",Font.BOLD,15));
        panel.add(apellido);
        
        cedula = new JLabel("Cedula: ");
        cedula.setBounds(100,270,250,40);
        cedula.setFont(new Font("",Font.BOLD,15));
        panel.add(cedula);
        
        fecha = new JLabel("Fecha de Nacimiento: ");
        fecha.setBounds(100,300,250,40);
        fecha.setFont(new Font("",Font.BOLD,15));
        panel.add(fecha);
        
        telefono = new JLabel("Telefono: ");
        telefono.setBounds(100,330,250,40);
        telefono.setFont(new Font("",Font.BOLD,15));
        panel.add(telefono);
        
        correo = new JLabel("Correo: ");
        correo.setBounds(100,360,250,40);
        correo.setFont(new Font("",Font.BOLD,15));
        panel.add(correo);
        
        initComp(panel);
    }
    
    private void initComp(JPanel panel){
        foto = new JButton("Foto");
        foto.setBounds(180,90,100,100);
        panel.add(foto);
        
        save = new JButton("Guardar/Editar");
        save.setBounds(100,430,150,40);
        panel.add(save);
        
        borrar = new JButton("Eliminar");
        borrar.setBounds(250,430,80,40);
        panel.add(borrar);
        
        ver = new JButton("Ver");
        ver.setBounds(330,430,50,40);
        panel.add(ver);
        
        nom = new JTextField();
        nom.setBounds(180,215,200,30);
        panel.add(nom);
  
        ape = new JTextField();
        ape.setBounds(180,245,200,30);
        panel.add(ape);
        
        ci = new JTextField();
        ci.setBounds(180,275,200,30);
        panel.add(ci);
        
        nums = new JComboBox(new String[] {"0414","0424","0412","0426"});
        nums.setBounds(180,336,100,30);
        panel.add(nums);
        
        tlf = new JTextField();
        tlf.setBounds(280,335,100,30);
        panel.add(tlf);
        
        gmail = new JTextField();
        gmail.setBounds(180,365,200,30);
        panel.add(gmail);
        
        Date hoy = new Date();
        hoy.setTime(hoy.getTime() - (24 * 60 * 60 * 1000));
        
        date = new com.toedter.calendar.JDateChooser();
        date.setBounds(280,305,100,30);
        date.setBackground(Color.WHITE);
        date.setMaxSelectableDate(hoy);
        
        panel.add(date);
        
        nuevo = new JButton("Nuevo Estudiante");
        nuevo.setBounds(100,470,280,40);
        panel.add(nuevo);
        
        model = new DefaultTableModel();
        
        tabla = new JTable(model);
        tabla.setBounds(400,110,350,400);
        tabla.setBackground(new Color(249, 249, 249));
        tabla.setDefaultEditor(Object.class, null);
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Cedula");
        panel.add(tabla);
        
        ListSelectionModel selectionModel = tabla.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JLabel catNom = new JLabel("Nombre");
        catNom.setBounds(400,90,117,20);
        catNom.setBackground(new Color(249, 249, 249));
        panel.add(catNom);
        
        JLabel catApe = new JLabel("Apellido");
        catApe.setBounds(517,90,117,20);
        catApe.setBackground(new Color(249, 249, 249));
        panel.add(catApe);
        
        JLabel catCed = new JLabel("Cedula");
        catCed.setBounds(634,90,117,20);
        catCed.setBackground(new Color(249, 249, 249));
        panel.add(catCed);
        
        actualizacion();
        
        eventos();
    }
    
    private void eventos(){
        
        ActionListener almacenar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                if(!gmail.getText().isBlank() && !nom.getText().isBlank() && !ape.getText().isBlank() && !ci.getText().isBlank() && !tlf.getText().isBlank() && !(date.getDate() == null) && !ruta.isBlank()){
                    char cadena[] = gmail.getText().toCharArray();
                    int cont = 0;
                    for(char letra : cadena){
                        if(letra == '@'){
                            cont += 1;
                        }
                        else if(letra == '.'){
                            cont += 1;
                        }
                    }
                    if(cont == 2){
                        String ciNuevo[] = new String[ci.getText().length() - 2];
                        int contador = 0;
                        for(char letra: ci.getText().toCharArray()){
                            if(letra == '.'){}
                            else{
                            ciNuevo[contador] = Character.toString(letra);
                            contador += 1;
                            }
                        }
                        boolean igual = false;
                
                        for (int i = 0; i < model.getRowCount(); i++) {
                            if(model.getValueAt(i, 2).equals(String.join("", ciNuevo))){
                                igual = true;
                            }
                        }
                        
                        if(igual){
                            int opcion = JOptionPane.showConfirmDialog(null, "Persona/Cedula ya ingresada, desea reemplazarlo?", "Edicion", JOptionPane.YES_NO_OPTION);
                            if(opcion == JOptionPane.YES_OPTION){
                                //Reemplazar
                                String numText = nums.getSelectedItem().toString() + tlf.getText();
                                String nombre = nom.getText();
                                String apellido = ape.getText();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                                Date d = date.getDate();
                                String fecha = sdf.format(d);
                                String gmailText = gmail.getText();
                                
                                try{
                                    Connection c = conexion.getConexion();
                                    PreparedStatement p = c.prepareStatement("UPDATE personas SET name=?,apellido=?,fecha=?,telefono=?,correo=?,imagen=? WHERE ci=?");
                                    
                                    p.setString(1, nombre);
                                    p.setString(2, apellido);
                                    p.setString(3, fecha);
                                    p.setString(4, numText);
                                    p.setString(5, gmailText);
                                    p.setString(6, ruta);
                                    p.setString(7, String.join("", ciNuevo));
                                    p.executeUpdate();
                                    
                                    actualizacion();
                                    
                                    foto.setIcon(new ImageIcon(""));
                                    foto.setText("Foto");   
                                    date.setDate(null);
                                    nom.setText("");
                                    ape.setText("");
                                    ci.setText("");
                                    gmail.setText("");
                                    tlf.setText("");  
                                    
                                }
                                catch(SQLException s){
                                }
                            }
                        }
                        else{
                            String nomText = nom.getText();
                            String apeText = ape.getText();
                            String ciN[] = new String[ci.getText().length() - 2];
                            
                            int ctr = 0;
                            for(char letra: ci.getText().toCharArray()){
                                if(letra == '.'){
                                }
                                else{
                                    ciN[ctr] = Character.toString(letra);
                                    ctr += 1;
                                }
                            }
                            
                            String numText = nums.getSelectedItem().toString() + tlf.getText();
                            String gmailText = gmail.getText();

                            try (Connection c = conexion.getConexion();
                                PreparedStatement p = c.prepareStatement("INSERT INTO personas (name,apellido,ci,fecha,telefono,correo,imagen) VALUES (?,?,?,?,?,?,?)")) {

                                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                                Date d = date.getDate();

                                p.setString(1, nomText);
                                p.setString(2, apeText);
                                p.setString(3, String.join("", ciN));
                                p.setString(4, sdf.format(d));
                                p.setString(5, numText);
                                p.setString(6, gmailText);
                                p.setString(7, ruta);
                                
                                p.executeUpdate();
                            
                                actualizacion();
                            
                                foto.setIcon(new ImageIcon(""));
                                foto.setText("Foto");   
                                date.setDate(null);
                                nom.setText("");
                                ape.setText("");
                                ci.setText("");
                                gmail.setText("");
                                tlf.setText("");                            

                            } 
                            catch (SQLException eTN) {
                                System.out.println(eTN);}                            
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Correo Incorrecto");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Rellene todos los campos");
                }
            }
        };
        save.addActionListener(almacenar);
        
        ActionListener buscar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFileChooser escoger = new JFileChooser();
                escoger.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            

                FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG & PNG & JPEG Images", "jpg", "png","jpeg");
                escoger.addChoosableFileFilter(filtro);
                escoger.setFileFilter(filtro);

                int resultado = escoger.showOpenDialog(null);

                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File fileName = escoger.getSelectedFile();

                    if ((fileName == null) || (fileName.getName().equals(""))) {} 
                    else {
                        String ruta1 = fileName.getAbsolutePath();
                        ruta = ruta1;
                        ImageIcon icono = new ImageIcon(ruta1);
                        Image imagen = icono.getImage();
                        try {
                            BufferedImage ima = ImageIO.read(fileName);
                            int w = ima.getWidth();
                            int h = ima.getHeight();
                            if(w == h){
                                Image nuevaImagen = imagen.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
                                foto.setIcon(new ImageIcon(nuevaImagen));
                                foto.setText("");                                
                            }
                            else{
                                int opcion = JOptionPane.showConfirmDialog(null, "La foto no es cuadrada desea redimensionarla?: ", "Edicion", JOptionPane.YES_NO_OPTION);
                                if(opcion == JOptionPane.YES_OPTION){
                                    Image nuevaImagen = imagen.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
                                    foto.setIcon(new ImageIcon(nuevaImagen));
                                    foto.setText("");                                      
                                }
                            }
                        } catch (IOException ex) {
                        }

                    }
                }
            }
        };
        foto.addActionListener(buscar);
        
        KeyListener teclado = new KeyAdapter(){
            
            public void keyTyped(KeyEvent e) {
                if(((tlf.getText().length() > 6) || !(e.getKeyChar() >= '0') || !(e.getKeyChar() <= '9')) && e.getSource() == tlf){
                    e.consume();
                }
                else if(((ci.getText().length() > 9) || !(e.getKeyChar() >= '0') || !(e.getKeyChar() <= '9')) && e.getSource() == ci){
                    e.consume();
                }
                else if(e.getSource() == ci){
                    if(ci.getText().length() == 2){
                        ci.setText(ci.getText() + ".");
                    }
                    else if(ci.getText().length() == 6){
                        ci.setText(ci.getText() + ".");
                    }
                }
                else if(e.getSource() == nom || e.getSource() == ape){
                    if(!(e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z') && !(e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z')){
                        e.consume();
                    }
                }
            }
        };
        tlf.addKeyListener(teclado);
        ci.addKeyListener(teclado);
        nom.addKeyListener(teclado);
        ape.addKeyListener(teclado);
        
        ActionListener estu = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                foto.setIcon(new ImageIcon(""));
                foto.setText("Foto");   
                date.setDate(null);
                nom.setText("");
                ape.setText("");
                ci.setText("");
                gmail.setText("");
                tlf.setText("");
            }
        };
        nuevo.addActionListener(estu);
        
        ActionListener visu = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                for (int i = 0; i < model.getRowCount(); i++) {
                    if(tabla.isRowSelected(i)){
                        String cid = tabla.getValueAt(i, 2).toString();
                        try (Connection c = conexion.getConexion()){
                            ResultSet r;
                            ResultSetMetaData md;
                            int col;
                              
                            PreparedStatement ps = c.prepareStatement("SELECT * FROM personas WHERE ci = ?");
                            ps.setString(1, cid);
                            r = ps.executeQuery();
                            md = r.getMetaData();
                            col = md.getColumnCount();
                            Object file[]= new Object[col];;
                            while(r.next()){
                                file = new Object[col];
                                for (int j = 0; j < col; j++) {
                                    file[j]=r.getObject(j + 1);
                                }
                            }
                            
                            ImageIcon im = new ImageIcon(file[6].toString());
                            Image imagen = im.getImage();
                            im = new ImageIcon(imagen.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
                            
                            
                            ArrayList lista = new ArrayList();
                            char cadena[] = file[4].toString().toCharArray();
                            
                            for (int j = 0; j < cadena.length; j++) {
                                if(j == 4){
                                    lista.add("-");
                                    lista.add(Character.toString(cadena[j]));
                                }
                                else{
                                    lista.add(Character.toString(cadena[j]));
                                }
                            }
                            
                            cadena = file[2].toString().toCharArray();
                            ArrayList listaC = new ArrayList();
                            
                            for (int j = 0; j < cadena.length; j++) {
                                if(j == 2 || j == 5){
                                    listaC.add(".");
                                    listaC.add(Character.toString(cadena[j]));
                                }
                                else{
                                    listaC.add(Character.toString(cadena[j]));
                                }
                            }
                            
                            String mes = "";
                            int numMes = Integer.valueOf(file[3].toString().substring(3,5));
                            
                            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                            Date d = df.parse(file[3].toString().replaceAll("-", "/"));
                            date.setDate(d);
                            
                            nom.setText(file[0].toString());
                            ape.setText(file[1].toString());
                            ci.setText(String.join("", listaC));
                            tlf.setText(String.join("", lista).substring(5, 12));
                            gmail.setText(file[5].toString());
                            ImageIcon im2 = new ImageIcon(file[6].toString());
                            ruta = file[6].toString();
                            Image imagen2 = im.getImage();
                            im2 = new ImageIcon(imagen2.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH));
                            foto.setIcon(im2);
                            foto.setText("");
                            
                            String num = String.join("", lista).substring(0, 4);
                            if(num.equals("0414")) nums.setSelectedItem(num);
                            else if(num.equals("0424"))nums.setSelectedItem(num);
                            else if(num.equals("0412"))nums.setSelectedItem(num);
                            else if(num.equals("0426"))  nums.setSelectedItem(num);
                                    
                            if(numMes == 1) mes = "enero";
                            else if(numMes == 2) mes = "febrero";
                            else if(numMes == 3) mes = "marzo";
                            else if(numMes == 4) mes = "abril";
                            else if(numMes == 5) mes = "mayo";
                            else if(numMes == 6) mes = "junio";
                            else if(numMes == 7) mes = "julio";
                            else if(numMes == 8) mes = "agosto";
                            else if(numMes == 9) mes = "septiembre";
                            else if(numMes == 10) mes = "octubre";
                            else if(numMes == 11) mes = "noviembre";
                            else if(numMes == 12) mes = "diciembre";
                            
                            file[3] = file[3].toString().substring(0,2) +" de " + mes+" de " + file[3].toString().substring(6,10);
                            
                            JOptionPane.showMessageDialog(null, "Nombre: " + file[0]  + " "+ file[1] + "\n"
                                    + "Cedula: "+ String.join("", listaC) + "\n"
                                    + "Fecha de Nacimiento: "+ file[3] + "\n"
                                    + "Telefono: "+ String.join("", lista) + "\n"
                                    + "Correo: "+ file[5] + "\n","Estudiante",JOptionPane.INFORMATION_MESSAGE,im);
                        } 
                        catch (SQLException eTN) {
                            System.err.println("Error executing the query: " + eTN.getMessage());
                        } catch (ParseException ex) {
                            System.out.println(e);
                        }              
                    }
                }
            }
        };
        ver.addActionListener(visu);
        
        ActionListener eliminar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    if(tabla.isRowSelected(i)){
                        String cedBorrar = model.getValueAt(i, 2).toString();
                        try{
                            Connection c = conexion.getConexion();
                            PreparedStatement p = c.prepareStatement("DELETE FROM personas WHERE ci=?");
                            p.setString(1, cedBorrar);
                            p.executeUpdate();
                            actualizacion();
                        }
                        catch(SQLException enm){
                            
                        }
                    }
                }
            }
        };
        borrar.addActionListener(eliminar);
        
        
    }
    
    private void actualizacion(){
        
        model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Cedula");
        tabla.setModel(model);        
        
        try (Connection c = conexion.getConexion()){
            ResultSet r;
            ResultSetMetaData md;
            int col;
            
            PreparedStatement ps = c.prepareStatement("SELECT name,apellido,ci FROM personas");
            r = ps.executeQuery();
            md = r.getMetaData();
            col = md.getColumnCount();
            
            while(r.next()){
                Object file[] = new Object[col];
                for (int i = 0; i < col; i++) {
                    file[i]=r.getObject(i + 1);
                }
                model.addRow(file);
            }
        } catch (SQLException eTN) {
            System.err.println("Error executing the query: " + eTN.getMessage());
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
