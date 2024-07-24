
package com.mycompany.logicasimbolica;

import javax.swing.*;

public class objetos{
    public JLabel label = new JLabel("");
    public JButton btn = new JButton("");
    public JTextField txt = new JTextField("");
    
    public objetos(String eti,int x,int y,int w, int h){
        this.label.setText(eti);
        this.label.setBounds(x,y,w,h);
    }
    
    public objetos(String eti,int x,int y,int w, int h,boolean condicion){
        this.btn.setText(eti);
        this.btn.setBounds(x,y,w,h);
        this.btn.setEnabled(condicion);
    }
    
    public objetos(int x,int y,int w, int h){
        this.txt.setBounds(x,y,w,h);
    }
    
    public void setButton(JPanel panel){
        panel.add(btn);
    }

    public void setLabel(JPanel panel) {
        panel.add(label);
    }

    public void setTxt(JPanel panel) {
        panel.add(txt);
    }
    
}
