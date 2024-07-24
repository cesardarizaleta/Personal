package com.mycompany.algoritmo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class menu extends JFrame {

    public menu() {
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Algoritmos y Estructura - Menu");
        setLocationRelativeTo(null);
        setResizable(false);
        iniciar();
    }

    public void iniciar() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.add(panel);

        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);
        JMenu opciones = new JMenu("Evaluaciones");
        opciones.setFont(new Font("calibri", Font.PLAIN, 15));
        barra.add(opciones);
        JMenuItem eva1 = new JMenuItem("Evaluacion 1 - Matrices");
        opciones.add(eva1);
        JMenuItem eva2 = new JMenuItem("Evaluacion 2 - Matrices Recursivas");
        opciones.add(eva2);
        JMenuItem eva3 = new JMenuItem("Evaluacion 3 - Nodos");
        opciones.add(eva3);
        JMenuItem eva4 = new JMenuItem("Evaluacion 4 - SQL");
        opciones.add(eva4);

        eventos(eva1, eva2, eva3, eva4);

        JLabel name = new JLabel("Cesar Dominguez");
        name.setFont(new Font("calibri", Font.ITALIC, 20));
        name.setBounds(310, 250, 300, 30);
        panel.add(name);

        JLabel titulo = new JLabel("Algoritmos y Estructuras");
        titulo.setFont(new Font("calibri", Font.BOLD, 20));
        titulo.setBounds(260, 200, 300, 30);
        panel.add(titulo);

    }

    public void eventos(JMenuItem eva1, JMenuItem eva2, JMenuItem eva3, JMenuItem eva4) {
        ActionListener abrir = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(eva1)) {
                    interfazMatriz sistemaMa = new interfazMatriz();
                    sistemaMa.setVisible(true);
                    centro.setVisible(false);
                } else if (e.getSource().equals(eva2)) {
                    interfazRecursiva sistemaRe = new interfazRecursiva();
                    sistemaRe.setVisible(true);
                    centro.setVisible(false);
                } else if (e.getSource().equals(eva3)) {
                    sistemaNodos sistemaNo = new sistemaNodos();
                    sistemaNo.setVisible(true);
                    centro.setVisible(false);
                } else if (e.getSource().equals(eva4)) {
                    estudiantes sistemaEs = new estudiantes();
                    sistemaEs.setVisible(true);
                    centro.setVisible(false);
                }
            }
        };
        eva1.addActionListener(abrir);
        eva2.addActionListener(abrir);
        eva3.addActionListener(abrir);
        eva4.addActionListener(abrir);

    }

    public static menu centro;

    public static void main(String[] args) {
        centro = new menu();
        centro.setVisible(true);
    }
}
