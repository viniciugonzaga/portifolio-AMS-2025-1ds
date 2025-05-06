/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

import javax.swing.*;
import java.awt.*;

// Dialog para exibir os detalhes de um produto específico
public class Menu extends Menu_Produtos {
    
public Menu (Produto produto) {
        setTitle("Menu de Compra");
        setSize(300, 200);
        setLocationRelativeTo(null); // Centraliza a janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha só essa janela

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Você está comprando:");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nome = new JLabel(produto.getDescricao());
        nome.setFont(new Font("Serif", Font.BOLD, 16));
        nome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel preco = new JLabel("Preço: R$ " + produto.getPreco());
        preco.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton finalizar = new JButton("Finalizar Compra");
        finalizar.setAlignmentX(Component.CENTER_ALIGNMENT);
        finalizar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Compra finalizada!");
            dispose(); // Fecha o menu
        });

        panel.add(Box.createVerticalStrut(10));
        panel.add(titulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(nome);
        panel.add(preco);
        panel.add(Box.createVerticalStrut(20));
        panel.add(finalizar);
        panel.add(Box.createVerticalStrut(10));

        add(panel);
    }
}
