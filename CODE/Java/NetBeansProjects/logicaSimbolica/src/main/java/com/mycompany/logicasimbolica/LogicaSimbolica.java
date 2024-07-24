
package com.mycompany.logicasimbolica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;
import javax.swing.*;

public class LogicaSimbolica extends JFrame{
    
    public LogicaSimbolica(){
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Conjuntos");
        setLocationRelativeTo(null);
        setResizable(false);  
        visual();
    }
    
    protected String a="A U B",b="A U C",c="A U D",d="B U C",e="B U D",f="C U D",g="A - B",h="A - C",i="A - D",j="B - A",k="B - C";
    protected String l="B - D",m="C - A",n="C - B",o="C - D",p="D - A",q="D - B",r="D - C",s="A ∩ B",t="A ∩ C",u="A ∩ D",v="B ∩ C";
    protected String w="B ∩ D",x="C ∩ D",y="A*",z="B*",a1="C*",a2="D*",a7="A ∩ B ∩ C ∩ D";
    protected int validar = 0;
    protected Random rnd = new Random();
    protected ArrayList<String> conjRelleno = new ArrayList<>(),conjA = new ArrayList<>(),conjB = new ArrayList<>(),conjC = new ArrayList<>(),conjD = new ArrayList<>(),conjU = new ArrayList<>();
    protected objetos manual,auto,txtA,txtB,txtC,txtD,txtU,insertar,ejecutar,borrar,respuesta,operacion;
    protected JLabel grafico = new JLabel(new ImageIcon("union.png"));
    protected JComboBox opciones = new JComboBox(new String[] {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a1,a2,a7});
    
    protected void visual(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.add(panel);
        
        objetos labelCon = new objetos("Conjuntos",60,50,150,20);
        labelCon.setLabel(panel);
        
        manual = new objetos("Manual",50,80,100,40,false);
        manual.setButton(panel);
        
        auto = new objetos("Automatico",150,80,100,40,true);
        auto.setButton(panel);        
        
        borrar = new objetos("Borrar",250,80,70,40,true);
        borrar.setButton(panel);
        
        grafico.setBounds(450,150,400,300);
        panel.add(grafico);
        grafico.setVisible(false);
        
        objetos intrucciones = new objetos("Intrucciones: En cada elemento presionar INSERTAR",60,120,350,20);
        intrucciones.label.setFont(new Font("",Font.PLAIN,10));
        intrucciones.setLabel(panel);
        
        objetos labelA = new objetos("A",50,150,30,30);
        labelA.setLabel(panel);
        
        objetos labelB = new objetos("B",50,200,30,30);
        labelB.setLabel(panel);        
        
        objetos labelC = new objetos("C",50,250,30,30);
        labelC.setLabel(panel);

        objetos labelD = new objetos("D",50,300,30,30);
        labelD.setLabel(panel);

        objetos labelU = new objetos("U",50,350,30,30);
        labelU.setLabel(panel);        
        
        respuesta = new objetos("",400,50,100,20);
        respuesta.setLabel(panel);
        
        operacion = new objetos("",400,100,300,20);
        operacion.setLabel(panel);
        
        txtA = new objetos(70,150,250,30);
        txtA.txt.setFont(new Font("calibri",Font.ITALIC,10));
        txtA.txt.setEditable(true);
        txtA.setTxt(panel);
        
        txtB = new objetos(70,200,250,30);
        txtB.txt.setFont(new Font("calibri",Font.ITALIC,10));
        txtB.txt.setEditable(true);
        txtB.setTxt(panel);
        
        txtC = new objetos(70,250,250,30);
        txtC.txt.setFont(new Font("calibri",Font.ITALIC,10));
        txtC.txt.setEditable(true);
        txtC.setTxt(panel);
       
        txtD = new objetos(70,300,250,30);
        txtD.txt.setFont(new Font("calibri",Font.ITALIC,10));
        txtD.txt.setEditable(true);
        txtD.setTxt(panel);
        
        txtU = new objetos(70,350,250,30);
        txtU.txt.setFont(new Font("calibri",Font.ITALIC,10));
        txtU.txt.setEditable(true);
        txtU.setTxt(panel);
        
        insertar = new objetos("Insertar (Seleccione el conjunto) ",50,400,270,40,true);
        insertar.setButton(panel);
        
        ejecutar = new objetos("Ejecucion",50,450,100,40,true);
        ejecutar.setButton(panel);
        
        opciones.setBounds(150,450,175,40);
        panel.add(opciones);
        
        eventos();
    }
    
    public void eventos(){
        ActionListener autoRelleno = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                insertar.btn.setEnabled(false);
                manual.btn.setEnabled(true);
                conjA.clear();conjB.clear();conjC.clear();conjD.clear();conjU.clear();
                txtA.txt.setEditable(false);txtB.txt.setEditable(false);txtC.txt.setEditable(false);txtD.txt.setEditable(false);txtU.txt.setEditable(false);
                rellenar();
            }
        };
        auto.btn.addActionListener(autoRelleno);
        
        ActionListener manualbtn = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                manual.btn.setEnabled(false);
                insertar.btn.setEnabled(true);
                txtA.txt.setText(""); txtB.txt.setText(""); txtC.txt.setText(""); txtD.txt.setText(""); txtU.txt.setText("");
                txtA.txt.setEditable(true);txtB.txt.setEditable(true);txtC.txt.setEditable(true);txtD.txt.setEditable(true);txtU.txt.setEditable(true);
            }
        };
        manual.btn.addActionListener(manualbtn);
        
        ActionListener vaciar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                txtA.txt.setText(""); txtB.txt.setText(""); txtC.txt.setText(""); txtD.txt.setText(""); txtU.txt.setText("");
                conjA.clear();conjB.clear();conjC.clear();conjD.clear();conjU.clear();
                respuesta.label.setText(""); operacion.label.setText(""); grafico.setIcon(new ImageIcon(""));
            }
        };
        borrar.btn.addActionListener(vaciar);
        
        
        ActionListener insert = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if((txtA.txt.getText()!= null) && validar == 1){
                    llenar(txtA.txt); 
                    txtA.txt.setText(conjA.toString());
                }
                else if(txtB.txt.getText()!=null &&  validar == 2){
                    llenar(txtB.txt);
                    txtB.txt.setText(conjB.toString());
                }
                else if(txtC.txt.getText()!=null &&  validar == 3){
                    llenar(txtC.txt);
                    txtC.txt.setText(conjC.toString());
                }
                else if(txtD.txt.getText()!=null &&  validar == 4){
                    llenar(txtD.txt);
                    txtD.txt.setText(conjD.toString());
                }
                else if(txtU.txt.getText()!=null &&  validar == 5){
                    llenar(txtU.txt);
                    txtU.txt.setText(conjU.toString());
                }
            }
        };
        insertar.btn.addActionListener(insert);
        
        FocusListener seleccion = new FocusListener(){
            public void focusGained(FocusEvent e) {
                if(e.getSource().equals(txtA.txt)) {
                    validar = 1; 
                    txtA.txt.setText(null);
                }
                else if (e.getSource().equals(txtB.txt)) {
                    validar = 2; 
                    txtB.txt.setText(null);
                }
                else if (e.getSource().equals(txtC.txt)) {
                    validar = 3; 
                    txtC.txt.setText(null);
                }
                else if (e.getSource().equals(txtD.txt)) {
                    validar = 4; 
                    txtD.txt.setText(null);
                }
                else if (e.getSource().equals(txtU.txt)) {
                    validar = 5; 
                    txtU.txt.setText(null);
                }
            }
            public void focusLost(FocusEvent e) {
            }
        };
        txtA.txt.addFocusListener(seleccion);txtB.txt.addFocusListener(seleccion);txtC.txt.addFocusListener(seleccion);txtD.txt.addFocusListener(seleccion);txtU.txt.addFocusListener(seleccion);
        
        ActionListener procesos = new ActionListener(){
            public void actionPerformed(ActionEvent evnt) {
                if((txtA.txt.getText() != null)&&(txtB.txt.getText() != null)&&(txtC.txt.getText() != null)&&(txtD.txt.getText() != null)&&(txtU.txt.getText() != null)){
                    conjA = mover(txtA.txt.getText());
                    conjB = mover(txtB.txt.getText());
                    conjC = mover(txtC.txt.getText());
                    conjD = mover(txtD.txt.getText());
                    conjU = mover(txtU.txt.getText());
                    if(opciones.getSelectedItem().equals(a)) {
                        union(conjA,conjB);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    }
                    else if(opciones.getSelectedItem().equals(b)){
                        union(conjA,conjC);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(c)){
                        union(conjA,conjD);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(d)){
                        union(conjB,conjC);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    }                     
                    else if(opciones.getSelectedItem().equals(e)){
                        union(conjB,conjD);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(f)){
                        union(conjC,conjD);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    
                    else if(opciones.getSelectedItem().equals(g)){
                        diferencia(conjA,conjB);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    
                    else if(opciones.getSelectedItem().equals(h)){
                        diferencia(conjA,conjC);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    }                       
                    else if(opciones.getSelectedItem().equals(i)){
                        diferencia(conjA,conjD);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(j)){
                        diferencia(conjB,conjA);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(k)){
                        diferencia(conjB,conjC);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    }  
                    else if(opciones.getSelectedItem().equals(l)){
                        diferencia(conjB,conjD);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(m)){
                        diferencia(conjC,conjA);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    }                     
                    else if(opciones.getSelectedItem().equals(n)){
                        diferencia(conjC,conjB);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(o)){
                        diferencia(conjC,conjD);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(p)){
                        diferencia(conjD,conjA);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    }                       
                    else if(opciones.getSelectedItem().equals(q)){
                        diferencia(conjD,conjB);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(r)){
                        diferencia(conjD,conjC);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(s)){
                        interseccion(conjA,conjB);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    }
                    else if(opciones.getSelectedItem().equals(t)){
                        interseccion(conjA,conjC);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(u)){
                        interseccion(conjA,conjD);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    }                       
                    else if(opciones.getSelectedItem().equals(v)){
                        interseccion(conjB,conjC);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(w)){
                        interseccion(conjB,conjD);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(x)){
                        interseccion(conjC,conjD);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    }  
                    else if(opciones.getSelectedItem().equals(y)){
                        complemento(conjA,conjU);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(z)){
                        complemento(conjB,conjU);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    }                     
                    else if(opciones.getSelectedItem().equals(a1)){
                        complemento(conjC,conjU);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    else if(opciones.getSelectedItem().equals(a2)){
                        complemento(conjD,conjU);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    } 
                    
                    else if(opciones.getSelectedItem().equals(a7)){
                        interTotal(conjA,conjB,conjC,conjD);
                        respuesta.label.setText(opciones.getSelectedItem().toString());
                    }
                }
            }
        };
        ejecutar.btn.addActionListener(procesos);
    }
    
    
    
    public void rellenar(){
        TreeSet<Integer> universal = new TreeSet<>();
        for (int i = 0;i < 4;i++) {
            for (int j = 0; j < rnd.nextInt(10) + 1; j++) {
                int numRan = (rnd.nextInt(20) + 1);
                conjRelleno.add(Integer.toString(numRan));
                universal.add(numRan);
            }
            if(i==0) txtA.txt.setText(String.join(",", conjRelleno));
            else if(i==1) txtB.txt.setText(String.join(",", conjRelleno));
            else if(i==2) txtC.txt.setText(String.join(",", conjRelleno));
            else if(i==3) txtD.txt.setText(String.join(",", conjRelleno));
            conjRelleno.clear();
        }
        
        txtU.txt.setText(universal.toString());
    }
    
    public void llenar(JTextField elemento){
        if(validar == 1 && !(elemento.getText() == null)) {
            conjA.add(elemento.getText());
        }
        else if(validar == 2 && !(elemento.getText() == null)) {
            conjB.add(elemento.getText());
        }
        else if(validar == 3 && !(elemento.getText() == null)) {
            conjC.add(elemento.getText());
        }
        else if(validar == 4 && !(elemento.getText() == null)) {
            conjD.add(elemento.getText());
        }
        else if(validar == 5 && !(elemento.getText() == null)) {
            conjU.add(elemento.getText());
        }
    }
    
    public void union(ArrayList conj1,ArrayList conj2){
        TreeSet<Integer> conjuntoA = new TreeSet<>();
        TreeSet<Integer> conjuntoB = new TreeSet<>();
        
        conjuntoA.addAll(conj1);
        conjuntoB.addAll(conj2);
        
        TreeSet<Integer> union = new TreeSet<>();
        union.addAll(conjuntoA);
        union.addAll(conjuntoB);        
        
        operacion.label.setText(union.toString());
        
        grafico.setVisible(true);
        grafico.setIcon(new ImageIcon("union.png"));
    }
    
    public ArrayList mover(String elementos){
        ArrayList lista = new ArrayList();
        String cadena[] = elementos.replace("[", "").replace("]", "").replace(" ", "").split(",");
            
        for (int cont = 0; cont < cadena.length; cont++) {
            lista.add(cadena[cont]);
        }
        
        return lista;
    }
    
    public void interseccion(ArrayList conjA, ArrayList conjB){
        TreeSet<Integer> conjuntoA = new TreeSet<>();
        TreeSet<Integer> conjuntoB = new TreeSet<>();
        conjuntoA.addAll(conjA);
        conjuntoB.addAll(conjB);
        
        TreeSet<Integer> interseccion = new TreeSet<>();
        interseccion.addAll(conjuntoA);
        interseccion.retainAll(conjuntoB);
        operacion.label.setText(interseccion.toString());
        
        grafico.setVisible(true);
        grafico.setIcon(new ImageIcon("interseccion.png"));
        
    }
    
    public void diferencia(ArrayList conjA,ArrayList conjB){
        TreeSet<Integer> conjuntoA = new TreeSet<>();
        TreeSet<Integer> conjuntoB = new TreeSet<>();
        conjuntoA.addAll(conjA);
        
        
        conjuntoA.removeAll(conjuntoB);
        operacion.label.setText(conjuntoA.toString());
        grafico.setVisible(true);
        grafico.setIcon(new ImageIcon("diferencia.png"));

    
    }
    
    public void complemento(ArrayList conjA, ArrayList conjU){
        TreeSet<Integer> conjuntoA = new TreeSet<>();
        TreeSet<Integer> conjuntoU = new TreeSet<>();
        
        conjuntoA.addAll(conjA) ;
        conjuntoU.addAll(conjU);
        
        conjuntoU.removeAll(conjuntoA);
        operacion.label.setText(conjuntoU.toString()); 
        grafico.setVisible(true);
        
        grafico.setIcon(new ImageIcon("complemento.png"));

    }
     
    public void interTotal(ArrayList conjA,ArrayList conjB, ArrayList conjC, ArrayList conjD) {
        TreeSet<Integer> conjuntoA = new TreeSet<>();
        TreeSet<Integer> conjuntoB = new TreeSet<>();
        TreeSet<Integer> conjuntoC = new TreeSet<>();
        TreeSet<Integer> conjuntoD = new TreeSet<>();
        conjuntoA.addAll(conjA);
        conjuntoB.addAll(conjB);
        conjuntoC.addAll(conjC);
        conjuntoD.addAll(conjD);
        
        TreeSet<Integer> intersection = new TreeSet<>();
        
        intersection.addAll(conjuntoA);
        intersection.retainAll(conjuntoB);
        intersection.retainAll(conjuntoC);
        intersection.retainAll(conjuntoD);

        operacion.label.setText(intersection.toString());
        
        grafico.setVisible(true);
        grafico.setIcon(new ImageIcon("interTotal.png"));
        
}
    
    public static void main(String[] args) {
        LogicaSimbolica ventana = new LogicaSimbolica();
        ventana.setVisible(true);
    }
}
