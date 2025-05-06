/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D; // Para desenhar formas customizadas

// Painel personalizado para exibir a logo/título e a forma colorida abaixo
public class LogoPanel extends JPanel {

    // Cor da forma (ajustada para um marrom mais escuro que a imagem sugeriu)
    private Color shapeColor = new Color(100, 65, 30);
    private JLabel tituloLabel; // Referência ao JLabel do título

    public LogoPanel(JLabel tituloLabel) {
        this.tituloLabel = tituloLabel;
        // Usamos BorderLayout para posicionar o JLabel do título
        setLayout(new BorderLayout());
        setOpaque(false); // Torna o painel transparente para que a forma desenhada seja visível
        setBackground(new Color(139, 90, 43)); // Cor de fundo do cabeçalho
        add(tituloLabel, BorderLayout.CENTER); // Adiciona o JLabel do título ao centro do painel
        setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5)); // Espaçamento interno diminuído
    }

    // Sobrescreve o método paintComponent para desenhar a forma colorida
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Desenha o fundo do painel (transparente)

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define a cor da forma
        g2.setColor(shapeColor);

        // Calcula as coordenadas para a forma abaixo do texto
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int tituloHeight = tituloLabel.getHeight(); // Altura do JLabel do título

        // Cria um caminho para desenhar a forma customizada (ajustado para ser menor)
        Path2D.Double shape = new Path2D.Double();
        // Começa no canto inferior esquerdo do painel
        shape.moveTo(0, panelHeight);
        // Vai até o canto inferior direito do painel
        shape.lineTo(panelWidth, panelHeight);
        // Vai até o canto inferior direito da área do título (onde a forma começa na imagem)
        shape.lineTo(panelWidth, tituloHeight);
        // Vai até um ponto no centro inferior do painel (o pico do triângulo)
        // Ajustado para que o pico fique mais centralizado horizontalmente e um pouco abaixo do painel
        shape.lineTo(panelWidth / 2.0, panelHeight + 10); // Ajuste +10 para a ponta ir um pouco menos para baixo
        // Vai até o canto inferior esquerdo da área do título
        shape.lineTo(0, tituloHeight);
        shape.closePath(); // Fecha a forma

        // Preenche a forma com a cor definida
        g2.fill(shape);

        g2.dispose(); // Libera os recursos gráficos
    }

    // Sobrescreve getPreferredSize para garantir que o painel tenha altura suficiente
    @Override
    public Dimension getPreferredSize() {
        // Altura preferencial é a altura do JLabel do título mais um espaço menor para a forma
        Dimension labelSize = tituloLabel.getPreferredSize();
        // Ajuste a altura total para acomodar a forma desenhada, tornando-a menor
        return new Dimension(labelSize.width + 10, labelSize.height + 15); // Ajuste 15 para o espaço da forma menor
    }

     @Override
    public Dimension getMinimumSize() {
         Dimension labelSize = tituloLabel.getMinimumSize();
        return new Dimension(labelSize.width, labelSize.height + 10); // Ajuste 10 para o espaço da forma menor
    }

     @Override
    public Dimension getMaximumSize() {
         Dimension labelSize = tituloLabel.getMaximumSize();
        return new Dimension(Integer.MAX_VALUE, labelSize.height + 20); // Ajuste 20 para o espaço da forma menor
    }


    // Métodos para ajustar a cor da forma (opcional)
    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
        repaint(); // Redesenha o componente
    }
}

