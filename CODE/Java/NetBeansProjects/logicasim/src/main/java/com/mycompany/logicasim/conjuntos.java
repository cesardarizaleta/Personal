package com.mycompany.logicasim;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;
import javax.swing.*;

public class conjuntos extends JFrame {

    public conjuntos() {
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Conjuntos");
        setLocationRelativeTo(null);
        setResizable(false);
        visual();
    }

    public void visual() {
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.add(panel);

        JLabel opcion = new JLabel("Rellenar los Subconjuntos: ");
        opcion.setBounds(50, 50, 300, 30);
        opcion.setFont(new Font("calibri",Font.BOLD,20));
        panel.add(opcion);
        
        JButton manual = new JButton("Manual");
        manual.setBounds(50,90,100,40);
        manual.setFont(new Font("calibri",Font.PLAIN,15));
        manual.setEnabled(false);
        panel.add(manual);
       
        JButton auto = new JButton("Automatico");
        auto.setBounds(150,90,120,40);
        auto.setFont(new Font("calibri",Font.PLAIN,15));
        panel.add(auto); 
        
        eliminarA.setBounds(390,190,40,40);
        eliminarA.setFont(new Font("calibri",Font.PLAIN,15));
        eliminarA.setVisible(false);
        panel.add(eliminarA); 
        
        eliminarB.setBounds(390,240,40,40);
        eliminarB.setFont(new Font("calibri",Font.PLAIN,15));
        eliminarB.setVisible(false);
        panel.add(eliminarB);
        
        eliminarC.setBounds(390,290,40,40);
        eliminarC.setFont(new Font("calibri",Font.PLAIN,15));
        eliminarC.setVisible(false);
        panel.add(eliminarC);
        
        eliminarD.setBounds(390,340,40,40);
        eliminarD.setFont(new Font("calibri",Font.PLAIN,15));
        eliminarD.setVisible(false);
        panel.add(eliminarD);
        
        eliminarU.setBounds(390,390,40,40);
        eliminarU.setFont(new Font("calibri",Font.PLAIN,15));
        eliminarU.setVisible(false);
        panel.add(eliminarU); 

        
        JLabel example = new JLabel("Ejemplo: 1,2,3,4,5,6,7,8,9,10");
        example.setBounds(80,180,120,20);
        example.setFont(new Font("calibri",Font.ITALIC,10));
        panel.add(example);
        
        JLabel A = new JLabel("A:");
        A.setBounds(50,200,20,20);
        A.setFont(new Font("calibri",Font.BOLD,15));
        panel.add(A);
        JLabel B = new JLabel("B:");
        B.setBounds(50,250,20,20);
        B.setFont(new Font("calibri",Font.BOLD,15));
        panel.add(B);
        JLabel C = new JLabel("C:");
        C.setBounds(50,300,20,20);
        C.setFont(new Font("calibri",Font.BOLD,15));
        panel.add(C);
        JLabel D = new JLabel("D:");
        D.setBounds(50,350,20,20);
        D.setFont(new Font("calibri",Font.BOLD,15));
        panel.add(D);
        JLabel U = new JLabel("U:");
        U.setBounds(50,400,20,20);
        U.setFont(new Font("calibri",Font.BOLD,15));
        panel.add(U);
        
        JButton ejecutar = new JButton("Ejecutar");
        ejecutar.setBounds(50,450,220,40);
        ejecutar.setFont(new Font("calibri",Font.PLAIN,15));
        panel.add(ejecutar);
        
        String[] todos = {a,b,c,d,e,f,g2,g,h,i,j,k,l,m,n,o,p,q,r,r1,r2,s,t,u,v,w,x,y,z,z1,z2,z3,z4};        
        JComboBox oper = new JComboBox(todos);
        oper.setBounds(270,450,150,50);
        panel.add(oper);
        
        JLabel elegir = new JLabel("Operacion:");
        elegir.setBounds(275,445,100,20);
        elegir.setFont(new Font("calibri",Font.ITALIC,10));
        panel.add(elegir);
        
        JLabel valid = new JLabel("   Colocar 20 elementos en el universal (U)");
        valid.setBounds(50,490,220,20);
        valid.setFont(new Font("calibri",Font.ITALIC,10));
        panel.add(valid);
        
        JTextField conjA = new JTextField();
        conjA.setBounds(80,200,300,20);
        conjA.setFont(new Font("calibri",Font.ITALIC,10));
        panel.add(conjA);
        
        JTextField conjB = new JTextField();
        conjB.setBounds(80,250,300,20);
        conjB.setFont(new Font("calibri",Font.ITALIC,10));
        panel.add(conjB);
      
        JTextField conjC = new JTextField();
        conjC.setBounds(80,300,300,20);
        conjC.setFont(new Font("calibri",Font.ITALIC,10));
        panel.add(conjC);
        
        JTextField conjD = new JTextField();
        conjD.setBounds(80,350,300,20);
        conjD.setFont(new Font("calibri",Font.ITALIC,10));
        panel.add(conjD);
        
        JTextField conjU = new JTextField();
        conjU.setBounds(80,400,300,20);
        conjU.setFont(new Font("calibri",Font.ITALIC,10));
        panel.add(conjU);
        
        respuesta.setBounds(500,100,350,20);
        respuesta.setFont(new Font("calibri",Font.BOLD,15));
        panel.add(respuesta);
        
        seleccion.setBounds(500,50,250,20);
        seleccion.setFont(new Font("calibri",Font.BOLD,15));
        panel.add(seleccion);
        
        grafico.setBounds(450,150,400,300);
        panel.add(grafico);
        grafico.setVisible(false);

        
        eventos(conjA,conjB,conjC,conjD,conjU,manual,auto,ejecutar,oper);
    }
    
    public String a="A U B",b="A U C",c="A U D",d="B U C",e = "B U D",f = "C U D",g2 = "A ∩ B",g="A ∩ C",h="A ∩ D",i="B ∩ C",j="B ∩ D",k="C ∩ D",l="A - B",m="A - C",n="A - D",o="B - A",p="B - C",q="B - D",r="C - A",r1="C - B",r2="C - D",s="D - A",t="D - B",u="D - C",v="A*",w="B*",x="C*",y="D*",z="A ∩ B ∩ C ∩ D",z1="Todos con A",z2="Todos con B",z3="Todos con C",z4="Todos con D";
    public JButton eliminarA = new JButton("-"),eliminarB= new JButton("-"),eliminarC= new JButton("-"),eliminarD= new JButton("-"),eliminarU= new JButton("-");
    public JLabel respuesta = new JLabel("--------"),seleccion = new JLabel("Respuesta"),grafico = new JLabel(new ImageIcon("union.png"));
    
    
    public void eventos(JTextField a,JTextField b,JTextField c, JTextField d,JTextField u,JButton man,JButton auto,JButton ejecutar,JComboBox caja){
        
        Random ran = new Random();
        ActionListener controlauto = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                man.setEnabled(true);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                u.setEnabled(false);
                
                int randomA = ran.nextInt(10) + 1;
                int randomB = ran.nextInt(10) + 1;
                int randomC = ran.nextInt(10) + 1;
                int randomD = ran.nextInt(10) + 1;
                
                int listaA[] = new int[randomA];
                
                for (int contA = 0; contA < randomA; contA++) {
                    listaA[contA] = ran.nextInt(20) + 1;
                }
                a.setText(String.join(",", Arrays.toString(listaA)));
                
                int listaB[] = new int[randomB];
                
                for (int contB = 0; contB < randomB; contB++) {
                    listaB[contB] = ran.nextInt(20) + 1;
                }
                b.setText(String.join(",", Arrays.toString(listaB)));
                
                int listaC[] = new int[randomC];
                
                for (int contC = 0; contC < randomC; contC++) {
                    listaC[contC] = ran.nextInt(20) + 1;
                }
                c.setText(String.join(",", Arrays.toString(listaC)));
                
                int listaD[] = new int[randomD];
                
                for (int contD = 0; contD < randomD; contD++) {
                    listaD[contD] = ran.nextInt(20) + 1;
                }
                d.setText(String.join(",", Arrays.toString(listaD)));
                
                TreeSet<Integer> universo = new TreeSet<>();

                for (int[] arr : new int[][]{listaA, listaB,listaC,listaD}) {
                    for (int i : arr) {
                        universo.add(i);
                    }
                }

                u.setText(String.join(",", universo.toString()));
                
                
            }
        };
        auto.addActionListener(controlauto);
        
        ActionListener controlman = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                man.setEnabled(false);
                a.setEnabled(true);
                b.setEnabled(true);
                c.setEnabled(true);
                d.setEnabled(true);
                u.setEnabled(true);
                a.setText("");
                b.setText("");
                c.setText("");
                d.setText("");
                u.setText("");
                grafico.setVisible(false);
            }
        };
        man.addActionListener(controlman);
        
        KeyListener validacion = new KeyListener(){
            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
                if((Character.isDigit(e.getKeyChar()))){
                    if(e.getSource() == a && !a.getText().isEmpty()){
                        a.setText(a.getText() + ",");
                        if(a.getText().length() > 38){
                            a.setEnabled(false);
                            a.setText(a.getText().substring(0,a.getText().length() - 1));
                            eliminarA.setVisible(true);
                        }
                    }
                    if(e.getSource() == b && !b.getText().isEmpty()){
                        b.setText(b.getText() + ",");
                        if(b.getText().length() > 38){
                            b.setEnabled(false);
                            b.setText(b.getText().substring(0,b.getText().length() - 1));
                            eliminarB.setVisible(true);
                        }
                    }
                    if(e.getSource() == c && !c.getText().isEmpty()){
                        c.setText(c.getText() + ",");
                        if(c.getText().length() > 38){
                            c.setEnabled(false);
                            c.setText(c.getText().substring(0,c.getText().length() - 1));
                            eliminarC.setVisible(true);
                        }
                    }
                    if(e.getSource() == d && !d.getText().isEmpty()){
                        d.setText(d.getText() + ",");
                        if(d.getText().length() > 38){
                            d.setEnabled(false);
                            d.setText(d.getText().substring(0,d.getText().length() - 1));
                            eliminarD.setVisible(true);
                        }
                    }
                    if(e.getSource() == u && !u.getText().isEmpty()){
                        u.setText(u.getText() + ",");
                        if(u.getText().length() > 38){
                            u.setEnabled(false);
                            u.setText(u.getText().substring(0,u.getText().length() - 1));
                            eliminarU.setVisible(true);
                        }
                    }
                }
            }
            public void keyReleased(KeyEvent e) {
                if(!(Character.isDigit(e.getKeyChar()))){
                    if(e.getSource() == a){
                        a.setText(a.getText().substring(0,a.getText().length() - 1));
                    }
                    if(e.getSource() == b){
                        b.setText(b.getText().substring(0,b.getText().length() - 1));
                    }
                    if(e.getSource() == c){
                        c.setText(c.getText().substring(0,c.getText().length() - 1));
                    }
                    if(e.getSource() == d){
                        d.setText(d.getText().substring(0,d.getText().length() - 1));
                    }
                    if(e.getSource() == u){
                        u.setText(u.getText().substring(0,u.getText().length() - 1));
                    }                        
                }
            }
        };
        a.addKeyListener(validacion);
        b.addKeyListener(validacion);
        c.addKeyListener(validacion);
        d.addKeyListener(validacion);
        u.addKeyListener(validacion);
        
        ActionListener controlEliminarA = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    eliminarA.setVisible(false);
                    a.setText("");
                    a.setEnabled(true);
            }
        };
        eliminarA.addActionListener(controlEliminarA);
        
        ActionListener controlEliminarB = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    eliminarB.setVisible(false);
                    b.setText("");
                    b.setEnabled(true);
            }
        };
        eliminarB.addActionListener(controlEliminarB);
        
        ActionListener controlEliminarC = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    eliminarC.setVisible(false);
                    c.setText("");
                    c.setEnabled(true);
            }
        };
        eliminarC.addActionListener(controlEliminarC);
        
        ActionListener controlEliminarD = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    eliminarD.setVisible(false);
                    d.setText("");
                    d.setEnabled(true);
            }
        };
        eliminarD.addActionListener(controlEliminarD);
        
        ActionListener controlEliminarU = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    eliminarU.setVisible(false);
                    u.setText("");
                    u.setEnabled(true);
            }
        };
        eliminarU.addActionListener(controlEliminarU);

        
        
        ActionListener controlEje = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!a.getText().equals("") && !b.getText().equals("") && !c.getText().equals("") && !d.getText().equals("") && !u.getText().equals("")){
                    seleccion.setText(caja.getSelectedItem().toString());
                    
                    int elementA[] = cambioEntero(a.getText());
                    int elementB[] = cambioEntero(b.getText());
                    int elementC[] = cambioEntero(c.getText());
                    int elementD[] = cambioEntero(d.getText());
                    int elementU[] = cambioEntero(u.getText());
                    
                    if(caja.getSelectedItem().toString().length() > 2){
                    if(caja.getSelectedItem().toString().substring(0,1).equals("A") && caja.getSelectedItem().toString().length() < 6){
                        if(caja.getSelectedItem().toString().substring(2,3).equals("U")){
                            if(caja.getSelectedItem().toString().substring(4,5).equals("B")){
                                union(elementA,elementB);
                            }  
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("C")){
                                union(elementA,elementC);
                            }
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("D")){
                                union(elementA,elementD);
                            }
                        }       
                        else if(caja.getSelectedItem().toString().substring(2,3).equals("∩")){
                            if(caja.getSelectedItem().toString().substring(4,5).equals("B")){
                                interseccion(elementA,elementB);
                            }                             
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("C")){
                                interseccion(elementA,elementC);
                            }
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("D")){
                                interseccion(elementA,elementD);
                            }
                        }
                        else if(caja.getSelectedItem().toString().substring(2,3).equals("-")){
                            if(caja.getSelectedItem().toString().substring(4,5).equals("B")){
                                diferencia(elementA,elementB);
                            }                             
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("C")){
                                diferencia(elementA,elementC);
                            }
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("D")){
                                diferencia(elementA,elementD);
                            }                            
                        }
                    }
                    else if(caja.getSelectedItem().toString().substring(0,1).equals("B")){
                        if(caja.getSelectedItem().toString().substring(2,3).equals("U")){
                            if(caja.getSelectedItem().toString().substring(4,5).equals("C")){
                                union(elementB,elementC);
                            }
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("D")){
                                union(elementB,elementC);
                            }
                        }
                        else if(caja.getSelectedItem().toString().substring(2,3).equals("∩")){
                            if(caja.getSelectedItem().toString().substring(4,5).equals("C")){
                                interseccion(elementB,elementC);
                            }
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("D")){
                                interseccion(elementB,elementD);
                            }
                        }
                        else if(caja.getSelectedItem().toString().substring(2,3).equals("-")){
                            if(caja.getSelectedItem().toString().substring(4,5).equals("C")){
                                diferencia(elementB,elementC);
                            }
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("A")){
                                diferencia(elementB,elementA);
                            }
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("D")){
                                diferencia(elementB,elementD);
                            }                            
                        }
                    }
                    else if(caja.getSelectedItem().toString().substring(0,1).equals("C")){
                        if(caja.getSelectedItem().toString().substring(2,3).equals("U")){
                            union(elementC,elementD);
                        }
                        else if(caja.getSelectedItem().toString().substring(2,3).equals("∩")){
                            interseccion(elementC,elementD);
                        }
                        else if(caja.getSelectedItem().toString().substring(2,3).equals("-")){
                            if(caja.getSelectedItem().toString().substring(4,5).equals("A")){
                                diferencia(elementC,elementA);
                            }
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("B")){
                                diferencia(elementC,elementB);
                            }
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("D")){
                                diferencia(elementC,elementD);
                            }  
                        }
                    }
                    else if(caja.getSelectedItem().toString().substring(0,1).equals("D")){
                        if(caja.getSelectedItem().toString().substring(2,3).equals("-")){
                            if(caja.getSelectedItem().toString().substring(4,5).equals("A")){
                                diferencia(elementD,elementA);
                            }
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("B")){
                                diferencia(elementD,elementB);
                            }
                            else if(caja.getSelectedItem().toString().substring(4,5).equals("C")){
                                diferencia(elementD,elementC);
                            }  
                        }  
                    }
                    else{
                        interTotal(elementA,elementB,elementC,elementD);
                    }
                } 
                else{
                    if(caja.getSelectedItem().toString().substring(0,1).equals("A")){
                        complemento(elementU,elementA);
                    }
                    else if(caja.getSelectedItem().toString().substring(0,1).equals("B")){
                        complemento(elementU,elementB);
                    }
                    else if(caja.getSelectedItem().toString().substring(0,1).equals("C")){
                        complemento(elementU,elementC);
                    }
                    else if(caja.getSelectedItem().toString().substring(0,1).equals("D")){
                        complemento(elementU,elementD);
                    }
                }
                }
                
            }
        };
        ejecutar.addActionListener(controlEje);
    }
    
    public static int[] cambioEntero(String elemento) {
        String tempElement[];
        if(elemento.substring(0,1).equals("[")){
            tempElement = elemento.replace("[", "").replace("]", "").split(", ");
        }
        else{
            tempElement = elemento.split(",");
        }
        
        int elementosNew[] = new int[tempElement.length];
        for (int i = 0; i < tempElement.length; i++) {
            elementosNew[i] = Integer.parseInt(tempElement[i]);
        }
        return elementosNew;
    }
    
    public void union(int[] a,int[] b){
        TreeSet<Integer> conjuntoA = new TreeSet<>();
        TreeSet<Integer> conjuntoB = new TreeSet<>();
        for (int i = 0; i < a.length; i++) {
            conjuntoA.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            conjuntoB.add(b[i]);
        }
        
        TreeSet<Integer> union = new TreeSet<>();
        union.addAll(conjuntoA);
        union.addAll(conjuntoB);
        respuesta.setText(union.toString());
        
        grafico.setVisible(true);
        grafico.setIcon(new ImageIcon("union.png"));

    }
    
    public void interseccion(int[] a, int[] b){
        TreeSet<Integer> conjuntoA = new TreeSet<>();
        TreeSet<Integer> conjuntoB = new TreeSet<>();
        for (int i = 0; i < a.length; i++) {
            conjuntoA.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            conjuntoB.add(b[i]);
        }
        TreeSet<Integer> interseccion = new TreeSet<>();
        interseccion.addAll(conjuntoA);
        interseccion.retainAll(conjuntoB);
        respuesta.setText(interseccion.toString());
        
        grafico.setVisible(true);
        grafico.setIcon(new ImageIcon("interseccion.png"));

    }
    
    public void diferencia(int[] a,int[] b){
        TreeSet<Integer> conjuntoA = new TreeSet<>();
        TreeSet<Integer> conjuntoB = new TreeSet<>();
        for (int i = 0; i < a.length; i++) {
            conjuntoA.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            conjuntoB.add(b[i]);
        }    
        conjuntoA.removeAll(conjuntoB);
        respuesta.setText(conjuntoA.toString());
        
        grafico.setVisible(true);
        grafico.setIcon(new ImageIcon("diferencia.png"));
    }
    
    public void complemento(int[] u, int[]a){
        TreeSet<Integer> conjuntoA = new TreeSet<>();
        TreeSet<Integer> conjuntoU = new TreeSet<>();
        for (int i = 0; i < a.length; i++) {
            conjuntoA.add(a[i]);
        }
        for (int i = 0; i < u.length; i++) {
            conjuntoU.add(u[i]);
        }    
        conjuntoU.removeAll(conjuntoA);
        respuesta.setText(conjuntoU.toString()); 
        
        grafico.setVisible(true);
        grafico.setIcon(new ImageIcon("complemento.png"));
    }
    
    public void interTotal(int[] a, int[] b, int[] c, int[] d) {
        TreeSet<Integer> conjuntoA = new TreeSet<>();
        TreeSet<Integer> conjuntoB = new TreeSet<>();
        TreeSet<Integer> conjuntoC = new TreeSet<>();
        TreeSet<Integer> conjuntoD = new TreeSet<>();
        for (int i = 0; i < a.length; i++) {
            conjuntoA.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            conjuntoB.add(b[i]);
        }
        for (int i = 0; i < c.length; i++) {
            conjuntoC.add(c[i]);
        }
        for (int i = 0; i < d.length; i++) {
            conjuntoD.add(d[i]);
        }

        TreeSet<Integer> intersection = new TreeSet<>();
        intersection.addAll(conjuntoA);
        intersection.retainAll(conjuntoB);
        intersection.retainAll(conjuntoC);
        intersection.retainAll(conjuntoD);

        respuesta.setText(intersection.toString());
        
        grafico.setVisible(true);
        grafico.setIcon(new ImageIcon("interTotal.png"));
}
    
    
    public static void main(String[] args) {
        conjuntos windows = new conjuntos();
        windows.setVisible(true);
    }
}
