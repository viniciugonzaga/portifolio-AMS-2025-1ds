/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pitagoras_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PitagorasExecult extends JFrame {
    
    private JTextField fieldCateto1, fieldCateto2, fieldHipotenusa;
    private JLabel resultLabel;

    public PitagorasExecult() {
        setTitle("Calculadora de Pitágoras");
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

        JLabel titleLabel = new JLabel("Calculadora de Pitágoras");
        titleLabel.setForeground(Color.CYAN);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        // Cateto 1
        JLabel labelCateto1 = new JLabel("Cateto 1:");
        labelCateto1.setForeground(Color.CYAN);
        panel.add(labelCateto1, gbc);

        gbc.gridx = 1;
        fieldCateto1 = new JTextField(10);
        panel.add(fieldCateto1, gbc);

        // Cateto 2
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel labelCateto2 = new JLabel("Cateto 2:");
        labelCateto2.setForeground(Color.CYAN);
        panel.add(labelCateto2, gbc);

        gbc.gridx = 1;
        fieldCateto2 = new JTextField(10);
        panel.add(fieldCateto2, gbc);

        // Hipotenusa
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel labelHipotenusa = new JLabel("Hipotenusa:");
        labelHipotenusa.setForeground(Color.CYAN);
        panel.add(labelHipotenusa, gbc);

        gbc.gridx = 1;
        fieldHipotenusa = new JTextField(10);
        panel.add(fieldHipotenusa, gbc);

        // Botão Calcular
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton calculateButton = new JButton("Calcular");
        calculateButton.setBackground(Color.CYAN);
        calculateButton.setForeground(Color.BLACK);
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton.addActionListener(new CalculatePitagoras());
        panel.add(calculateButton, gbc);

        // Resultado
        gbc.gridy++;
        resultLabel = new JLabel("Resultado:");
        resultLabel.setForeground(Color.CYAN);
        panel.add(resultLabel, gbc);

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

    private class CalculatePitagoras implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String cateto1Text = fieldCateto1.getText();
                String cateto2Text = fieldCateto2.getText();
                String hipotenusaText = fieldHipotenusa.getText();

                double cateto1 = cateto1Text.isEmpty() ? -1 : Double.parseDouble(cateto1Text);
                double cateto2 = cateto2Text.isEmpty() ? -1 : Double.parseDouble(cateto2Text);
                double hipotenusa = hipotenusaText.isEmpty() ? -1 : Double.parseDouble(hipotenusaText);

                if (hipotenusa == -1) {
                    // Calcular Hipotenusa: h² = c1² + c2²
                    if (cateto1 > 0 && cateto2 > 0) {
                        hipotenusa = Math.sqrt((cateto1 * cateto1) + (cateto2 * cateto2));
                        resultLabel.setText(String.format("Hipotenusa: %.2f", hipotenusa));
                    } else {
                        resultLabel.setText("Forneça os dois catetos!");
                    }
                } else if (cateto1 == -1) {
                    // Calcular Cateto 1: c1² = h² - c2²
                    if (hipotenusa > 0 && cateto2 > 0 && hipotenusa > cateto2) {
                        cateto1 = Math.sqrt((hipotenusa * hipotenusa) - (cateto2 * cateto2));
                        resultLabel.setText(String.format("Cateto 1: %.2f", cateto1));
                    } else {
                        resultLabel.setText("Valores inválidos!");
                    }
                } else if (cateto2 == -1) {
                    // Calcular Cateto 2: c2² = h² - c1²
                    if (hipotenusa > 0 && cateto1 > 0 && hipotenusa > cateto1) {
                        cateto2 = Math.sqrt((hipotenusa * hipotenusa) - (cateto1 * cateto1));
                        resultLabel.setText(String.format("Cateto 2: %.2f", cateto2));
                    } else {
                        resultLabel.setText("Valores inválidos!");
                    }
                } else {
                    resultLabel.setText("Deixe um campo vazio para calcular!");
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida!");
            }
        }
    }    
    
}
