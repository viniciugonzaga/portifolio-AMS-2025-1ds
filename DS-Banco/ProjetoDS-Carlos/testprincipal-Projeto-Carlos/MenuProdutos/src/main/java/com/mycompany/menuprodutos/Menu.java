/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Menu extends JFrame {

    private Produto produto;
    private JLabel quantidadeLabel;
    private JLabel precoTotalLabel;
    private int quantidade = 1;
    private DecimalFormat df = new DecimalFormat("R$ #,##0.00");
    private int borderRadius = 20; // Raio dos cantos (o mesmo dos cards)
    private Color backgroundColor = new Color(245, 245, 220); // Bege claro (Fundo do menu)
    private Color borderColor = new Color(205, 133, 63); // Marrom claro (Cor da borda dos cards)
    private Color primaryColor = new Color(139, 69, 19); // Marrom sela (Cor primária/Logo)
    private Color secondaryColor = new Color(210, 180, 140); // Marrom claro (Botões)
    private Font primaryFont = new Font("Serif", Font.PLAIN, 16);
    private Font boldFont = new Font("Serif", Font.BOLD, 18);

    public Menu(Produto produto) {
        this.produto = produto;
        setTitle("Detalhes da Compra");
        setUndecorated(true); // Remove a barra de título padrão
        setBackground(new Color(0, 0, 0, 0)); // Torna o fundo da janela transparente
        setSize(760, 600); // Largura inicial e altura reduzida
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout()); // Layout do JFrame

        // Painel para o título da categoria e o botão de sair
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.setBorder(new EmptyBorder(10, 25, 5, 25)); // Ajustei as margens do header

        // --- Título da Categoria ---
        JLabel categoriaLabel = new JLabel();
        categoriaLabel.setFont(new Font("Serif", Font.BOLD, 26));
        categoriaLabel.setForeground(primaryColor);
        categoriaLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto
        if (produto instanceof Livro) {
            categoriaLabel.setText("Livro");
        } else if (produto instanceof Cd) {
            categoriaLabel.setText("CD");
        } else if (produto instanceof Dvd) {
            categoriaLabel.setText("DVD");
        }
        headerPanel.add(categoriaLabel, BorderLayout.CENTER);

        // --- Botão de Sair ---
        JButton sairButton = new JButton("X");
        sairButton.setFont(new Font("Arial", Font.BOLD, 18));
        sairButton.setForeground(Color.BLACK);
        sairButton.setBackground(secondaryColor);
        sairButton.setFocusPainted(false);
        sairButton.setBorder(new EmptyBorder(5, 10, 5, 10));
        sairButton.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o "X" dentro do botão
        sairButton.setPreferredSize(new Dimension(40, 30)); // Mantém o tamanho preferencial
        sairButton.setMinimumSize(new Dimension(40, 30));
        sairButton.setMaximumSize(new Dimension(40, 30));

        JPanel sairButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0)); // Painel para alinhar à direita
        sairButtonPanel.setOpaque(false);
        sairButtonPanel.add(sairButton);

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela do menu
            }
        });
        headerPanel.add(sairButtonPanel, BorderLayout.EAST);

        // Cria o RoundedPanel para o fundo e a borda
        RoundedPanel2 roundedMenuPanel2 = new RoundedPanel2(borderRadius, backgroundColor, borderColor);
        roundedMenuPanel2.setLayout(new BoxLayout(roundedMenuPanel2, BoxLayout.Y_AXIS));
        roundedMenuPanel2.setBorder(new EmptyBorder(0, 0, 25, 0)); // Margem inferior para o conteúdo

        roundedMenuPanel2.add(headerPanel); // Adiciona o headerPanel (título e sair)
        roundedMenuPanel2.add(Box.createVerticalStrut(10)); // Espaçamento após o header

        // --- Capa do Produto ---
        JLabel imagemLabel = new JLabel();
        imagemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        try {
            ImageIcon icon = new ImageIcon(produto.getCaminhoImagem());
            Image scaledImage = icon.getImage().getScaledInstance(180, 240, Image.SCALE_SMOOTH);
            imagemLabel.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
            imagemLabel.setText("Sem imagem");
            imagemLabel.setHorizontalAlignment(SwingConstants.CENTER);
        }
        roundedMenuPanel2.add(imagemLabel);
        roundedMenuPanel2.add(Box.createVerticalStrut(20));

        // --- Título do Produto ---
        JLabel tituloLabel = new JLabel(produto.getDescricao());
        tituloLabel.setFont(new Font("Serif", Font.BOLD, 22));
        tituloLabel.setForeground(primaryColor);
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        roundedMenuPanel2.add(tituloLabel);
        roundedMenuPanel2.add(Box.createVerticalStrut(10));

        // --- Detalhes do Produto ---
        JPanel detalhesPanel = new JPanel();
        detalhesPanel.setLayout(new BoxLayout(detalhesPanel, BoxLayout.Y_AXIS));
        detalhesPanel.setOpaque(false);
        detalhesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (produto instanceof Livro) {
            Livro livro = (Livro) produto;
            detalhesPanel.add(createDetailLabel("Autor: " + livro.getAutor()));
            detalhesPanel.add(createDetailLabel("Editora: " + livro.getEditora()));
            detalhesPanel.add(createDetailLabel("Edição: " + livro.getEdicao()));
        } else if (produto instanceof Cd) {
            Cd cd = (Cd) produto;
            detalhesPanel.add(createDetailLabel("Artista: " + cd.getArtista()));
            detalhesPanel.add(createDetailLabel("Gravadora: " + cd.getGravadora()));
            detalhesPanel.add(createDetailLabel("País: " + cd.getPaisDeOrigem()));
        } else if (produto instanceof Dvd) {
            Dvd dvd = (Dvd) produto;
            detalhesPanel.add(createDetailLabel("Diretor: " + dvd.getDiretor()));
            detalhesPanel.add(createDetailLabel("Duração: " + dvd.getDuracao()));
            detalhesPanel.add(createDetailLabel("Censura: " + dvd.getCensura()));
        }
        roundedMenuPanel2.add(detalhesPanel);
        roundedMenuPanel2.add(Box.createVerticalStrut(15));

        // --- Descrição do Produto ---
        JTextPane descricaoTextPane = new JTextPane();
        descricaoTextPane.setText(produto.getDescricaoDetalhada());
        descricaoTextPane.setEditable(false);
        descricaoTextPane.setBackground(new Color(255, 255, 255));
        descricaoTextPane.setFont(primaryFont);
        descricaoTextPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borderColor, 2), // Borda
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // Espaçamento interno
        ));

        StyledDocument doc = descricaoTextPane.getStyledDocument();
        SimpleAttributeSet centerAlign = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerAlign, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), centerAlign, false);

        JScrollPane scrollPaneDescricao = new JScrollPane(descricaoTextPane);
        scrollPaneDescricao.setBorder(BorderFactory.createEmptyBorder());
        // Tenta definir uma largura máxima para o JScrollPane
        scrollPaneDescricao.setMaximumSize(new Dimension(getWidth() - 50, Short.MAX_VALUE));

        roundedMenuPanel2.add(scrollPaneDescricao);
        roundedMenuPanel2.add(Box.createVerticalStrut(20));

        // --- Preço Unitário ---
        JLabel precoUnitarioLabel = new JLabel("Preço Unitário: " + df.format(produto.getPreco()));
        precoUnitarioLabel.setFont(boldFont);
        precoUnitarioLabel.setForeground(primaryColor);
        precoUnitarioLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        roundedMenuPanel2.add(precoUnitarioLabel);
        roundedMenuPanel2.add(Box.createVerticalStrut(15));

        // --- Seletor de Quantidade ---
        JPanel quantidadePanel = new JPanel(new GridLayout(1, 3, 5, 0));
        quantidadePanel.setOpaque(false);

        // Painel para o botão de menos
        JPanel menosPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        menosPanel.setOpaque(false);
        menosPanel.setPreferredSize(new Dimension(60, 50));
        JButton menosButton = createQuantityButton("-");
        menosPanel.add(menosButton);

        // Painel para o label de quantidade
        JPanel quantidadeLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        quantidadeLabelPanel.setOpaque(false);
        quantidadeLabel = new JLabel(String.valueOf(quantidade));
        quantidadeLabel.setFont(boldFont);
        quantidadeLabelPanel.setPreferredSize(new Dimension(60, 50));
        quantidadeLabelPanel.add(quantidadeLabel);

        // Painel para o botão de mais
        JPanel maisPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        maisPanel.setOpaque(false);
        maisPanel.setPreferredSize(new Dimension(60, 50));
        JButton maisButton = createQuantityButton("+");
        maisPanel.add(maisButton);

        menosButton.addActionListener(e -> {
            if (quantidade > 1) {
                quantidade--;
                quantidadeLabel.setText(String.valueOf(quantidade));
                atualizarPrecoTotal();
            }
        });
        maisButton.addActionListener(e -> {
            quantidade++;
            quantidadeLabel.setText(String.valueOf(quantidade));
            atualizarPrecoTotal();
        });

        quantidadePanel.add(menosPanel);
        quantidadePanel.add(quantidadeLabelPanel);
        quantidadePanel.add(maisPanel);

        roundedMenuPanel2.add(quantidadePanel);
        roundedMenuPanel2.add(Box.createVerticalStrut(20));

        // --- Preço Total ---
        precoTotalLabel = new JLabel("Preço Total: " + df.format(produto.getPreco()));
        precoTotalLabel.setFont(new Font("Serif", Font.BOLD, 20));
        precoTotalLabel.setForeground(primaryColor);
        precoTotalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        roundedMenuPanel2.add(precoTotalLabel);
        roundedMenuPanel2.add(Box.createVerticalStrut(30));

        // --- Botão "Adicionar ao carrinho" ---
        JButton adicionarCarrinhoButton = new JButton("Adicionar ao carrinho");
        adicionarCarrinhoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        adicionarCarrinhoButton.setBackground(secondaryColor);
        adicionarCarrinhoButton.setForeground(Color.BLACK);
        adicionarCarrinhoButton.setFont(boldFont);
        adicionarCarrinhoButton.setFocusPainted(false);
        adicionarCarrinhoButton.setBorder(new EmptyBorder(10, 30, 10, 30));
        adicionarCarrinhoButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(Menu.this, "Produto adicionado ao carrinho (quantidade: " + quantidade + ")");
            dispose();
        });
        roundedMenuPanel2.add(adicionarCarrinhoButton);

        // Adiciona o RoundedPanel ao JScrollPane
        JScrollPane scrollPaneMenu = new JScrollPane(roundedMenuPanel2);
        scrollPaneMenu.setBorder(BorderFactory.createEmptyBorder());
        scrollPaneMenu.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneMenu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPaneMenu, BorderLayout.CENTER);
    }

    private JLabel createDetailLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(primaryFont);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private JButton createQuantityButton(String text) {
        JButton button = new JButton(text);
        button.setFont(boldFont);
        button.setPreferredSize(new Dimension(60, 50));
        button.setFocusPainted(false);
        return button;
    }

    private void atualizarPrecoTotal() {
        double precoUnitario = produto.getPreco();
        double precoTotal = precoUnitario * quantidade;
        precoTotalLabel.setText("Preço Total: " + df.format(precoTotal));
    }
}