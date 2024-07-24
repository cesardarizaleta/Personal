
package proposiciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.*;


public class atomic extends JFrame{
    private JTextField p,q,r,s,result;
    private JButton ato,mol,conj,dis,neg,cond,bi,ope,anadir,borrar,ale;
    private JCheckBox pC,qC,rC,sC;
    private ButtonGroup grupo;
    private int validador = 0,contPro = 0;
    
    public atomic(){
        setSize(800,600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Logica Proposicional - Atomico");
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
        
        JLabel intru = new JLabel("Seleccione y añada la proposicion");
        intru.setBounds(50,80,250,20);
        panel.add(intru);
        
        ato = new JButton("Atomica");
        ato.setBounds(550,40,100,50);
        ato.setEnabled(false);
        panel.add(ato);
        
        mol = new JButton("Molecular");
        mol.setBounds(650,40,100,50);
        panel.add(mol);
        
        String prop[] = {"P","Q","R","S"};
        int cont = 0;
        for(String pal : prop){
            JLabel label = new JLabel(pal);
            label.setBounds(50,150 + cont * 50,30,30);
            label.setFont(new Font("",Font.PLAIN,15));
            panel.add(label);
            cont +=1;
        }
        
        p = new JTextField();
        p.setBounds(80,145,575,40);
        panel.add(p);
        
        q = new JTextField();
        q.setBounds(80,195,575,40);
        panel.add(q);
        
        r = new JTextField();
        r.setBounds(80,245,575,40);
        panel.add(r);
        
        s = new JTextField();
        s.setBounds(80,295,575,40);
        panel.add(s);
        
        grupo = new ButtonGroup();
        
        
        JCheckBox cajita[] = {pC,qC,rC,sC};
        pC = new JCheckBox();
        pC.setBounds(680,145,40,40);
        panel.add(pC);  
        grupo.add(pC);        
        
        qC = new JCheckBox();
        qC.setBounds(680,195,40,40);
        panel.add(qC);  
        grupo.add(qC);   
        
        rC = new JCheckBox();
        rC.setBounds(680,245,40,40);
        panel.add(rC);  
        grupo.add(rC);   
        sC = new JCheckBox();
        sC.setBounds(680,295,40,40);
        panel.add(sC);  
        grupo.add(sC);
        
        conj = new JButton("Conjuncion");
        conj.setBounds(80,335,115,40);
        conj.setEnabled(false);
        panel.add(conj);
        
        dis = new JButton("Disyuncion");
        dis.setBounds(195,335,115,40);
        dis.setEnabled(false);
        panel.add(dis);
        
        neg = new JButton("Negacion");
        neg.setBounds(310,335,115,40);
        panel.add(neg);
        
        cond = new JButton("Condicional");
        cond.setBounds(425,335,115,40);
        cond.setEnabled(false);
        panel.add(cond);
        
        bi = new JButton("Bicondicional");
        bi.setBounds(540,335,115,40);
        bi.setEnabled(false);
        panel.add(bi);
        
        result = new JTextField("");
        result.setBounds(80,425,345,40);
        result.setEnabled(false);
        result.setDisabledTextColor(Color.BLACK);
        panel.add(result);
        
        ope = new JButton("Operar");
        ope.setBounds(80,465,115,40);
        panel.add(ope);
        
        anadir = new JButton("Añadir");
        anadir.setBounds(195,465,115,40);
        panel.add(anadir);
        
        borrar = new JButton("Borrar");
        borrar.setBounds(310,465,115,40);
        panel.add(borrar);
        
        JLabel forMol = new JLabel("Forma Molecular");
        forMol.setBounds(445,425,150,40);
        panel.add(forMol);
        
        ale = new JButton("Automatico");
        ale.setBounds(445,465,150,40);
        panel.add(ale);
        
        eventos();

    }
    

    
    private void eventos(){
        
        ActionListener random = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                p.setText("El mar es azul");
                q.setText("Tengo dinero");
                r.setText("Hay luz");
                s.setText("Ellos son muchas personas");
                randomizer();
            }
        };
        ale.addActionListener(random);
        
        
        ActionListener agregar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(pC.isSelected() || qC.isSelected() || rC.isSelected() || sC.isSelected()){
                if(validador == 1){
                    grupo.clearSelection();
                    validador = 0;
                    result.setText(result.getText() + "P");
                }
                else if(validador == 2){
                    grupo.clearSelection();
                    validador = 0;
                    result.setText(result.getText() + "Q");
                }
                else if(validador == 3){
                    grupo.clearSelection();
                    validador = 0;
                    result.setText(result.getText() + "R");
                }
                else if(validador == 4){
                    grupo.clearSelection();
                    validador = 0;
                    result.setText(result.getText() + "S");
                }
                contPro += 1;
                pC.setEnabled(false);
                qC.setEnabled(false);
                rC.setEnabled(false);
                sC.setEnabled(false);
                conj.setEnabled(true);
                dis.setEnabled(true);
                cond.setEnabled(true);
                bi.setEnabled(true);
                neg.setEnabled(false);
            }
            }
        };
        anadir.addActionListener(agregar);
        
        ItemListener chequeo = new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    if(e.getItem() == pC){
                        validador = 1;
                    }
                    else if(e.getItem() == qC){
                        validador = 2;
                        
                    }
                    else if(e.getItem() == rC){
                        validador = 3;
                        
                    }
                    else if(e.getItem() == sC){
                        validador = 4;
                        
                    }
                }
                
            }
        };
        pC.addItemListener(chequeo);
        qC.addItemListener(chequeo);
        rC.addItemListener(chequeo);
        sC.addItemListener(chequeo);
        
        ActionListener conector = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                pC.setEnabled(true);
                qC.setEnabled(true);
                rC.setEnabled(true);
                sC.setEnabled(true);
                conj.setEnabled(false);
                dis.setEnabled(false);
                cond.setEnabled(false);
                bi.setEnabled(false);
                neg.setEnabled(true);
                
                if(e.getSource().equals(conj)){
                    result.setText(result.getText() + "^");
                }
                else if(e.getSource().equals(dis)){
                    result.setText(result.getText() + "v");
                }
                else if(e.getSource().equals(cond)){
                    result.setText(result.getText() + ">");
                }
                else if(e.getSource().equals(bi)){
                    result.setText(result.getText() + "↔");
                }                
            }
        };
        conj.addActionListener(conector);
        dis.addActionListener(conector);
        cond.addActionListener(conector);
        bi.addActionListener(conector);
        
        ActionListener eliminar = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                result.setText("");
                pC.setEnabled(true);
                qC.setEnabled(true);
                rC.setEnabled(true);
                sC.setEnabled(true);
                neg.setEnabled(true);
                conj.setEnabled(false);
                dis.setEnabled(false);
                cond.setEnabled(false);
                bi.setEnabled(false);
                contPro = 0;
            }
            
        };
        borrar.addActionListener(eliminar);
        
        ActionListener negacion = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + "~");
                neg.setEnabled(false);
                conj.setEnabled(false);
                dis.setEnabled(false);
                cond.setEnabled(false);
                bi.setEnabled(false);
            }
        };
        neg.addActionListener(negacion);
        
        ActionListener operacion = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(contPro > 99){
                    JOptionPane.showMessageDialog(null, "Maximo de Proposiciones alcanzadas ( > 99 )");
                }
                else if(r.getText().equals("") && p.getText().equals("") && q.getText().equals("") && s.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Rellene todas las Proposiciones");
                }
                else{
                    JOptionPane.showMessageDialog(null, algoritmo(result.getText()));
                }
            }
        };
        ope.addActionListener(operacion);
        
        
        ActionListener molecular = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                molec m = new molec();
                m.setVisible(true);
                dispose();                
            }  
        };
        mol.addActionListener(molecular);
    }  

    
    
    private String algoritmo(String resultado){
        prop p1 = new prop(p.getText());
        prop q1 = new prop(q.getText());
        prop r1 = new prop(r.getText());
        prop s1 = new prop(s.getText());
        
        
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
       
    private void randomizer(){
        char letras[] = {'P','Q','R','S'};
        char signos[] = {'^','v','>','↔'};
        String negaciones[] = {"","~"};
        
        ArrayList<String> respuesta = new ArrayList<String>();
        
        for(String neg: negaciones){
            for(char letra : letras){
                for(char signo : signos){
                    for(String neg2 : negaciones){
                        for(char letra2 : letras){
                            respuesta.add(neg + Character.toString(letra) + Character.toString(signo) + neg2 +  Character.toString(letra2) + ": "+ algoritmo(neg + Character.toString(letra) + Character.toString(signo) + neg + Character.toString(letra2)));
                        }
                    }
                }
            }
        }
        System.out.println(respuesta.size());
       
        for(String neg: negaciones){
            for(char letra : letras){
                for(char signo : signos){
                    for(String neg2 : negaciones){
                        for(char letra2 : letras){
                            for(char signo2 : signos){
                                for(String neg3 : negaciones){
                                    for(char letra3 : letras){
                                        respuesta.add(neg + Character.toString(letra) + Character.toString(signo) + neg2 +  Character.toString(letra2) + Character.toString(signo2) + neg3 + Character.toString(letra3) + ": "+ algoritmo(neg + Character.toString(letra) + Character.toString(signo) + neg + Character.toString(letra2) + Character.toString(signo2) + neg2 + Character.toString(letra3)));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(respuesta.size());
        
        for(String neg: negaciones){
            for(char letra : letras){
                for(char signo : signos){
                    for(String neg2 : negaciones){
                        for(char letra2 : letras){
                            for(char signo2 : signos){
                                for(String neg3 : negaciones){
                                    for(char letra3 : letras){
                                        for(char signo3 : signos){
                                            for(String neg4 : negaciones){
                                                for(char letra4 : letras){
                                                    respuesta.add(neg + Character.toString(letra) + Character.toString(signo) + neg2 +  Character.toString(letra2) + Character.toString(signo2) + neg3 + Character.toString(letra3) + Character.toString(signo3) + neg4 + Character.toString(letra4)+ ": "+ algoritmo(neg + Character.toString(letra) + Character.toString(signo) + neg + Character.toString(letra2) + Character.toString(signo2) + neg2 + Character.toString(letra3) + Character.toString(signo3) + neg4 + Character.toString(letra4)));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        JTextArea area = new JTextArea(15,30);
        area.setEnabled(false);
        area.setDisabledTextColor(Color.BLACK);
        area.setText(String.join("\n", respuesta));
        
        JScrollPane deslizar = new JScrollPane(area);
        System.out.println("Posibilidades: " +respuesta.size());
        JOptionPane.showMessageDialog(null, deslizar);
        
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
