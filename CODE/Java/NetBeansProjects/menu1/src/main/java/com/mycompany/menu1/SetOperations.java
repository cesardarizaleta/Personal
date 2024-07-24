
package com.mycompany.menu1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class SetOperations {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Set Operations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField universalSetField = new JTextField();
        universalSetField.setPreferredSize(new Dimension(500, 25));
        universalSetField.setMaximumSize(new Dimension(500, 25));
        universalSetField.setEditable(false);

        JTextField subSet1Field = new JTextField();
        subSet1Field.setPreferredSize(new Dimension(500, 25));
        subSet1Field.setMaximumSize(new Dimension(500, 25));
        subSet1Field.setEditable(false);

        JTextField subSet2Field = new JTextField();
        subSet2Field.setPreferredSize(new Dimension(500, 25));
        subSet2Field.setMaximumSize(new Dimension(500, 25));
        subSet2Field.setEditable(false);

        JTextField subSet3Field = new JTextField();
        subSet3Field.setPreferredSize(new Dimension(500, 25));
        subSet3Field.setMaximumSize(new Dimension(500, 25));
        subSet3Field.setEditable(false);

        JTextField subSet4Field = new JTextField();
        subSet4Field.setPreferredSize(new Dimension(500, 25));
        subSet4Field.setMaximumSize(new Dimension(500, 25));
        subSet4Field.setEditable(false);

        JButton randomizeButton = new JButton("Randomize");
        randomizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] universalSet = generateRandomSet(20);
                String[] subSet1 = generateRandomSet(4);
                String[] subSet2 = generateRandomSet(4);
                String[] subSet3 = generateRandomSet(4);
                String[] subSet4 = generateRandomSet(4);

                
                universalSetField.setText(Arrays.toString(universalSet));
                subSet1Field.setText(Arrays.toString(subSet1));
                subSet2Field.setText(Arrays.toString(subSet2));
                subSet3Field.setText(Arrays.toString(subSet3));
                subSet4Field.setText(Arrays.toString(subSet4));
            }
        });

        panel.add(new JLabel("Universal Set:"));
        panel.add(universalSetField);
        panel.add(new JLabel("Subset 1:"));
        panel.add(subSet1Field);
        panel.add(new JLabel("Subset 2:"));
        panel.add(subSet2Field);
        panel.add(new JLabel("Subset 3:"));
        panel.add(subSet3Field);
        panel.add(new JLabel("Subset 4:"));
        panel.add(subSet4Field);
        panel.add(randomizeButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static String[] generateRandomSet(int size) {
        String[] set = new String[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            set[i] = String.valueOf(random.nextInt(20) + 1);
        }

        return set;
    }
}