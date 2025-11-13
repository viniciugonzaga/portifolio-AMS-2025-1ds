/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel2 extends JPanel {

    private int cornerRadius;
    private Color backgroundColor;
    private Color borderColor;
    private int borderWidth = 3; // Largura padrão da borda

    public RoundedPanel2(int radius) {
        this(radius, UIManager.getColor("Panel.background"), null);
    }

    public RoundedPanel2(int radius, Color bg) {
        this(radius, bg, null);
    }

    public RoundedPanel2(int radius, Color bg, Color border) {
        super();
        cornerRadius = radius;
        backgroundColor = (bg != null) ? bg : UIManager.getColor("Panel.background");
        borderColor = border;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenha o fundo
        g2.setColor(backgroundColor);
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        // Desenha a borda, se houver
        if (borderColor != null) {
            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(borderWidth));
            g2.draw(new RoundRectangle2D.Double(0, 0, getWidth() - borderWidth, getHeight() - borderWidth, cornerRadius, cornerRadius));
        }

        g2.dispose();
    }

    // Getter e Setter para borderWidth, se necessário
    public void setBorderWidth(int width) {
        this.borderWidth = width;
        repaint();
    }
}