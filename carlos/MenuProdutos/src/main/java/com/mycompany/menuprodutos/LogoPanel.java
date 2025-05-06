/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel {
    public LogoPanel(JLabel logoLabel) {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // Alinhamento horizontal

        // Cria o texto ao lado da imagem
        JLabel textLabel = new JLabel("Livraria entre palavras");
        textLabel.setFont(new Font("Serif", Font.BOLD, 20));
        textLabel.setForeground(Color.WHITE); // Cor do texto

        // Adiciona a imagem e o texto ao painel
        add(logoLabel);
        add(textLabel);

        setOpaque(false); // Deixe transparente se a cor for aplicada externamente
    }
}
