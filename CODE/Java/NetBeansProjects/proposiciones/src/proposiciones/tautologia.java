
package proposiciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class tautologia extends JFrame{
    
    private JButton borrar,ope,conj,dis,neg,cond,bi,pB,qB,rB,sB,parenA,parenC;
    private JTextField texto;
    private JLabel p,q;
    private int valid = 0;   
    private JTable tabla;
    private DefaultTableModel model;
    
    public tautologia(){
        setSize(800,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Tautologia");
        setLocationRelativeTo(null);
        init();     
    }
    
    private void init(){
        JPanel panel = new JPanel();
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.add(panel);
        
        JLabel logica = new JLabel("Tablas de la Verdad");
        logica.setFont(new Font("",Font.BOLD,20));
        logica.setBounds(50,50,350,30);
        panel.add(logica);
        
        
        texto = new JTextField();
        texto.setBounds(50,150,467,40);
        texto.setEditable(false);
        panel.add(texto);

        
        borrar = new JButton("Borrar");
        borrar.setBounds(517,150,117,40);
        panel.add(borrar);
        
        ope = new JButton("Operar");
        ope.setBounds(634,150,117,40);
        panel.add(ope);
        
        conj = new JButton("Conjuncion");
        conj.setBounds(50,190,117,40);
        panel.add(conj);
        conj.setEnabled(false);
        
        dis = new JButton("Disyuncion");
        dis.setBounds(167,190,117,40);
        panel.add(dis);
        dis.setEnabled(false);
        
        cond = new JButton("Condicional");
        cond.setBounds(50,230,117,40);
        panel.add(cond);
        cond.setEnabled(false);
        
        bi = new JButton("Bicondicional");
        bi.setBounds(167,230,117,40);
        panel.add(bi);
        bi.setEnabled(false);
        
        neg = new JButton("Negacion");
        neg.setBounds(401,230,117,40);
        panel.add(neg);
        
        pB = new JButton("P");
        pB.setBounds(401,190,59,40);
        panel.add(pB);
        
        qB = new JButton("Q");
        qB.setBounds(460,190,59,40);
        panel.add(qB);
        
        rB = new JButton("R");
        rB.setBounds(342,190,59,40);
        panel.add(rB);
        
        sB = new JButton("S");
        sB.setBounds(342,230,59,40);
        panel.add(sB);
        
        p = new JLabel();
        p.setBounds(100,350,400,40);
        panel.add(p);
        
        q = new JLabel();
        q.setBounds(100,400,400,40);
        panel.add(q);
        
        parenA = new JButton("(");
        parenA.setBounds(284,190,29,80);
        panel.add(parenA);
        
        parenC = new JButton(")");
        parenC.setBounds(313,190,29,80);
        panel.add(parenC);
        parenC.setEnabled(false);
        
        
        model = new DefaultTableModel();
        
        tabla = new JTable(model);
        
        JScrollPane deslizar = new JScrollPane(tabla);
        deslizar.setBounds(50,300,700,220);
        
        panel.add(deslizar);
        
        tabla.setDefaultEditor(Object.class, null);
        
        eventos();
    }
    
    private void eventos(){
        
        ActionListener prepo = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == pB){
                    texto.setText(texto.getText() + "P");

                }
                else if(e.getSource() == qB){
                    texto.setText(texto.getText() + "Q");
                }
                else if(e.getSource() == rB){
                    texto.setText(texto.getText() + "R");
                }
                else if(e.getSource() == sB){
                    texto.setText(texto.getText() + "S");
                }
                valid += 1;
                pB.setEnabled(false);qB.setEnabled(false);rB.setEnabled(false);sB.setEnabled(false);
                neg.setEnabled(false);conj.setEnabled(true);dis.setEnabled(true);cond.setEnabled(true);bi.setEnabled(true);   
            }
        };
        pB.addActionListener(prepo);qB.addActionListener(prepo);rB.addActionListener(prepo);sB.addActionListener(prepo);
        
        ActionListener negar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + "~");
                neg.setEnabled(false);
            }
        };
        neg.addActionListener(negar);
        
        ActionListener conec = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == conj){
                    texto.setText(texto.getText() + "v");
                }
                else if(e.getSource() == dis){
                    texto.setText(texto.getText() + "^");
                }
                else if(e.getSource() == cond){
                    texto.setText(texto.getText() + ">");
                }
                else if(e.getSource() == bi){
                    texto.setText(texto.getText() + "↔");
                }
                
                pB.setEnabled(true);qB.setEnabled(true);rB.setEnabled(true);sB.setEnabled(true);
                neg.setEnabled(true);conj.setEnabled(false);dis.setEnabled(false);cond.setEnabled(false);bi.setEnabled(false);                   
            }
        };
        conj.addActionListener(conec);dis.addActionListener(conec);cond.addActionListener(conec);bi.addActionListener(conec);
        
        ActionListener eliminar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                texto.setText("");pB.setEnabled(true);qB.setEnabled(true);
                rB.setEnabled(true);sB.setEnabled(true);
                neg.setEnabled(true);conj.setEnabled(false);dis.setEnabled(false);cond.setEnabled(false);bi.setEnabled(false);  
                valid = 0;
                model = new DefaultTableModel();
                tabla.setModel(model);
                ope.setEnabled(true);  
            }
        };
        borrar.addActionListener(eliminar);     
        
        ActionListener parentesis = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String ltr = "";
                if(texto.getText().length() == 0){
                    ltr = "";
                }
                else{
                    ltr = texto.getText().split("")[texto.getText().length() - 1];
                }
                if(e.getSource() == parenA && !(ltr.equals("P") || ltr.equals("Q")|| ltr.equals("R")|| ltr.equals("S"))){
                    texto.setText(texto.getText() + "(");
                    parenA.setEnabled(false);
                    parenC.setEnabled(true);
                }
                else if(e.getSource() == parenC && !(ltr.equals("(") || ltr.equals("^") || ltr.equals("v")|| ltr.equals(">")|| ltr.equals("↔"))){
                    texto.setText(texto.getText() + ")");
                    parenA.setEnabled(true);
                    parenC.setEnabled(false);                    
                }
            }
        };
        parenA.addActionListener(parentesis);parenC.addActionListener(parentesis);
        
        ActionListener accionar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!texto.getText().isBlank()){
                    String ltr = texto.getText().split("")[texto.getText().length() - 1];
                    if(!(texto.getText().equals("")) && !(ltr.equals("(") || ltr.equals("^") || ltr.equals("v")|| ltr.equals(">")|| ltr.equals("↔")|| ltr.equals("~"))){
                        ope.setEnabled(false);
                        algoritmo();
                    }
                }
                

            }
        };
        ope.addActionListener(accionar);
    }

    private void algoritmo(){
        char cadena[] = texto.getText().toCharArray();
        int cantidad = 0;
        ArrayList<String> letras = new ArrayList<String>();
        
        int c = 0;
        for(char letra: cadena){
            if(letra == 'P' && !letras.contains(Character.toString(letra))){
                model.addColumn(letra);
                letras.add(Character.toString(letra));
                cantidad += 1;
            }         
            if(letra == 'Q' && !letras.contains(Character.toString(letra))){
                model.addColumn(letra);
                letras.add(Character.toString(letra));
                cantidad += 1;
            }
            if(letra == 'R' && !letras.contains(Character.toString(letra))){
                model.addColumn(letra);
                letras.add(Character.toString(letra));
                cantidad += 1;
            }
            if(letra == 'S' && !letras.contains(Character.toString(letra))){
                model.addColumn(letra);
                letras.add(Character.toString(letra));
                cantidad += 1;
            }
            if(letra == '~' && !letras.contains(Character.toString(letra) + cadena[cantidad + 1])){
                model.addColumn(String.valueOf(letra) + cadena[c + 1]);
                letras.add(String.valueOf(letra) + cadena[c + 1]);
                cantidad += 1; 
            }
            c += 1;
        }
        model.addColumn(texto.getText());
        
        int n = cantidad;
        
        boolean valor[] = {true,false};
        boolean ahoravalor[] = new boolean[n];
        bucle(valor,n,0,ahoravalor);
        
        for (int i = 0; i < model.getColumnCount() - 1; i++) {
            String name = model.getColumnName(i);
            for (int j = 0; j < model.getColumnCount(); j++) {
                if(("~"+name).equals(model.getColumnName(j))){
                    for (int k = 0; k < model.getRowCount(); k++) {
                        model.setValueAt(!Boolean.valueOf(model.getValueAt(k, i).toString()), k, j);
                    }
                }
            }
        }
        
        String result[] = texto.getText().split("");
        
        n=0;
        for(String letra: result){
            if(letra.equals("~")){
                result[n + 1] = letra + result[n + 1];
                result[n] = "";
                
            }
            n += 1;
        }
        ArrayList<Object> r = new ArrayList<Object>();
        ArrayList<Boolean> todo = new ArrayList<Boolean>();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount() - 1; j++) {
                for (int k = 0; k < result.length; k++) {
                    if(!result[k].isBlank()){
                        if(model.getColumnName(j).equals(result[k])){
                            r.add(Boolean.valueOf(model.getValueAt(i, j).toString()));
                        }
                    
                        if(!r.isEmpty()){
                            if((result[k].equals("^") || result[k].equals("v") || result[k].equals(">") || result[k].equals("↔")) && !r.getLast().equals(result[k])){
                                r.add(result[k]);
                            }
                        }
                    }
                }
            }
            if(r.get(r.size() - 1).equals("^") || r.get(r.size() - 1).equals("v") || r.get(r.size() - 1).equals(">") || r.get(r.size() - 1).equals("↔")){
                r.remove(r.size()- 1);
            }
            for (int j = 0; j < r.size() - 1; j++) {
                if(r.get(j).equals("^")){
                    r.set(j + 1, Boolean.valueOf(r.get(j - 1).toString()) && Boolean.valueOf(r.get(j + 1).toString()));
                }
                else if(r.get(j).equals("v")){
                    r.set(j + 1, Boolean.valueOf(r.get(j - 1).toString()) || Boolean.valueOf(r.get(j + 1).toString()));
                }
                else if(r.get(j).equals(">")){
                    r.set(j + 1, Boolean.valueOf(r.get(j + 1).toString()));
                }
                else if(r.get(j).equals("↔")){
                    r.set(j + 1, Boolean.valueOf(r.get(j - 1).toString()) == Boolean.valueOf(r.get(j + 1).toString()));
                }
            }
            
            if(!r.isEmpty()){
                todo.add(Boolean.valueOf(r.getLast().toString()));
                r.clear();
            }
            
        }
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(todo.get(i), i, model.getColumnCount() - 1);
        }
        if(todo.stream().allMatch(element -> element == true)){
            JOptionPane.showMessageDialog(null, "Tautologia");
        }
        else if(todo.stream().allMatch(element -> element == false)){
            JOptionPane.showMessageDialog(null, "Contradiccion");
        }
        else{
            JOptionPane.showMessageDialog(null, "Contingencia");
        }
    }
    
    
    
    private void bucle(boolean values[],int n,int cudep,boolean[] ahoravalor){
        ArrayList valores = new ArrayList();
        if(cudep == n){
            for(boolean value:ahoravalor){
                valores.add(value);
            }
            model.addRow(valores.toArray());
            valores.clear();
        }
        else{
            for(boolean value : values){
                ahoravalor[cudep] = value;
                bucle(values,n,cudep + 1,ahoravalor);
            }
        }
    }
    
    public static void main(String[] args) {
        tautologia t = new tautologia();
        t.setVisible(true);
    }
}
