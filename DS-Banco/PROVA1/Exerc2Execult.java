/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exerc2;

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


public class Exerc2Execult extends JFrame {
    
       
    private JTextField fieldA, fieldB, fieldC;
    private JLabel resultLabel, resultLabel2; 

    public Exerc2Execult() {
        setTitle("Calcular Temperatura");
        setSize(600, 400); // Janela maior
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

        
        
        JLabel titleLabel = new JLabel("Calculadora de Temperatura");
        titleLabel.setForeground(Color.CYAN);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        // Coeficiente A
        JLabel labelA = new JLabel("Graus Celsius:");
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
        resultLabel = new JLabel("graus Kelvin:");
        resultLabel.setForeground(Color.CYAN);
        panel.add(resultLabel, gbc);
        
         // Resultado
        gbc.gridy++;
        resultLabel2 = new JLabel("graus fahrenheit:");
        resultLabel2.setForeground(Color.CYAN);
        panel.add(resultLabel2, gbc);

        
        
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
                double celsius = Double.parseDouble(fieldA.getText());
                double kelvin = 273.15 + celsius;
                double fahrenheit = (celsius * 9 / 5) + 32;
                
                
                resultLabel2.setText("Graus Fahrenheit: " + fahrenheit);
                resultLabel.setText("Graus Kelvin: " + kelvin);
              

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida!");
                resultLabel2.setText("");
            }
        }
    
    }
}

