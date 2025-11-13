/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testecalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExecutCalc extends JFrame {
    // Declaração dos componentes da interface
    JLabel rotulo1, rotulo2, exibir;
    JTextField texto1, texto2;
    JButton somar, subtrair, multiplicacao, divisao;

    public ExecutCalc() {
        // Configuração da janela principal
        super("Calculadora");
        Container tela = getContentPane();
        setLayout(null);
        
        // Criação e nomeação dos componentes
        rotulo1 = new JLabel("1º Número: ");
        rotulo2 = new JLabel("2º Número: ");
        texto1 = new JTextField(5);
        texto2 = new JTextField(5);
        exibir = new JLabel("");
        somar = new JButton("Somar");
        subtrair = new JButton("Subtrair");
        multiplicacao = new JButton("Multiplicação");
        divisao = new JButton("Divisão");
        
        // Definição das posições dos componentes na tela
        rotulo1.setBounds(50, 20, 100, 20);
        rotulo2.setBounds(50, 60, 100, 20);
        texto1.setBounds(120, 20, 200, 20);
        texto2.setBounds(120, 60, 200, 20);
        exibir.setBounds(40, 180, 300, 20);
        
        // Definição da posição dos botões de operações
        somar.setBounds(50, 100, 100, 30);
        subtrair.setBounds(160, 100, 100, 30);
        multiplicacao.setBounds(50, 140, 100, 30);
        divisao.setBounds(160, 140, 100, 30);
        
        // Configuração das funcionalidades dos botões com tratamento de erro
        somar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numero1 = Double.parseDouble(texto1.getText());
                    double numero2 = Double.parseDouble(texto2.getText());
                    double soma = numero1 + numero2;
                    exibir.setVisible(true);
                    exibir.setText("A soma é: " + soma);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira números válidos!", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        subtrair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numero1 = Double.parseDouble(texto1.getText());
                    double numero2 = Double.parseDouble(texto2.getText());
                    double subtracao = numero1 - numero2;
                    exibir.setVisible(true);
                    exibir.setText("A subtração é: " + subtracao);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira números válidos!", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        multiplicacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numero1 = Double.parseDouble(texto1.getText());
                    double numero2 = Double.parseDouble(texto2.getText());
                    double resultado = numero1 * numero2;
                    exibir.setVisible(true);
                    exibir.setText("A multiplicação é: " + resultado);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira números válidos!", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        divisao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numero1 = Double.parseDouble(texto1.getText());
                    double numero2 = Double.parseDouble(texto2.getText());
                    if (numero2 == 0) {
                        JOptionPane.showMessageDialog(null, "Erro: Divisão por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    double resultado = numero1 / numero2;
                    exibir.setVisible(true);
                    exibir.setText("A divisão é: " + resultado);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira números válidos!", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // Inicialmente, o rótulo de exibição de resultados estará invisível
        exibir.setVisible(false);
        
        // Adiciona os componentes na tela
        tela.add(rotulo1);
        tela.add(rotulo2);
        tela.add(texto1);
        tela.add(texto2);
        tela.add(exibir);
        tela.add(somar);
        tela.add(subtrair);
        tela.add(multiplicacao);
        tela.add(divisao);
        
        // Configuração da janela
        setSize(350, 250); // Define tamanho da janela
        setResizable(false); // Impede redimensionamento
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o programa ao fechar a janela
    }
    
    public static void main(String[] args) {
        // Criação e exibição da calculadora
        SwingUtilities.invokeLater(() -> {
            new ExecutCalc().setVisible(true);
        });
    }
}



