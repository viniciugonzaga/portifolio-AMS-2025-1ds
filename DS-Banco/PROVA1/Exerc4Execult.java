/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exerc4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dti
 */
public class Exerc4Execult extends JFrame  {
    
     private JTextField fieldA;
    private JLabel resultLabel, resultLabel2, resultLabel3, resultLabel4, resultLabel5, resultLabel6 ; 

    public Exerc4Execult() {
        setTitle("Calcular Peso em Planetas");
        setSize(800, 600); // Janela maior
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Centraliza na tela

        // Painel principal com fundo escuro e borda azul
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 4));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        
        
        JLabel titleLabel = new JLabel("Calculadora de Peso em planetas");
        titleLabel.setForeground(Color.CYAN);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        // Coeficiente A
        JLabel labelA = new JLabel("Peso na terra: ");
        labelA.setForeground(Color.CYAN);
        panel.add(labelA, gbc);

        gbc.gridx = 1;
        fieldA = new JTextField(10);
        panel.add(fieldA, gbc);

        

       


        // Botão Calcular
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton calculateButton = new JButton("Converter");
        calculateButton.setBackground(Color.CYAN);
        calculateButton.setForeground(Color.BLACK);
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton.addActionListener(new CalculateBhaskara());
        panel.add(calculateButton, gbc);

        // Resultado
        gbc.gridy++;
        resultLabel = new JLabel("Mercúrio: ");
        resultLabel.setForeground(Color.CYAN);
        panel.add(resultLabel, gbc);
        
         // Resultado
        gbc.gridy++;
        resultLabel2 = new JLabel("Vênus: ");
        resultLabel2.setForeground(Color.CYAN);
        panel.add(resultLabel2, gbc);
        
         // Resultado
        gbc.gridy++;
        resultLabel3 = new JLabel("Marte: ");
        resultLabel3.setForeground(Color.CYAN);
        panel.add(resultLabel3, gbc);

         // Resultado
        gbc.gridy++;
        resultLabel4 = new JLabel("Júpiter: ");
        resultLabel4.setForeground(Color.CYAN);
        panel.add(resultLabel4, gbc);
        
         // Resultado
        gbc.gridy++;
        resultLabel5 = new JLabel("Saturno: ");
        resultLabel5.setForeground(Color.CYAN);
        panel.add(resultLabel5, gbc);
        
         // Resultado
        gbc.gridy++;
        resultLabel6 = new JLabel("Urano: ");
        resultLabel6.setForeground(Color.CYAN);
        panel.add(resultLabel6, gbc);
        
        
        
        
        // Painel principal
        add(panel, BorderLayout.CENTER);

        // Botão Sair no canto inferior direito
        JButton exitButton = new JButton("Sair");
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 12));
        exitButton.addActionListener(e -> System.exit(0));

        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        exitPanel.setBackground(Color.BLACK);
        exitPanel.add(exitButton);
        add(exitPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    
    private class CalculateBhaskara implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
          try {
                double weight = Double.parseDouble(fieldA.getText());

                // Fatores gravitacionais
                double mercury = weight/1 * 0.37;
                double venus = weight /1 * 0.88;
                double mars = weight/ 1 * 0.38;
                double jupiter = weight/ 1 * 2.64;
                double saturn = weight/ 1 * 1.15;
                double uranus = weight/ 1 * 0.17;

                resultLabel.setText("Mercúrio: " + mercury + " kg");
                resultLabel2.setText("Vênus: " + venus + " kg");
                resultLabel3.setText("Marte: " + mars + " kg");
                resultLabel4.setText("Júpiter: " + jupiter + " kg");
                resultLabel5.setText("Saturno: " + saturn + " kg");
                resultLabel6.setText("Urano: " + uranus + " kg");

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida!");
                resultLabel2.setText("");
                resultLabel3.setText("");
                resultLabel4.setText("");
                resultLabel5.setText("");
                resultLabel6.setText("");
            }
        }
    }
    
    
}
