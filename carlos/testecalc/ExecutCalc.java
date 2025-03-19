/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testecalc;

import javax.swing.JFrame;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  

public class ExecutCalc extends JFrame{
    
    JLabel rotulo1, rotulo2, exibir;
    JTextField texto1, texto2;
    JButton somar;
    JButton subtrair;
    JButton multiplicacao;
    JButton divisao;
    

    public ExecutCalc() {
        
        //colocar nome e ícone
        super("Calculadora");
        Container tela = getContentPane();
        setLayout(null);
        
        //criação dos botões (nomeação)
        rotulo1 = new JLabel("1º Número: ");
        rotulo2 = new JLabel("2º Número: ");
        texto1 = new JTextField(5);
        texto2 = new JTextField(5);
        exibir = new JLabel("");
        somar = new JButton("Somar");
        subtrair = new JButton("Subtrair");
        multiplicacao = new JButton("Multipliacação");
        divisao = new JButton("Divisão");


        
        //Posição dos Campos
        //setBounds(posiçãoX, posiçãoY, largura, altura)
        rotulo1.setBounds(50, 20, 100, 20);
        rotulo2.setBounds(50, 60, 100, 20);
        texto1.setBounds(120, 20, 200, 20);
        texto2.setBounds(120, 60, 200, 20);
        exibir.setBounds(40, 180, 200, 20);
        
        
        // Botões das operações
        somar.setBounds(80, 100, 100, 30);
        subtrair.setBounds(220, 100, 100, 30);
        multiplicacao.setBounds(70, 140, 120, 30);
        divisao.setBounds(220, 140, 100, 30);
        
       // Lógica dos botões com tratamento de erro
        somar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numero1 = Integer.parseInt(texto1.getText());
                    double numero2 = Integer.parseInt(texto2.getText());
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
                    double numero1 = Integer.parseInt(texto1.getText());
                    double numero2 = Integer.parseInt(texto2.getText());
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
                    double numero1 = Integer.parseInt(texto1.getText());
                    double numero2 = Integer.parseInt(texto2.getText());
                    double multiplicacao = numero1 * numero2;
                    exibir.setVisible(true);
                    exibir.setText("A multiplicação é: " + multiplicacao);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira números válidos!", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        divisao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double numero1 = Integer.parseInt(texto1.getText());
                    double numero2 = Integer.parseInt(texto2.getText());
                    if (numero2 == 0) {
                        JOptionPane.showMessageDialog(null, "Erro: Divisão por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    double divisao = numero1 / numero2;
                    exibir.setVisible(true);
                    exibir.setText("A divisão é: " + divisao);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira números válidos!", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
         
        exibir.setVisible(false);

        //adicionar na tela 
        tela.add(rotulo1);
        tela.add(rotulo2);
        tela.add(texto1);
        tela.add(texto2);
        tela.add(exibir);
        tela.add(somar);
        tela.add(subtrair);
        tela.add(multiplicacao);
        tela.add(divisao);

        setSize(400, 250);
        setResizable(false); // Impede redimensionamento
        setLocationRelativeTo(null); // Centraliza a janela na tela
        
        
    
    }
}
