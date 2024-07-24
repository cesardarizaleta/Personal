
package proposiciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class molec extends JFrame{
    private JButton ato,mol,borrar,ope,conj,dis,neg,cond,bi,pB,qB;
    private JTextField texto;
    private JLabel p,q;
    private int valid = 0;
    
    public molec(){
        setSize(800,600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Logica Proposicional - Molecular");
        setLocationRelativeTo(null);
        cerrar();
        init();

    }

    private void init(){
        JPanel panel = new JPanel();
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.add(panel);
        
        JLabel logica = new JLabel("Logica Proposicional");
        logica.setFont(new Font("",Font.BOLD,20));
        logica.setBounds(50,50,300,30);
        panel.add(logica);
        
        ato = new JButton("Atomica");
        ato.setBounds(550,40,100,50);
        
        panel.add(ato);
        
        mol = new JButton("Molecular");
        mol.setBounds(650,40,100,50);
        mol.setEnabled(false);
        panel.add(mol);
        
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
        
        p = new JLabel();
        p.setBounds(100,350,400,40);
        panel.add(p);
        
        q = new JLabel();
        q.setBounds(100,400,400,40);
        panel.add(q);   
        
        
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
                valid += 1;
                pB.setEnabled(false);
                qB.setEnabled(false);
                neg.setEnabled(false);
                conj.setEnabled(true);
                dis.setEnabled(true);
                cond.setEnabled(true);
                bi.setEnabled(true);   
            }
        };
        pB.addActionListener(prepo);
        qB.addActionListener(prepo);
        
        
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
                
                pB.setEnabled(true);
                qB.setEnabled(true);
                neg.setEnabled(true);
                conj.setEnabled(false);
                dis.setEnabled(false);
                cond.setEnabled(false);
                bi.setEnabled(false);                   
            }
        };
        conj.addActionListener(conec);
        dis.addActionListener(conec);
        cond.addActionListener(conec);
        bi.addActionListener(conec);
        
        ActionListener eliminar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                texto.setText("");
                pB.setEnabled(true);
                qB.setEnabled(true);
                neg.setEnabled(true);
                conj.setEnabled(false);
                dis.setEnabled(false);
                cond.setEnabled(false);
                bi.setEnabled(false);  
                valid = 0;
            }
        };
        borrar.addActionListener(eliminar);
        
        ActionListener comenzar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                if(texto.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Formula vacia");
                    valid = 0;
                }
                else if(valid > 99){
                    JOptionPane.showMessageDialog(null, "Maximo de Proposiciones alcanzadas ( > 99 )");
                    valid = 0;
                }
                else{
                    valid = 0;

                    JOptionPane.showMessageDialog(null, algoritmo(texto.getText()));
                }
            }
        };
        ope.addActionListener(comenzar);
        
        
        ActionListener atomico = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               atomic a = new atomic();
               a.setVisible(true);
               dispose();                
            }  
        };
        ato.addActionListener(atomico);
    }  
    
    protected String algoritmo(String resultado){
        prop p1 = new prop("Tengo dinero");
        prop q1 = new prop("El perro es grande");
        prop r1 = new prop("El cielo es azul");
        prop s1 = new prop("Las rosas son rojas");
        
        
        char cadena[] = resultado.toCharArray();
        
        ArrayList<String> todo = new ArrayList<String>();
        
        int cont = 0;
        for(char letra : cadena){
            if(letra == '~'){
                if(cadena[cont + 1] == 'P'){
                    todo.add(p1.negar());
                    
                }
                else if(cadena[cont + 1] == 'Q'){
                    todo.add(q1.negar());
                    
                }
                
                else if(cadena[cont + 1] == 'R'){
                    todo.add(r1.negar());
                    
                }
                else if(cadena[cont + 1] == 'S'){
                    todo.add(s1.negar());
                    
                }
                cadena[cont + 1] = 'X';
            }
            else if(letra == 'P'){
                todo.add(p1.getProp());
            }
            else if(letra == 'Q'){
                todo.add(q1.getProp());
            }
            else if(letra == 'R'){
                todo.add(r1.getProp());
            }
            else if(letra == 'S'){
                todo.add(s1.getProp());
            }
            else if(letra == '^'){
                todo.add("y");
            }
            else if(letra == 'v'){
                todo.add("o");
            }
            else if(letra == '>'){
                todo.add("si");
            }
            else if(letra == '↔'){
                todo.add("si y solo si");
            }
            cont += 1;
        }
        return String.join(" ", todo);
    }

    
    private void cerrar() {
        WindowListener cierre = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Proposiciones centro = new Proposiciones();
                centro.setVisible(true);
                dispose();
            }
        };
        addWindowListener(cierre);
    }
}
