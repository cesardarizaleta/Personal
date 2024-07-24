
package proposiciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Proposiciones extends JFrame{
    private JButton ato,mol;
    
    public Proposiciones(){
        setSize(800,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Logica Proposicional");
        setLocationRelativeTo(null);
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
        panel.add(mol);
        
        eventos();

    }
    
    private void eventos(){
        ActionListener atomico = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                atomic a = new atomic();
                a.setVisible(true);
                dispose();
            }  
        };
        ato.addActionListener(atomico);
        
        ActionListener molecular = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                molec m = new molec();
                m.setVisible(true);
                dispose();
            }  
        };
        mol.addActionListener(molecular);        
    }
    
    public static void main(String[] args) {
        Proposiciones p = new Proposiciones();
        p.setVisible(true);
    }
}
