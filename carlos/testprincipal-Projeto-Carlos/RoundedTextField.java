/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

import javax.swing.*;
import javax.swing.border.EmptyBorder; // Para espaçamento interno
import java.awt.*;
import java.awt.geom.RoundRectangle2D; // Para desenhar o retângulo arredondado

// Classe personalizada para um JTextField com bordas arredondadas
public class RoundedTextField extends JTextField {

    private Shape shape; // Forma para a borda arredondada
    private int cornerRadius = 15; // Raio dos cantos arredondados (ajuste conforme necessário)
    private Color borderColor = Color.GRAY; // Cor da borda (ajuste conforme necessário)
    private int borderWidth = 1; // Espessura da borda (ajuste conforme necessário)

    public RoundedTextField(int columns) {
        super(columns);
        // Define uma borda vazia para criar espaçamento interno para o texto
        // Isso impede que o texto fique colado nas bordas arredondadas
        setBorder(new EmptyBorder(5, cornerRadius, 5, cornerRadius));
        setOpaque(false); // Torna o fundo transparente para que a forma arredondada seja visível
    }

    // Sobrescreve o método paintComponent para desenhar o fundo arredondado
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        // Ativa o anti-aliasing para bordas mais suaves
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenha o fundo preenchido com a cor de fundo do componente pai (transparente)
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        // Chama o método paintComponent da superclasse para desenhar o texto
        super.paintComponent(g2);

        g2.dispose(); // Libera os recursos gráficos
    }

    // Sobrescreve o método paintBorder para desenhar a borda arredondada
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        // Ativa o anti-aliasing para bordas mais suaves
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define a cor e a espessura da borda
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(borderWidth));

        // Desenha a borda arredondada
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        g2.dispose(); // Libera os recursos gráficos
    }

    // Sobrescreve o método contains para que os eventos de mouse considerem a forma arredondada
    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            // Cria a forma arredondada se ainda não foi criada ou se o tamanho mudou
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        }
        return shape.contains(x, y); // Verifica se o ponto está dentro da forma
    }

    // Métodos para ajustar a cor e o raio dos cantos (opcional)
    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        setBorder(new EmptyBorder(5, cornerRadius, 5, cornerRadius)); // Ajusta o espaçamento interno
        repaint(); // Redesenha o componente
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint(); // Redesenha o componente
    }
}
