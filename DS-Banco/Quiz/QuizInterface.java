/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testquizinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizInterface extends JFrame implements ActionListener {
    private JLabel perguntaLabel;
    private JTextField respostaField;
    private JButton confirmarButton;
    private JLabel resultadoLabel;
    private int pontuacao = 0;
    private int perguntaAtual = 0;

    private String[] perguntas = {
        "Qual componente do Swing é usado para criar botões?",
        "Qual classe serve como base para criar janelas no Swing?",
        "Qual método define o tamanho da janela?",
        "Qual método torna a janela visível?"
    };

    private String[] respostasCorretas = {"JButton", "JFrame", "setSize", "setVisible"};

    public QuizInterface() {
        super("Desafio Final - Interface Gráfica");
        setSize(400, 200);
        setLayout(new FlowLayout());

        perguntaLabel = new JLabel(perguntas[perguntaAtual]);
        respostaField = new JTextField(15);
        confirmarButton = new JButton("Responder");
        resultadoLabel = new JLabel("Pontuação: 0");

        confirmarButton.addActionListener(this);

        add(perguntaLabel);
        add(respostaField);
        add(confirmarButton);
        add(resultadoLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Impede redimensionamento
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    }

   
    public void actionPerformed(ActionEvent e) {
        String resposta = respostaField.getText().trim();

        if (resposta.equalsIgnoreCase(respostasCorretas[perguntaAtual])) {
            pontuacao += 10;
        }

        perguntaAtual++;

        if (perguntaAtual < perguntas.length) {
            perguntaLabel.setText(perguntas[perguntaAtual]);
            respostaField.setText("");
        } else {
            perguntaLabel.setText("Quiz finalizado!");
            respostaField.setEnabled(false);
            confirmarButton.setEnabled(false);
        }

        resultadoLabel.setText("Pontuação: " + pontuacao);
       
    }
    
}
