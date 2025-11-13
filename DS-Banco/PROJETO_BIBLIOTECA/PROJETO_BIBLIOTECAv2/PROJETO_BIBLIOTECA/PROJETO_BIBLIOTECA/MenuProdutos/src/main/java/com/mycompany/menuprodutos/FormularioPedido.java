/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;

public class FormularioPedido extends JFrame {

    private ArrayList<ItemCarrinho> carrinho;
    private JTextArea listaPedidosTextArea;
    private JLabel codigoPedidoLabel;
    private JTextField nomeCompletoField;
    private JTextField enderecoField;
    private JFormattedTextField telefoneField;
    private JFormattedTextField cpfField;
    private JTextField emailField;
    private JButton finalizarCompraButton;
    private JLabel precoFinalLabel;
    private DecimalFormat df = new DecimalFormat("R$ #,##0.00");
    private Image logoSite;

    // Paleta de cores do site (adapte conforme as cores reais)
    private Color primaryColor = new Color(139, 69, 19);   // Marrom
    private Color backgroundColor = new Color(245, 245, 220); // Bege claro
    private Color buttonColor = new Color(210, 180, 140);   // Bege escuro/Marrom claro
    private Color buttonTextColor = Color.BLACK;
    
    

   public FormularioPedido(ArrayList<ItemCarrinho> carrinho) {
        this.carrinho = carrinho;
        // Carregar a logo do site
        
        ImageIcon icon = new ImageIcon("src/assets/images/Logo.png");
        setIconImage(icon.getImage());
        inicializarUI();
    }

    private void inicializarUI() {
        setTitle("Seu Pedido");
        setSize(400, 600); // Aumentei mais a altura para a logo e o preço
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        contentPane.setBackground(backgroundColor); // Cor de fundo do painel principal
        add(contentPane);

        // Painel para a logo e título
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setOpaque(false);
        if (logoSite != null) {
            JLabel logoLabel = new JLabel(new ImageIcon(logoSite));
            logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            headerPanel.add(logoLabel);
            headerPanel.add(Box.createVerticalStrut(10));
        }
        JLabel tituloLabel = new JLabel("Seu Pedido");
        tituloLabel.setFont(new Font("Serif", Font.BOLD, 24));
        tituloLabel.setForeground(primaryColor); // Cor do título
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(tituloLabel);
        contentPane.add(headerPanel, BorderLayout.NORTH);

        // Painel central para os detalhes do pedido e formulário
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setOpaque(false); // Para herdar a cor de fundo do contentPane
        contentPane.add(centralPanel, BorderLayout.CENTER);

        // Lista de Pedidos (em forma de escada)
        listaPedidosTextArea = new JTextArea();
        listaPedidosTextArea.setEditable(false);
        listaPedidosTextArea.setBackground(backgroundColor);
        listaPedidosTextArea.setForeground(primaryColor);
        StringBuilder listaPedidos = new StringBuilder("Itens do Pedido:\n");
        for (int i = 0; i < carrinho.size(); i++) {
            ItemCarrinho item = carrinho.get(i);
            for (int j = 0; j < i; j++) {
                listaPedidos.append("  "); // Indentação para efeito de escada
            }
            listaPedidos.append("- ").append(item.getProduto().getDescricao()).append(" (x").append(item.getQuantidade()).append(")\n");
        }
        listaPedidosTextArea.setText(listaPedidos.toString());
        centralPanel.add(new JScrollPane(listaPedidosTextArea));
        centralPanel.add(Box.createVerticalStrut(10));

        // Código do Pedido
        String codigoPedido = gerarCodigoPedido();
        codigoPedidoLabel = new JLabel("Código do Pedido: " + codigoPedido);
        codigoPedidoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        codigoPedidoLabel.setForeground(primaryColor); // Cor do código do pedido
        centralPanel.add(codigoPedidoLabel);
        centralPanel.add(Box.createVerticalStrut(15));

        // Formulário
        JPanel formularioPanel = new JPanel(new GridLayout(5, 2, 5, 10));
        formularioPanel.setOpaque(false); // Para herdar a cor de fundo
        centralPanel.add(formularioPanel);

        JLabel nomeLabel = new JLabel("Nome Completo:");
        nomeLabel.setForeground(primaryColor);
        formularioPanel.add(nomeLabel);
        nomeCompletoField = new JTextField(20);
        formularioPanel.add(nomeCompletoField);

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoLabel.setForeground(primaryColor);
        formularioPanel.add(enderecoLabel);
        enderecoField = new JTextField(20);
        formularioPanel.add(enderecoField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setForeground(primaryColor);
        formularioPanel.add(telefoneLabel);
        try {
            MaskFormatter telefoneMask = new MaskFormatter("(##) #####-####");
            telefoneMask.setPlaceholderCharacter('_');
            telefoneField = new JFormattedTextField(telefoneMask);
        } catch (ParseException e) {
            telefoneField = new JFormattedTextField();
        }
        formularioPanel.add(telefoneField);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setForeground(primaryColor);
        formularioPanel.add(cpfLabel);
        try {
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.setPlaceholderCharacter('_');
            cpfField = new JFormattedTextField(cpfMask);
        } catch (ParseException e) {
            cpfField = new JFormattedTextField();
        }
        formularioPanel.add(cpfField);

        JLabel emailLabel = new JLabel("Email (gmail):");
        emailLabel.setForeground(primaryColor);
        formularioPanel.add(emailLabel);
        emailField = new JTextField(20);
        formularioPanel.add(emailField);

        centralPanel.add(Box.createVerticalStrut(20));

        // Painel para o preço final e botão
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setOpaque(false);

        // Preço Final
        double precoFinal = calcularPrecoFinal();
        precoFinalLabel = new JLabel("Preço Total: " + df.format(precoFinal));
        precoFinalLabel.setFont(new Font("Serif", Font.BOLD, 18));
        precoFinalLabel.setForeground(primaryColor); // Cor do preço final
        precoFinalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(precoFinalLabel);
        bottomPanel.add(Box.createVerticalStrut(10));

        // Botão Finalizar Compra
        finalizarCompraButton = new JButton("Finalizar Compra");
        finalizarCompraButton.setEnabled(false); // Desabilitado inicialmente
        finalizarCompraButton.setBackground(buttonColor); // Cor de fundo do botão
        finalizarCompraButton.setForeground(buttonTextColor); // Cor do texto do botão
        finalizarCompraButton.setFont(new Font("Serif", Font.BOLD, 16));
        finalizarCompraButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        finalizarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nomeCompletoField.getText().trim().isEmpty() || enderecoField.getText().trim().isEmpty() ||
                        telefoneField.getText().trim().isEmpty() || cpfField.getText().trim().isEmpty() ||
                        !emailField.getText().trim().matches("[a-zA-Z0-9._%+-]+@gmail\\.com$")) {
                    JOptionPane.showMessageDialog(FormularioPedido.this, "Por favor, preencha todos os campos corretamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
               // Aqui chama o método de envio do email:
        String destinatario = emailField.getText().trim();
        EmailSender.enviarEmail(destinatario);  // Envia o e-mail


                JOptionPane.showMessageDialog(FormularioPedido.this, "Seu QRCODE para efetuar o pagamento foi gerado, verifique seu e-mail e realize o pagamento para finalizar a compra !", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Fecha o formulário após a compra
            }
        });
        bottomPanel.add(finalizarCompraButton);

        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        // Adicionar listener para habilitar/desabilitar o botão
        ActionListener verificarCamposListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean camposPreenchidos = !nomeCompletoField.getText().trim().isEmpty() &&
                                           !enderecoField.getText().trim().isEmpty() &&
                                           !telefoneField.getText().trim().contains("_") &&
                                           !cpfField.getText().trim().contains("_") &&
                                           emailField.getText().trim().matches("[a-zA-Z0-9._%+-]+@gmail\\.com$");
                finalizarCompraButton.setEnabled(camposPreenchidos);
            }
        };

        nomeCompletoField.addActionListener(verificarCamposListener);
        enderecoField.addActionListener(verificarCamposListener);
        telefoneField.addActionListener(verificarCamposListener);
        cpfField.addActionListener(verificarCamposListener);
        emailField.addActionListener(verificarCamposListener);

        // Adicionar listeners de mudança de texto para JFormattedTextFields e JTextFields
        nomeCompletoField.getDocument().addDocumentListener(new DocumentChangeListener(verificarCamposListener));
        enderecoField.getDocument().addDocumentListener(new DocumentChangeListener(verificarCamposListener));
        telefoneField.getDocument().addDocumentListener(new DocumentChangeListener(verificarCamposListener));
        cpfField.getDocument().addDocumentListener(new DocumentChangeListener(verificarCamposListener));
        emailField.getDocument().addDocumentListener(new DocumentChangeListener(verificarCamposListener));

        setVisible(true);
    }

    private double calcularPrecoFinal() {
        double total = 0;
        for (ItemCarrinho item : carrinho) {
            total += item.calcularPrecoTotal();
        }
        return total;
    }

    private String gerarCodigoPedido() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder codigo = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            codigo.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return codigo.toString();
    }

    // Classe auxiliar para ouvir mudanças no documento dos JTextFields
    private static class DocumentChangeListener implements javax.swing.event.DocumentListener {
        private ActionListener actionListener;

        public DocumentChangeListener(ActionListener actionListener) {
            this.actionListener = actionListener;
        }

        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            actionListener.actionPerformed(new ActionEvent(e.getDocument(), e.getOffset(), "insert"));
        }

        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            actionListener.actionPerformed(new ActionEvent(e.getDocument(), e.getOffset(), "remove"));
        }

        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            // Não necessário para campos de texto simples
        }
    }
}