package com.mycompany.empresa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Empresa extends JFrame {

    public Empresa() {
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Menu");
        setLocationRelativeTo(null);
        setResizable(false);
        inicializacion();
    }

    private static Empresa principal;
    private JMenuItem inv, tasa, combos, distri, pedidos;

    private void inicializacion() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.add(panel);
        
        JLabel titulo = new JLabel("Seleccione una herramienta ");
        titulo.setBounds(50,200,400,30);
        titulo.setFont(new Font("",Font.BOLD,25));
        panel.add(titulo);
        
        JLabel sub = new JLabel("Cesar Dominguez y Valeria Garcia");
        sub.setBounds(50,250,400,30);
        sub.setFont(new Font("",Font.ITALIC,15));
        panel.add(sub);
        
        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);

        JMenu gnl = new JMenu("Herramientas");
        gnl.setFont(new Font("", Font.BOLD, 15));
        barra.add(gnl);

        inv = new JMenuItem("Inventario");
        gnl.add(inv);

        tasa = new JMenuItem("Tasa del Dolar");
        gnl.add(tasa);

        combos = new JMenuItem("Combos de Productos");
        gnl.add(combos);

        distri = new JMenuItem("Distribuidores");
        gnl.add(distri);

        pedidos = new JMenuItem("Pedidos");
        gnl.add(pedidos);

        eventos();
    }

    private void eventos() {
        ActionListener abrirInv = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                principal.setVisible(false);
                inventario ventanaInv = new inventario();
            }
        };
        inv.addActionListener(abrirInv);

        ActionListener abrirTas = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                principal.setVisible(false);
                tasa ventanaTas = new tasa();
            }
        };
        tasa.addActionListener(abrirTas);

        ActionListener abrirCom = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                principal.setVisible(false);
                combos ventanaCom = new combos();
            }
        };
        combos.addActionListener(abrirCom);

        ActionListener abrirDis = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                principal.setVisible(false);
                distribuidores dis = new distribuidores();
            }
        };
        distri.addActionListener(abrirDis);

        ActionListener abrirPed = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                principal.setVisible(false);
                pedidos ped = new pedidos();
            }
        };
        pedidos.addActionListener(abrirPed);
    }

    public static void main(String[] args) {
        principal = new Empresa();
        principal.setVisible(true);
    }
}
