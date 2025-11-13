/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;

public class RoundedCardPanel extends JPanel {

    private int cornerRadius = 10; // Raio dos cantos
    private Color backgroundColor = new Color(250, 250, 250); // Fundo quase branco
    private Color borderColor = new Color(173, 216, 230); // Cor da borda (verde meio amarelado - exemplo)
    private int borderWidth = 2;

    private JLabel imagemLabel = new JLabel();
    private JLabel tituloLabel = new JLabel();
    private JLabel detalheLabel = new JLabel();
    private JLabel precoLabel = new JLabel();
    private JButton comprarButton = new JButton("COMPRAR");
    private Produto produto;

    public RoundedCardPanel(Produto produto) {
        this.produto = produto;
        setPreferredSize(new Dimension(180, 260));
        setMaximumSize(new Dimension(180, 260));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 15, 10)); // Espaçamento interno
        setOpaque(false); // Importante para que o paintComponent seja chamado corretamente

        // Carregar e redimensionar a imagem
        int larguraImagem = 110;
        int alturaImagem = 110;
        imagemLabel.setPreferredSize(new Dimension(larguraImagem, alturaImagem));
        imagemLabel.setMinimumSize(new Dimension(larguraImagem, alturaImagem));
        imagemLabel.setMaximumSize(new Dimension(larguraImagem, alturaImagem));
        try {
            ImageIcon icon = new ImageIcon(produto.getCaminhoImagem());
            Image scaledImage = icon.getImage().getScaledInstance(larguraImagem, alturaImagem, Image.SCALE_SMOOTH);
            imagemLabel.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
            imagemLabel.setText("Sem imagem");
            imagemLabel.setHorizontalAlignment(SwingConstants.CENTER);
        }
        imagemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        tituloLabel.setText(produto.getDescricao());
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tituloLabel.setFont(new Font("Serif", Font.BOLD, 16));
        tituloLabel.setBorder(new EmptyBorder(5, 5, 0, 5));

        detalheLabel.setText(produto.getGenero());
        detalheLabel.setHorizontalAlignment(SwingConstants.CENTER);
        detalheLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detalheLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        detalheLabel.setForeground(new Color(105, 105, 105));
        detalheLabel.setBorder(new EmptyBorder(0, 5, 5, 5));

        DecimalFormat df = new DecimalFormat("R$ #,##0.00");
        precoLabel.setText(df.format(produto.getPreco()));
        precoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        precoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        precoLabel.setFont(new Font("Serif", Font.BOLD, 16));
        precoLabel.setForeground(new Color(139, 69, 19));
        precoLabel.setBorder(new EmptyBorder(5, 0, 10, 0));

        comprarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        comprarButton.setBackground(new Color(85, 107, 47));
        comprarButton.setForeground(Color.WHITE);
        comprarButton.setFocusPainted(false);
        comprarButton.setFont(new Font("Serif", Font.BOLD, 14));
        comprarButton.setPreferredSize(new Dimension(120, 30));
        comprarButton.setMaximumSize(new Dimension(120, 30));
        comprarButton.setBorder(new EmptyBorder(5, 15, 5, 15));
        comprarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        comprarButton.addActionListener(e -> {
            Menu menu = new Menu(produto);
            menu.setVisible(true);
        });

        add(imagemLabel);
        add(Box.createVerticalStrut(5));
        add(tituloLabel);
        add(detalheLabel);
        add(Box.createVerticalGlue());
        add(precoLabel);
        add(comprarButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenha o fundo arredondado
        g2.setColor(getBackground()); // Usa a cor de fundo do painel (definida externamente)
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        // Desenha a borda arredondada
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(borderWidth));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        g2.dispose();
    }

    // Getter para a cor de fundo (se precisar configurar externamente)
    @Override
    public Color getBackground() {
        return backgroundColor;
    }

    // Setter para a cor de fundo (se precisar configurar externamente)
    @Override
    public void setBackground(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint();
    }

    // Métodos para ajustar a cor e o raio dos cantos (opcional)
    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint();
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        repaint();
    }
}