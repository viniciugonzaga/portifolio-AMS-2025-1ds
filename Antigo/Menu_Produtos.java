/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections; // Importar para embaralhar
import java.util.Random; // Importar para gerar aleatoriedade
import java.text.DecimalFormat;
import javax.swing.event.DocumentEvent; // Importar para DocumentListener
import javax.swing.event.DocumentListener; // Importar para DocumentListener
import java.net.URL; // Importar para carregar recursos
import javax.imageio.ImageIO; // Importar para verificar o carregamento da imagem

public class Menu_Produtos extends JFrame {

    private JPanel produtosPanelContainer; // Container que usará FlowLayout
    private JPanel produtosGridPanel; // Painel que usará GridLayout para os cards
    private JScrollPane scrollPane;
    private ArrayList<Produto> produtos; // Lista principal de todos os produtos

    private RoundedTextField campoPesquisa; // Campo de texto para pesquisa (agora é RoundedTextField)

    private String categoriaAtual = "HOME"; // Armazena a categoria atualmente selecionada

    public Menu_Produtos() {
        setTitle("Livraria Entre Palavras");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        produtos = new ArrayList<>();
        carregarProdutos(); // Carrega os dados dos produtos

        // Cabeçalho com o novo layout
        JPanel header = criarHeader();
        add(header, BorderLayout.NORTH);

        // Container para os cards que usará FlowLayout para centralizar e respeitar tamanho
        produtosPanelContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Espaçamento entre os cards
        produtosPanelContainer.setBackground(new Color(244, 240, 230)); // Mesma cor de fundo

        // Painel que conterá os cards em GridLayout
        produtosGridPanel = new JPanel(new GridLayout(0, 5, 20, 20)); // 5 colunas, espaçamento
        produtosGridPanel.setBackground(new Color(244, 240, 230)); // Mesma cor de fundo
        produtosGridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaçamento interno

        // Adiciona o painel de grid ao container FlowLayout
        produtosPanelContainer.add(produtosGridPanel);

        // Cria o scroll pane envolvendo o container FlowLayout
        scrollPane = new JScrollPane(produtosPanelContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Não precisa de barra horizontal

        // Ajusta a velocidade da barra de rolagem
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Aumenta a velocidade de rolagem por "unidade"
        scrollPane.getVerticalScrollBar().setBlockIncrement(160); // Aumenta a velocidade de rolagem por "bloqueio"

        add(scrollPane, BorderLayout.CENTER);

        // Carrega os produtos iniciais na tela HOME
        atualizarExibicaoProdutos(); // Chama o método que agora considera a pesquisa e categoria
    }

    // Cria o painel do cabeçalho com o layout desejado (duas linhas)
    private JPanel criarHeader() {
        JPanel panel = new JPanel();
        // --- MUDANÇA DE COR AQUI ---
        Color navbarColor = new Color(115, 103, 47); // Cor do nav-bar (RGBA(115, 103, 47, 1))
        panel.setBackground(navbarColor); // Cor de fundo do painel principal do cabeçalho
        // --- FIM MUDANÇA DE COR ---

        // Usa BoxLayout.Y_AXIS para empilhar a linha superior (logo/pesquisa/sair) e a linha inferior (botões)
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaçamento externo

        // --- Linha Superior (Logo, Pesquisa, Sair) ---
        JPanel topRowPanel = new JPanel(new BorderLayout());
        // --- MUDANÇA DE COR AQUI ---
        topRowPanel.setBackground(navbarColor); // Cor de fundo da linha superior
        // --- FIM MUDANÇA DE COR ---
        // Garante que esta linha não se estique verticalmente mais do que o necessário
        topRowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, topRowPanel.getPreferredSize().height));

        // Painel da Esquerda (Logo Imagem com a forma colorida)
        JLabel logoLabel; // JLabel que conterá a logo (imagem ou texto fallback)

       // --- CARREGAMENTO DA IMAGEM AQUI: Caminho e nome do arquivo corrigidos ---
        String imagePath = "C:\\Users\\Vinicius\\OneDrive\\Documentos\\NetBeansProjects\\MenuProdutos\\src\\Imagens/1.png"; // Caminho para a pasta "Imagens" e nome do arquivo "1.png"
        System.out.println("DEBUG: Tentando carregar imagem do caminho: " + imagePath); // Debug
        ImageIcon logoIcon = null;
        URL imageURL = getClass().getResource(imagePath);

        if (imageURL != null) {
            System.out.println("DEBUG: URL da imagem encontrada: " + imageURL); // Debug
            try {
                // Tenta criar o ImageIcon
                logoIcon = new ImageIcon(imageURL);
                // Verifica se a imagem foi carregada corretamente (largura > 0)
                if (logoIcon.getIconWidth() > 0) {
                    System.out.println("DEBUG: Imagem carregada com sucesso. Dimensões: " + logoIcon.getIconWidth() + "x" + logoIcon.getIconHeight()); // Debug
                    // Opcional: Redimensionar a imagem se necessário (ajuste os valores)
                    // Image img = logoIcon.getImage();
                    // Image newImg = img.getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH); // Exemplo: 100x50 pixels
                    // logoIcon = new ImageIcon(newImg);
                    logoLabel = new JLabel(logoIcon); // Cria JLabel com a imagem
                     System.out.println("DEBUG: JLabel criado com ImageIcon."); // Debug
                } else {
                     System.err.println("DEBUG: ImageIcon criado, mas imagem parece vazia ou inválida."); // Debug
                     // Fallback se ImageIcon não carregar corretamente
                     logoLabel = new JLabel("<html>LEP<br>Livraria Entre Palavras</html>", SwingConstants.LEFT);
                     logoLabel.setFont(new Font("Serif", Font.BOLD, 20)); // Tamanho menor para o fallback
                     logoLabel.setForeground(Color.WHITE);
                     System.out.println("DEBUG: Usando JLabel de texto fallback (ImageIcon vazio)."); // Debug
                }
            } catch (Exception e) {
                e.printStackTrace();
                 System.err.println("DEBUG: Erro ao criar ImageIcon: " + e.getMessage()); // Debug
                 // Fallback em caso de exceção ao criar ImageIcon
                 logoLabel = new JLabel("<html>LEP<br>Livraria Entre Palavras</html>", SwingConstants.LEFT);
                 logoLabel.setFont(new Font("Serif", Font.BOLD, 20)); // Tamanho menor para o fallback
                 logoLabel.setForeground(Color.WHITE);
                 System.out.println("DEBUG: Usando JLabel de texto fallback (Erro ImageIcon)."); // Debug
            }
        } else {
            System.err.println("DEBUG: URL da imagem não encontrada: " + imagePath); // Debug
            // Fallback: Cria um JLabel de texto se a URL não for encontrada
            logoLabel = new JLabel("<html>LEP<br>Livraria Entre Palavras</html>", SwingConstants.LEFT);
            logoLabel.setFont(new Font("Serif", Font.BOLD, 20)); // Tamanho menor para o fallback
            logoLabel.setForeground(Color.WHITE);
            System.out.println("DEBUG: Usando JLabel de texto fallback (URL não encontrada)."); // Debug;
        }
        // --- FIM CARREGAMENTO DA IMAGEM ---

        // Cria uma instância do LogoPanel, passando o JLabel (imagem ou texto)
        LogoPanel logoPanel = new LogoPanel(logoLabel); // Usa o painel customizado para a logo
        // --- MUDANÇA DE COR AQUI ---
        logoPanel.setBackground(navbarColor); // Cor de fundo do LogoPanel
        // --- FIM MUDANÇA DE COR ---
        topRowPanel.add(logoPanel, BorderLayout.WEST); // Adiciona o LogoPanel à esquerda

        // Painel Central (Pesquisa)
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centraliza o conteúdo
        // --- MUDANÇA DE COR AQUI ---
        searchPanel.setBackground(navbarColor); // Cor de fundo do painel de pesquisa
        // --- FIM MUDANÇA DE COR ---
        searchPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinha o searchPanel ao centro horizontalmente

        // --- AJUSTE DE TAMANHO E CENTRALIZAÇÃO DA BARRA DE PESQUISA ---
        // Adiciona um espaço horizontal ANTES do campo de pesquisa (se necessário para afinar a centralização)
        // searchPanel.add(Box.createHorizontalStrut(50)); // Mantido comentado da versão anterior

        campoPesquisa = new RoundedTextField(40); // Usa o campo de texto arredondado
        campoPesquisa.setFont(new Font("Serif", Font.PLAIN, 18));
        // Definindo um tamanho preferencial maior para influenciar o FlowLayout
        campoPesquisa.setPreferredSize(new Dimension(350, 35)); // Ajuste os valores conforme necessário
        campoPesquisa.setMaximumSize(new Dimension(400, 40)); // Ajuste os valores conforme necessário

        campoPesquisa.setBorderColor(Color.BLACK);
        campoPesquisa.setCornerRadius(20);

        searchPanel.add(campoPesquisa);
        JLabel lupaIcon = new JLabel("🔍");
        lupaIcon.setFont(new Font("Serif", Font.PLAIN, 20));
        searchPanel.add(lupaIcon);

        // --- ADICIONANDO MAIS ESPAÇO HORIZONTAL APÓS A LUPA AQUI ---
        // Aumentando o valor do espaço fixo existente
        searchPanel.add(Box.createHorizontalStrut(105)); // Valor aumentado para 250 pixels (ajuste conforme necessário)
        // --- FIM DO AJUSTE ---


        // Adiciona DocumentListener ao campo de pesquisa
        campoPesquisa.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                atualizarExibicaoProdutos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                atualizarExibicaoProdutos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                atualizarExibicaoProdutos();
            }
        });
        topRowPanel.add(searchPanel, BorderLayout.CENTER); // Adiciona o painel de pesquisa ao centro

        // Painel da Direita (Botão Sair)
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Alinha à direita
        // --- MUDANÇA DE COR AQUI ---
        rightPanel.setBackground(navbarColor); // Cor de fundo do painel da direita
        // --- FIM MUDANÇA DE COR ---

        JButton btnSair = new JButton("Sair");
        btnSair.setFocusPainted(false);
        btnSair.setBackground(new Color(200, 0, 0));
        btnSair.setForeground(Color.WHITE);
        btnSair.setFont(new Font("Serif", Font.BOLD, 16));
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        rightPanel.add(btnSair); // Adiciona o botão Sair
        topRowPanel.add(rightPanel, BorderLayout.EAST); // Adiciona o painel da direita à direita

        // Adiciona a linha superior ao painel principal do header
        panel.add(topRowPanel);

        // --- Linha Inferior (Botões de Navegação) ---
        JPanel bottomRowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centraliza os botões
        // --- MUDANÇA DE COR AQUI ---
        bottomRowPanel.setBackground(navbarColor); // Cor de fundo da linha inferior
        // --- FIM MUDANÇA DE COR ---
        bottomRowPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinha o painel em si horizontalmente

        // Painel que contém os botões de navegação
        JPanel menu = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Cria o painel de menu
        // --- MUDANÇA DE COR AQUI ---
        menu.setBackground(navbarColor); // Cor de fundo do painel de menu
        // --- FIM MUDANÇA DE COR ---


        String[] categorias = {"HOME", "LIVROS", "CD", "DVD"};
        for (String categoria : categorias) {
            JButton botao = new JButton(categoria);
            botao.setFocusPainted(false);
            botao.setBackground(new Color(210, 180, 140));
            botao.setForeground(Color.BLACK);
            botao.setFont(new Font("Serif", Font.BOLD, 16));
            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    categoriaAtual = botao.getText();
                    campoPesquisa.setText("");
                    atualizarExibicaoProdutos();
                }
            });
            menu.add(botao); // Adiciona o botão ao painel de menu
        }

        // Adiciona o painel de menu (com os botões dentro) à linha inferior
        bottomRowPanel.add(menu);

        // Adiciona a linha inferior ao painel principal do header
        panel.add(bottomRowPanel);

        return panel;
    }

    // Cria um JPanel (card) para exibir as informações de um produto individual
    private JPanel criarCard(Produto produto) {
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(180, 250)); // Ajuste o tamanho conforme desejar
        card.setMaximumSize(new Dimension(180, 250)); // Adiciona tamanho máximo para ajudar FlowLayout
        card.setBackground(new Color(255, 248, 220));
        card.setBorder(BorderFactory.createLineBorder(new Color(210, 180, 140), 3, true));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel imagem = new JLabel();
        imagem.setPreferredSize(new Dimension(100, 100));
        imagem.setMinimumSize(new Dimension(100, 100)); // Adiciona tamanho mínimo
        imagem.setMaximumSize(new Dimension(100, 100)); // Adiciona tamanho máximo
        imagem.setBackground(Color.LIGHT_GRAY);
        imagem.setOpaque(true);
        imagem.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Centralização do título
        JLabel tituloLabel = new JLabel(produto.getDescricao());
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto DENTRO do JLabel
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza o JLabel DENTRO do BoxLayout
        tituloLabel.setFont(new Font("Serif", Font.BOLD, 14));
        tituloLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5)); // Espaçamento interno
        tituloLabel.setPreferredSize(new Dimension(170, 40)); // Ajuste conforme necessário
        tituloLabel.setMaximumSize(new Dimension(170, 50)); // Ajuste conforme necessário


        JLabel detalheLabel = new JLabel(produto.getGenero());
        detalheLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto do detalhe também
        detalheLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detalheLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        detalheLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5)); // Adiciona espaçamento lateral


        DecimalFormat df = new DecimalFormat("R$ #,##0.00");
        JLabel precoLabel = new JLabel(df.format(produto.getPreco()));
        precoLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto do preço
        precoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        precoLabel.setFont(new Font("Serif", Font.BOLD, 14));
        precoLabel.setForeground(new Color(139, 69, 19));
        precoLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Espaçamento vertical

        JButton comprarButton = new JButton("COMPRAR");
        comprarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        comprarButton.setBackground(new Color(139, 69, 19));
        comprarButton.setForeground(Color.WHITE);
        comprarButton.setFocusPainted(false);
        comprarButton.setFont(new Font("Serif", Font.BOLD, 12)); // Ajusta o tamanho da fonte do botão
        comprarButton.setPreferredSize(new Dimension(100, 25)); // Tamanho preferencial do botão
        comprarButton.setMaximumSize(new Dimension(120, 30));


        card.add(Box.createVerticalStrut(5));
        card.add(imagem);
        card.add(tituloLabel); // Adiciona o título
        card.add(detalheLabel);
        card.add(Box.createVerticalGlue()); // Adiciona cola vertical para empurrar o preço e botão para baixo
        card.add(precoLabel);
        card.add(comprarButton);
        card.add(Box.createVerticalStrut(5)); // Espaço no final

        return card;
    }

    // Carrega a lista inicial de todos os produtos
    private void carregarProdutos() {
        System.out.println("DEBUG: Carregando produtos...");
        // Instanciando objetos das subclasses com dados mais completos
        // É CRUCIAL que a string da categoria passada no construtor da superclasse
        // (o último argumento para super()) corresponda EXATAMENTE às strings
        // usadas nos botões do menu ("LIVROS", "CD", "DVD").

        // Livros (Categoria: "LIVROS")
        produtos.add(new Livro("A Biblioteca da Meia-Noite", "Ficção", 10, 69.90, "MATT HAIG", "Editora Intrínseca", "1ª Edição"));
        produtos.add(new Livro("Café com Deus Pai", "Religião", 25, 53.15, "JUNIOR ROSTIROLA", "Editora V&R", "Edição de Bolso"));
        produtos.add(new Livro("Dom Quixote", "Clássico", 5, 39.99, "Miguel de Cervantes", "Editora Penguin Companhia", "Edição Integral"));
        produtos.add(new Livro("1984", "Distopia", 15, 45.50, "George Orwell", "Editora Companhia das Letras", "Nova Edição"));
        produtos.add(new Livro("Orgulho e Preconceito", "Romance", 12, 35.00, "Jane Austen", "Editora Martin Claret", "Edição de Luxo"));

        // CDs (Categoria: "CD")
        produtos.add(new Cd("Future Nostalgia", "Pop", 50, 55.90, "DUA LIPA", "Warner Records", "EUA"));
        produtos.add(new Cd("Divide", "Pop", 30, 45.00, "ED SHEERAN", "Atlantic Records", "Reino Unido"));
        produtos.add(new Cd("Random Access Memories", "Eletrônica", 15, 60.00, "DAFT PUNK", "Columbia Records", "França"));
        produtos.add(new Cd("Thriller", "Pop", 20, 50.00, "Michael Jackson", "Epic Records", "EUA"));
        produtos.add(new Cd("Back in Black", "Rock", 18, 48.00, "AC/DC", "Atlantic Records", "Austrália"));

        // DVDs (Categoria: "DVD")
        produtos.add(new Dvd("Ainda Estou Aqui", "Drama", 20, 14.99, "Walter Salles", "120 min", "Livre"));
        produtos.add(new Dvd("O Poderoso Chefão", "Crime", 10, 29.90, "Francis Ford Coppola", "175 min", "14 anos"));
        produtos.add(new Dvd("Interestelar", "Ficção Científica", 18, 34.90, "Christopher Nolan", "169 min", "10 anos"));
        produtos.add(new Dvd("Pulp Fiction", "Crime", 14, 25.00, "Quentin Tarantino", "154 min", "18 anos"));
        produtos.add(new Dvd("Matrix", "Ficção Científica", 22, 30.00, "Lana Wachowski, Lilly Wachowski", "136 min", "14 anos"));
        System.out.println("DEBUG: Total de produtos carregados: " + produtos.size());
    }

    // Atualiza a exibição dos produtos com base no campo de pesquisa ou na categoria selecionada
    private void atualizarExibicaoProdutos() {
        String textoPesquisa = campoPesquisa.getText().trim();
        ArrayList<Produto> produtosParaExibir = new ArrayList<>();

        System.out.println("DEBUG: --- Início Atualização Exibição ---"); // Debug
        System.out.println("DEBUG: Texto na pesquisa: '" + textoPesquisa + "'"); // Debug
        System.out.println("DEBUG: Categoria atual: '" + categoriaAtual + "'"); // Debug


        if (!textoPesquisa.isEmpty()) {
            // Se houver texto na pesquisa, filtra por descrição (ignorando maiúsculas/minúsculas)
            System.out.println("DEBUG: Modo: Pesquisa"); // Debug
            String lowerCaseQuery = textoPesquisa.toLowerCase();
            for (Produto p : produtos) {
                // Verifica se a descrição do produto contém o texto da pesquisa
                if (p.getDescricao() != null && p.getDescricao().toLowerCase().contains(lowerCaseQuery)) {
                    System.out.println("DEBUG:   -> Produto '" + p.getDescricao() + "' corresponde à pesquisa. Adicionado."); // Debug
                    produtosParaExibir.add(p);
                } else {
                    System.out.println("DEBUG:   -> Produto '" + p.getDescricao() + "' não corresponde à pesquisa. Ignorado."); // Debug
                }
            }
        } else {
            // Se o campo de pesquisa estiver vazio, filtra pela categoria atual
            System.out.println("DEBUG: Modo: Filtragem por Categoria"); // Debug
            if (categoriaAtual.equals("HOME")) {
                // Se for HOME, adiciona todos e embaralha
                System.out.println("DEBUG: Categoria HOME. Adicionando todos os produtos e embaralhando."); // Debug
                produtosParaExibir.addAll(produtos);
                Collections.shuffle(produtosParaExibir, new Random());
            } else {
                // Se for uma categoria específica, filtra por categoria
                System.out.println("DEBUG: Categoria específica: '" + categoriaAtual + "'. Filtrando."); // Debug
                for (Produto p : produtos) {
                    // Verifica se a categoria do produto corresponde à categoria atual
                    if (p.getCategoria() != null && p.getCategoria().equals(categoriaAtual)) {
                         System.out.println("DEBUG:   -> Produto '" + p.getDescricao() + "' com categoria '" + p.getCategoria() + "' corresponde. Adicionado."); // Debug
                        produtosParaExibir.add(p);
                    } else {
                         String prodCategoria = (p.getCategoria() == null) ? "NULL" : p.getCategoria();
                         System.out.println("DEBUG:   -> Produto '" + p.getDescricao() + "' (Categoria: " + prodCategoria + ") não corresponde à categoria '" + categoriaAtual + "'. Ignorado."); // Debug
                    }
                }
            }
        }

        System.out.println("DEBUG: Total de produtos para exibir: " + produtosParaExibir.size()); // Debug
        System.out.println("DEBUG: --- Fim Atualização Exibição ---"); // Debug


        // Cria um NOVO painel de grid com os cards filtrados/embaralhados
        JPanel novoProdutosGridPanel = new JPanel(new GridLayout(0, 5, 20, 20));
        novoProdutosGridPanel.setBackground(new Color(244, 240, 230));
        novoProdutosGridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Adiciona os cards ao novo painel de grid
        for (Produto p : produtosParaExibir) {
             novoProdutosGridPanel.add(criarCard(p));
        }

        // Remove todos os componentes do painel container (que usa FlowLayout)
        produtosPanelContainer.removeAll();

        // Adiciona o novo painel de grid ao painel container
        produtosPanelContainer.add(novoProdutosGridPanel);

        // Atualiza a referência para o painel de grid atual
        produtosGridPanel = novoProdutosGridPanel;

        // Revalida e repinta o painel container e o scroll pane para garantir a atualização visual
        produtosPanelContainer.revalidate();
        produtosPanelContainer.repaint();
        scrollPane.revalidate();
        scrollPane.repaint();
        this.revalidate();
        this.repaint();
    }

}

