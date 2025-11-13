/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcarro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

public class ExecultCarro extends JFrame {
    
 private ExecultCarro2 carro; // Objeto que contém os dados e métodos do carro
    private JTextArea outputArea; // Área onde as ações são exibidas
    private JTextField modeloField, corField, motorField, nomeField; // Campos de texto para inserir dados

    public ExecultCarro() {
        carro = new ExecultCarro2(); // Inicializa o carro

        // Configurações da Janela Principal
        setTitle("Simulador de Carro");
        setSize(800, 600); // AUMENTA o tamanho da janela (largura, altura)
        setResizable(false); // Impede o usuário de redimensionar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Painel principal com GridBagLayout para organizar os campos e botões
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.DARK_GRAY); // Cor de fundo
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3)); // Borda azul clara

        GridBagConstraints gbc = new GridBagConstraints(); // Restrições de layout
        gbc.insets = new Insets(10, 10, 5, 10); // Espaçamento interno
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Título
        JLabel title = new JLabel("Controle do Carro");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.CYAN);
        gbc.gridwidth = 2;
        mainPanel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        // Campo: Nome do carro
        mainPanel.add(makeLabel("Nome:"), gbc);
        gbc.gridx = 1;
        nomeField = new JTextField();
        mainPanel.add(nomeField, gbc);

        // Campo: Modelo
        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(makeLabel("Modelo:"), gbc);
        gbc.gridx = 1;
        modeloField = new JTextField();
        mainPanel.add(modeloField, gbc);

        // Campo: Cor
        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(makeLabel("Cor:"), gbc);
        gbc.gridx = 1;
        corField = new JTextField();
        mainPanel.add(corField, gbc);

        // Campo: Motor
        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(makeLabel("Motor:"), gbc);
        gbc.gridx = 1;
        motorField = new JTextField();
        mainPanel.add(motorField, gbc);

        // Botão: Iniciar carro
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton startButton = new JButton("Iniciar Carro");
        startButton.setBackground(Color.CYAN);
        startButton.setForeground(Color.BLACK);
        startButton.addActionListener(e -> iniciarCarro());
        mainPanel.add(startButton, gbc);

     // Área de saída dos resultados
gbc.gridy++;
gbc.gridwidth = 2;
gbc.fill = GridBagConstraints.BOTH; // Permite expandir tanto horizontal quanto verticalmente
gbc.weightx = 1.0; // Expansão horizontal
gbc.weighty = 1.0; // Expansão vertical

// Aumenta área de texto (visual) e ativa quebra de linha automática
outputArea = new JTextArea(20, 70); // Maior altura e largura
outputArea.setEditable(false);
outputArea.setBackground(Color.BLACK);
outputArea.setForeground(Color.GREEN);
outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
outputArea.setLineWrap(true); // Quebra de linha automática
outputArea.setWrapStyleWord(true); // Quebra por palavras inteiras

// Scroll somente vertical
JScrollPane scroll = new JScrollPane(outputArea);
scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

// Adiciona ao painel principal
mainPanel.add(scroll, gbc);

// Reseta o grid para próximos componentes
gbc.gridwidth = 1;
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.weightx = 0;
gbc.weighty = 0;

        // Painel de botões de ações do carro
        JPanel botoes = new JPanel(new GridLayout(1, 5, 5, 5));
        botoes.setBackground(Color.DARK_GRAY);
        botoes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.CYAN), "Ações"));

        // Criação dos botões de ação, conectados à lógica do carro
        botoes.add(makeActionButton("Ligar", () -> carro.ligar(outputArea)));
        botoes.add(makeActionButton("Marcha", () -> carro.mudarMarcha(outputArea)));
        botoes.add(makeActionButton("Acelerar", () -> carro.acelerar(outputArea)));
        botoes.add(makeActionButton("Brecar", () -> carro.brecar(outputArea)));
        botoes.add(makeActionButton("Desligar", () -> carro.desligar(outputArea)));

        // Adicionando os painéis na janela
        add(mainPanel, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        setVisible(true); // Exibe a janela
    }

    // Método auxiliar para criar rótulos personalizados
    private JLabel makeLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setForeground(Color.CYAN);
        return label;
    }

    // Método auxiliar para criar botões com ação associada
    private JButton makeActionButton(String text, Runnable action) {
        JButton button = new JButton(text);
        button.setBackground(Color.CYAN);
        button.setForeground(Color.BLACK);
        button.addActionListener(e -> action.run());
        return button;
    }

    // Método executado quando o botão "Iniciar Carro" é pressionado
    private void iniciarCarro() {
        // Coleta os dados inseridos pelo usuário
        carro.nome = nomeField.getText();
        carro.modelo = modeloField.getText();
        carro.cor = corField.getText();
        carro.motor = motorField.getText();

        // Limpa e atualiza a área de saída
        outputArea.setText("");
        outputArea.append("=== INFORMAÇÕES DO CARRO ===\n");
        outputArea.append("Nome: " + carro.nome + "\n");
        outputArea.append("Modelo: " + carro.modelo + "\n");
        outputArea.append("Cor: " + carro.cor + "\n");
        outputArea.append("Motor: " + carro.motor + "\n\n");
    }
}