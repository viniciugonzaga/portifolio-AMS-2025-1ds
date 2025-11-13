/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

// MenuDoCarrinho.java
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.net.URL;

public class MenuDoCarrinho extends JFrame {

    private ArrayList<ItemCarrinho> carrinho;
    private JList<String> listaItensJList;
    private DefaultListModel<String> listModel;
    private JLabel precoTotalGeralLabel;
    private DecimalFormat df = new DecimalFormat("R$ #,##0.00");
    private Color primaryColor = new Color(139, 69, 19);
    private Color backgroundColor = new Color(245, 245, 220);
    private Color borderColor = new Color(205, 133, 63); // Cor da borda (a mesma do Menu)
    private int borderRadius = 20;
    private Image logo;

    // Construtor que recebe a logo (preferencial)
    public MenuDoCarrinho(ArrayList<ItemCarrinho> carrinho, Image logo) {
        this(carrinho); // Chama o construtor principal
        this.logo = logo;
        inicializarUI();
    }

    // Construtor principal que não recebe a logo
    public MenuDoCarrinho(ArrayList<ItemCarrinho> carrinho) {
        this.carrinho = carrinho;
        // Tenta carregar a logo internamente
        URL logoUrl = getClass().getResource("src/assets/images/Logo.png");
        if (logoUrl != null) {
            ImageIcon logoIcon = new ImageIcon(logoUrl);
            this.logo = logoIcon.getImage();
        } else {
            System.err.println("Erro ao carregar a logo interna para o carrinho.");
        }
        inicializarUI();
    }

    private void inicializarUI() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setTitle("Carrinho de Compras");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel principal com BoxLayout vertical
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15)); // Margens internas

        // Painel para o título e logo
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        headerPanel.setOpaque(false);
        if (this.logo != null) {
            JLabel logoLabel = new JLabel(new ImageIcon(this.logo.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
            headerPanel.add(logoLabel);
            headerPanel.add(Box.createHorizontalStrut(10));
        }
        JLabel tituloLabel = new JLabel("Carrinho de Compras");
        tituloLabel.setFont(new Font("Serif", Font.BOLD, 20));
        tituloLabel.setForeground(primaryColor);
        headerPanel.add(tituloLabel);

        JLabel lblFechar = new JLabel("X");
        lblFechar.setFont(new Font("Arial", Font.BOLD, 18));
        lblFechar.setForeground(Color.RED);
        lblFechar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose(); // Fecha a janela ao clicar
            }
        });
        headerPanel.add(lblFechar); // Adiciona ao headerPanel para ficar no canto

        mainPanel.add(headerPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        listModel = new DefaultListModel<>();
        listaItensJList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaItensJList);
        mainPanel.add(scrollPane);
        mainPanel.add(Box.createVerticalStrut(10));

        precoTotalGeralLabel = new JLabel("Preço Total: R$ 0,00");
        precoTotalGeralLabel.setFont(new Font("Serif", Font.BOLD, 16));
        precoTotalGeralLabel.setForeground(primaryColor);
        mainPanel.add(precoTotalGeralLabel);
        mainPanel.add(Box.createVerticalStrut(15));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false);

        JButton btnComprar = createStyledButton("Comprar");
        btnComprar.addActionListener(e -> abrirPaginaPedido());
        buttonPanel.add(btnComprar);

        JButton btnRetirar = createStyledButton("Retirar do Carrinho");
        btnRetirar.addActionListener(e -> retirarItemSelecionado());
        buttonPanel.add(btnRetirar);

        mainPanel.add(buttonPanel);

        atualizarListaItens();

        // Adiciona o painel principal ao RoundedPanel3
        RoundedPanel3 roundedCarrinhoPanel = new RoundedPanel3(borderRadius, backgroundColor, borderColor);
        roundedCarrinhoPanel.setLayout(new BorderLayout());
        roundedCarrinhoPanel.add(mainPanel, BorderLayout.CENTER);
        roundedCarrinhoPanel.setBorder(new EmptyBorder(15, 15, 15, 15)); // Margens ao redor do conteúdo

        add(roundedCarrinhoPanel, BorderLayout.CENTER);

        // Define a forma arredondada para a janela
        Shape roundedShape = RoundedWindow.createRoundedWindowShape(getWidth(), getHeight(), borderRadius);
        try {
            Class<?> awtUtilitiesClass = Class.forName("com.sun.awt.AWTUtilities");
            java.lang.reflect.Method setWindowShapeMethod = awtUtilitiesClass.getMethod("setWindowShape", java.awt.Window.class, java.awt.Shape.class);
            setWindowShapeMethod.invoke(this, roundedShape);
        } catch (Exception e) {
            System.err.println("AWTUtilities não disponível ou método setWindowShape não encontrado.");
            // Fallback para outras formas de tentar arredondar (pode ser mais limitado)
            // Isso pode envolver a criação de uma máscara ou outras técnicas.
            // Para simplicidade, vamos omitir um fallback completo aqui,
            // mas saiba que o arredondamento pode não funcionar em VMs sem AWTUtilities.
        }

        // Forçar atualização do layout
        revalidate();
        repaint();
    }

    private void abrirPaginaPedido() {
        new FormularioPedido(carrinho);
    }

    private String gerarCodigoPedido() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder codigo = new StringBuilder();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < 10; i++) {
            codigo.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return codigo.toString();
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 16));
        button.setBackground(new Color(210, 180, 140));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(8, 15, 8, 15));
        return button;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void setVisible(boolean b) {
        // Recalcula a forma ao tornar a janela visível (para lidar com redimensionamento inicial)
        if (b) {
            Shape roundedShape = RoundedWindow.createRoundedWindowShape(getWidth(), getHeight(), borderRadius);
           try {
    Class<?> awtUtilitiesClass = Class.forName("com.sun.awt.AWTUtilities");
    java.lang.reflect.Method setWindowShapeMethod = awtUtilitiesClass.getMethod("setWindowShape", java.awt.Window.class, java.awt.Shape.class);
    setWindowShapeMethod.invoke(this, roundedShape); // Linha corrigida
} catch (Exception e) {
    System.err.println("AWTUtilities não disponível ou método setWindowShape não encontrado.");
    // ... restante do bloco catch ...
}
        }
        super.setVisible(b);
    }

    private void atualizarListaItens() {
        listModel.clear();
        for (ItemCarrinho item : carrinho) {
            String nomeProduto = item.getProduto().getDescricao();
            int quantidade = item.getQuantidade();
            double precoTotalItem = item.calcularPrecoTotal();
            listModel.addElement(nomeProduto + " (x" + quantidade + ") - " + df.format(precoTotalItem));
        }
        precoTotalGeralLabel.setText("Preço Total: " + df.format(calcularPrecoTotalGeral()));
    }

    private double calcularPrecoTotalGeral() {
        double total = 0;
        for (ItemCarrinho item : carrinho) {
            total += item.calcularPrecoTotal();
        }
        return total;
    }

    private void retirarItemSelecionado() {
        int selectedIndex = listaItensJList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < carrinho.size()) {
            carrinho.remove(selectedIndex);
            atualizarListaItens();
            JOptionPane.showMessageDialog(this, "Item retirado do carrinho.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item para retirar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}

