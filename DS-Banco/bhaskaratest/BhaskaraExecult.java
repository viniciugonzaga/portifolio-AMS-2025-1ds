/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bhaskaratest;


import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  



class BhaskaraExecult extends JFrame {
    private JTextField fieldA, fieldB, fieldC;
    private JLabel resultLabel;

    public BhaskaraExecult() {
        setTitle("Calculadora de Bhaskara");
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

        JLabel titleLabel = new JLabel("Calculadora de Bhaskara");
        titleLabel.setForeground(Color.CYAN);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        // Coeficiente A
        JLabel labelA = new JLabel("Coeficiente a:");
        labelA.setForeground(Color.CYAN);
        panel.add(labelA, gbc);

        gbc.gridx = 1;
        fieldA = new JTextField(10);
        panel.add(fieldA, gbc);

        // Coeficiente B
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel labelB = new JLabel("Coeficiente b:");
        labelB.setForeground(Color.CYAN);
        panel.add(labelB, gbc);

        gbc.gridx = 1;
        fieldB = new JTextField(10);
        panel.add(fieldB, gbc);

        // Coeficiente C
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel labelC = new JLabel("Coeficiente c:");
        labelC.setForeground(Color.CYAN);
        panel.add(labelC, gbc);

        gbc.gridx = 1;
        fieldC = new JTextField(10);
        panel.add(fieldC, gbc);

        // Botão Calcular
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton calculateButton = new JButton("Calcular");
        calculateButton.setBackground(Color.CYAN);
        calculateButton.setForeground(Color.BLACK);
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton.addActionListener(new CalculateBhaskara());
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

    private class CalculateBhaskara implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double a = Double.parseDouble(fieldA.getText());
                double b = Double.parseDouble(fieldB.getText());
                double c = Double.parseDouble(fieldC.getText());

                double delta = b * b - 4 * a * c;
                if (delta < 0) {
                    resultLabel.setText("Sem raízes reais.");
                } else {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    resultLabel.setText(String.format("x1 = %.2f, x2 = %.2f", x1, x2));
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida!");
            }
        }
    }

    public static void main(String[] args) {
        new BhaskaraExecult();
    }
}
