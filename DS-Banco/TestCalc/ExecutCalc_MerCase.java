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
        
        // Aplicando estilo aos componentes
        Font fonte = new Font("Arial", Font.BOLD, 14);
        rotulo1.setFont(fonte);
        rotulo2.setFont(fonte);
        exibir.setFont(fonte);
        
        // Personalização dos botões
        Color corBotao = new Color(70, 130, 180);
        Color corTexto = Color.WHITE;
        
        somar.setBackground(corBotao);
        somar.setForeground(corTexto);
        subtrair.setBackground(corBotao);
        subtrair.setForeground(corTexto);
        multiplicacao.setBackground(corBotao);
        multiplicacao.setForeground(corTexto);
        divisao.setBackground(corBotao);
        divisao.setForeground(corTexto);
        
        // Definição das posições dos componentes na tela
        rotulo1.setBounds(50, 20, 120, 30);
        rotulo2.setBounds(50, 60, 120, 30);
        texto1.setBounds(160, 20, 150, 30);
        texto2.setBounds(160, 60, 150, 30);
        exibir.setBounds(40, 220, 300, 30);
        
        // Definição da posição dos botões de operações
        somar.setBounds(50, 110, 120, 40);
        subtrair.setBounds(190, 110, 120, 40);
        multiplicacao.setBounds(50, 160, 120, 40);
        divisao.setBounds(190, 160, 120, 40);
        
        // Adicionando bordas aos botões
        somar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        subtrair.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        multiplicacao.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        divisao.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        // Configuração das funcionalidades dos botões com tratamento de erro
        somar.addActionListener(e -> realizarOperacao("soma"));
        subtrair.addActionListener(e -> realizarOperacao("subtracao"));
        multiplicacao.addActionListener(e -> realizarOperacao("multiplicacao"));
        divisao.addActionListener(e -> realizarOperacao("divisao"));
        
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
        setSize(380, 300); // Aumenta o tamanho da janela
        setResizable(false); // Impede redimensionamento
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o programa ao fechar a janela
    }
    
    private void realizarOperacao(String operacao) {
        try {
            double numero1 = Double.parseDouble(texto1.getText());
            double numero2 = Double.parseDouble(texto2.getText());
            double resultado = 0;
            
            switch (operacao) {
                case "soma":
                    resultado = numero1 + numero2;
                    exibir.setText("A soma é: " + resultado);
                    break;
                case "subtracao":
                    resultado = numero1 - numero2;
                    exibir.setText("A subtração é: " + resultado);
                    break;
                case "multiplicacao":
                    resultado = numero1 * numero2;
                    exibir.setText("A multiplicação é: " + resultado);
                    break;
                case "divisao":
                    if (numero2 == 0) {
                        JOptionPane.showMessageDialog(null, "Erro: Divisão por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    resultado = numero1 / numero2;
                    exibir.setText("A divisão é: " + resultado);
                    break;
            }
            
            exibir.setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, insira números válidos!", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        // Criação e exibição da calculadora
        SwingUtilities.invokeLater(() -> new ExecutCalc().setVisible(true));
    }
}
