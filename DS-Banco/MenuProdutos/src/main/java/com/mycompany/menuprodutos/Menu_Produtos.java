/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.text.DecimalFormat;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.net.URL;
import javax.imageio.ImageIO;

public class Menu_Produtos extends JFrame {

    private JPanel produtosPanelContainer;
    private JPanel produtosGridPanel;
    private JScrollPane scrollPane;
    private ArrayList<Produto> produtos;
    private RoundedTextField campoPesquisa;
    private String categoriaAtual = "HOME";
    private String generoAtual = null; // Para rastrear o gênero de livro selecionado
    private JPanel generoPanel; // Painel para os botões de gênero

    public Menu_Produtos() {
        setTitle("Livraria Entre Palavras");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("src/assets/images/Logo.png");
        setIconImage(icon.getImage());

        setLayout(new BorderLayout());

        produtos = new ArrayList<>();
        carregarProdutos();

        JPanel header = criarHeader();
        add(header, BorderLayout.NORTH);

        produtosPanelContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        produtosPanelContainer.setBackground(new Color(244, 240, 230));

        produtosGridPanel = new JPanel(new GridLayout(0, 5, 20, 20));
        produtosGridPanel.setBackground(new Color(244, 240, 230));
        produtosGridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        produtosPanelContainer.add(produtosGridPanel);

        scrollPane = new JScrollPane(produtosPanelContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBlockIncrement(160);

        add(scrollPane, BorderLayout.CENTER);

        atualizarExibicaoProdutos();
    }

    private JPanel criarHeader() {
        JPanel panel = new JPanel();
        Color navbarColor = new Color(115, 103, 47);
        panel.setBackground(navbarColor);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel topRowPanel = new JPanel(new BorderLayout());
        topRowPanel.setBackground(navbarColor);
        topRowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, topRowPanel.getPreferredSize().height));

        // Painel da Esquerda (Logo + Texto)
        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        logoPanel.setBackground(navbarColor);

        String imagePath = "src/assets/images/Logo.png";
        ImageIcon logoIcon = new ImageIcon(imagePath);
        Image image = logoIcon.getImage();
        Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(resizedImage);

        JLabel imageLabel = new JLabel(logoIcon);
        JLabel textoLabel = new JLabel("<html><b>Livraria<br>Entre Palavras</b></html>");
        textoLabel.setFont(new Font("Serif", Font.BOLD, 18));
        textoLabel.setForeground(Color.WHITE);

        logoPanel.add(imageLabel);
        logoPanel.add(Box.createHorizontalStrut(10));
        logoPanel.add(textoLabel);

        topRowPanel.add(logoPanel, BorderLayout.WEST);

        // Painel Central (Pesquisa)
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchPanel.setBackground(navbarColor);
        searchPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        campoPesquisa = new RoundedTextField(40);
        campoPesquisa.setFont(new Font("Serif", Font.PLAIN, 18));
        campoPesquisa.setPreferredSize(new Dimension(350, 35));
        campoPesquisa.setMaximumSize(new Dimension(400, 40));
        campoPesquisa.setBorderColor(Color.BLACK);
        campoPesquisa.setCornerRadius(20);

        searchPanel.add(campoPesquisa);
        JLabel lupaIcon = new JLabel("🔍");
        lupaIcon.setFont(new Font("Serif", Font.PLAIN, 20));
        searchPanel.add(lupaIcon);
        searchPanel.add(Box.createHorizontalStrut(105));

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
        topRowPanel.add(searchPanel, BorderLayout.CENTER);

        // Painel da Direita (Botão Sair)
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setBackground(navbarColor);

        JButton btnSair = new JButton("Sair");
        btnSair.setFocusPainted(false);
        btnSair.setBackground(new Color(200, 0, 0));
        btnSair.setForeground(Color.WHITE);
        btnSair.setFont(new Font("Serif", Font.BOLD, 16));
        btnSair.addActionListener(e -> System.exit(0));

        rightPanel.add(btnSair);
        topRowPanel.add(rightPanel, BorderLayout.EAST);

        // Linha Inferior (Botões de Navegação)
        JPanel bottomRowPanel = new JPanel();
        bottomRowPanel.setLayout(new BoxLayout(bottomRowPanel, BoxLayout.Y_AXIS));
        bottomRowPanel.setBackground(navbarColor);

        // Painel de categorias (HOME, LIVROS, CD, DVD)
        JPanel menu = new JPanel(new FlowLayout(FlowLayout.CENTER));
        menu.setBackground(navbarColor);

        generoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        generoPanel.setBackground(new Color(89, 30, 25, 1)); // Cor da logo (Marrom Sela)
        generoPanel.setVisible(false); // Inicia invisível

        String[] categorias = {"HOME", "LIVROS", "CD", "DVD"};

        for (String categoria : categorias) {
            JButton botao = new JButton(categoria);
            botao.setFocusPainted(false);
            botao.setBackground(new Color(210, 180, 140));
            botao.setForeground(Color.BLACK);
            botao.setFont(new Font("Serif", Font.BOLD, 16));
            botao.addActionListener(e -> {
                categoriaAtual = botao.getText();
                generoAtual = null; // Reseta o gênero ao mudar de categoria principal
                campoPesquisa.setText("");
                atualizarExibicaoProdutos();
                generoPanel.setVisible(categoriaAtual.equals("LIVROS")); // Mostra o painel de gêneros se "LIVROS" for selecionado
                atualizarBotoesGenero(); // Atualiza os botões de gênero
                bottomRowPanel.revalidate(); // Força a refazer o layout para mostrar/esconder o painel de gêneros
                bottomRowPanel.repaint();
            });
            menu.add(botao);
        }

        bottomRowPanel.add(menu);
        bottomRowPanel.add(generoPanel);

        panel.add(topRowPanel);
        panel.add(bottomRowPanel);

        return panel;
    }

    private void atualizarBotoesGenero() {
        generoPanel.removeAll();
        if (categoriaAtual.equals("LIVROS")) {
            HashSet<String> generosLivros = new HashSet<>();
            for (Produto produto : produtos) {
                if (produto instanceof Livro) {
                    generosLivros.add(((Livro) produto).getGenero());
                }
            }
            for (String genero : generosLivros) {
                JButton botaoGenero = new JButton(genero);
                botaoGenero.setFocusPainted(false);
                botaoGenero.setBackground(new Color(230, 220, 190));
                botaoGenero.setForeground(Color.BLACK);
                botaoGenero.setFont(new Font("Serif", Font.PLAIN, 14));
                botaoGenero.addActionListener(e -> {
                    generoAtual = botaoGenero.getText();
                    campoPesquisa.setText("");
                    atualizarExibicaoProdutos();
                });
                generoPanel.add(botaoGenero);
            }
        }
        generoPanel.revalidate();
        generoPanel.repaint();
    }

  private JPanel criarCard(Produto produto) {
    return new RoundedCardPanel(produto);
}
    



    private void carregarProdutos() {
        System.out.println("DEBUG: Carregando produtos...");

        // Livros (Categoria: "LIVROS")
        produtos.add(new Livro("A Biblioteca da Meia-Noite", "Ficção", 10, 69.90, "Matt Haig", "Editora XYZ", "1ª Edição", "src/assets/images/livro1.png", "Um romance emocionante e reflexivo sobre escolhas..."));
        produtos.add(new Livro("A Empregada", "Suspense", 8, 40.20, "Freida McFadden", "Editora XYZ", "1ª Edição", "src/assets/images/livro2.png", "Um suspense eletrizante que prende o leitor do início ao fim..."));
        produtos.add(new Livro("A Garota do Lago", "Mistério", 12, 25.90, "Charlie Donlea", "Editora ABC", "Edição de Luxo", "src/assets/images/livro3.png", "Um mistério envolvente ambientado em uma atmosfera sombria..."));
        produtos.add(new Livro("A Hipótese do Amor", "Romance", 14, 39.99, "Ali Hazelwood", "Editora LER", "2ª Edição", "src/assets/images/livro4.png", "Uma comédia romântica inteligente e divertida..."));
        produtos.add(new Livro("A Noiva", "Romance", 16, 49.90, "Ali Hazelwood", "Editora LER", "Edição Especial", "src/assets/images/livro5.png", "Um romance apaixonante com personagens cativantes..."));
        produtos.add(new Livro("A Revolução dos Bichos", "Fábula", 20, 24.20, "George Orwell", "Editora XYZ", "Edição de Bolso", "src/assets/images/livro6.png", "Uma alegoria satírica sobre o totalitarismo..."));
        produtos.add(new Livro("A Sutil Arte de Ligar o F*da-se", "Autoajuda", 30, 35.00, "Mark Manson", "Editora Agora", "Edição Especial", "src/assets/images/livro7.png", "Um guia de autoajuda que desafia o pensamento positivo tradicional..."));
        produtos.add(new Livro("Assim que Acaba Assim que Começa", "Romance", 7, 150.00, "Colleen Hoover", "Editora Nova", "Primeira Edição", "src/assets/images/livro8.png", "Uma história de amor intensa e emocionalmente carregada..."));
        produtos.add(new Livro("Bíblia Sagrada", "Religião", 50, 50.00, "Diversos Autores", "Editora Record", "Edição Comemorativa", "src/assets/images/livro9.png", "Uma coletânea de textos religiosos de valor espiritual e histórico..."));
        produtos.add(new Livro("Bobbie Goods - Para Pintar", "Arte", 15, 34.50, "Bobbie Goods", "Editora Art", "Edição de Arte", "src/assets/images/livro10.png", "Um livro de colorir relaxante e inspirador..."));
        produtos.add(new Livro("Café com Deus Pai", "Religião", 25, 53.15, "Junior Rostirola","Editora V&R", "Edição de Bolso", "src/assets/images/livro11.png", "Uma leitura devocional diária que oferece mensagens de fé, esperança e encorajamento..."));
        produtos.add(new Livro("Capitães da Areia", "Clássico", 22, 53.15, "Jorge Amado", "Editora Companhia", "Edição Popular", "src/assets/images/livro12.png", "Um retrato vívido e emocionante da vida de um grupo de meninos de rua..."));
        produtos.add(new Livro("Coleção Box do Harry Potter", "Fantasia", 10, 349.90, "J.K Rowling", "Editora Rocco", "Edição Limitada", "src/assets/images/livro13.png", "Uma coleção imperdível dos sete livros da saga Harry Potter..."));
        produtos.add(new Livro("Coleção Percy Jackson", "Aventura", 18, 200.00, "Rick Riordan", "Editora Intrínseca", "Edição Completa", "src/assets/images/livro14.png", "Uma emocionante série de livros de aventura que mistura mitologia grega..."));
        produtos.add(new Livro("Dona Flor e seus 2 Maridos", "Romance", 12, 15.00, "Jorge Amado", "Editora Record", "Edição Popular", "src/assets/images/livro15.png", "Uma deliciosa comédia romântica sobre uma viúva que se casa novamente..."));
        produtos.add(new Livro("Espreitador - Ordem Paranormal", "Terror", 14, 85.10, "Diversos Autores", "Editora Criativa", "Edição Especial", "src/assets/images/livro16.png", "Uma antologia de contos de terror baseada no universo de Ordem Paranormal..."));
        produtos.add(new Livro("Extraordinário", "Drama", 11, 41.90, "R.J. Palacio", "Editora Intrínseca", "Primeira Edição", "src/assets/images/livro17.png", "Uma história inspiradora sobre um menino com uma deformidade facial..."));
        produtos.add(new Livro("Homem de Giz", "Mistério", 16, 39.90, "C.J. Tudor", "Editora Novo Conceito", "Edição Especial", "src/assets/images/livro18.png", "Um suspense psicológico sombrio e cheio de reviravoltas..."));
        produtos.add(new Livro("IT: A Coisa", "Terror", 5, 80.00, "Stephen King", "Editora Suma", "Edição Especial", "src/assets/images/livro19.png", "Um clássico do terror sobre um palhaço maligno que aterroriza crianças..."));
        produtos.add(new Livro("Jantar Secreto", "Suspense", 7, 50.90, "Raphael Montes", "Editora Companhia das Letras", "Primeira Edição", "src/assets/images/livro20.png", "Um suspense psicológico intenso e claustrofóbico..."));
        produtos.add(new Livro("O Homem Mais Rico da Babilônia", "Finanças", 20, 19.20, "George S. Clason", "Editora Gente", "Edição Completa", "src/assets/images/livro21.png", "Um livro atemporal que oferece princípios financeiros sábios e práticos..."));
        produtos.add(new Livro("O Massacre da Serra Elétrica", "Terror", 13, 39.30, "Stefan Jaworzyn", "Editora Mad", "Edição Especial", "src/assets/images/livro22.png", "Uma análise aterrorizante e visceral do filme cult de terror 'O Massacre da Serra Elétrica'.."));
        produtos.add(new Livro("O Pequeno Príncipe", "Infantil", 10, 15.00, "Antoine de Saint-Exupéry", "Editora Agir", "Edição de Luxo", "src/assets/images/livro23.png", "Uma fábula poética e filosófica sobre a amizade, o amor, a perda..."));
        produtos.add(new Livro("Trilogia Príncipe Cruel", "Fantasia", 12, 120.00, "Holly Black", "Editora Galera", "Edição Completa", "src/assets/images/livro24.png", "Uma trilogia de fantasia sombria e envolvente sobre intrigas na corte feérica..."));

       // CDs (Categoria: "CD")
        produtos.add(new Cd("1989", "Pop", 25, 70.90, "TAYLOR SWIFT", "Republic Records", "EUA", "src/assets/images/cd1.jpg", "O quinto álbum de estúdio de Taylor Swift..."));
        produtos.add(new Cd("After Hours", "R&B", 25, 40.20, "THE WEEKND", "XO/Republic", "Canadá", "src/assets/images/cd2.jpg", "O quarto álbum de estúdio de The Weeknd..."));
        produtos.add(new Cd("A Gente Tem Que Ser Feliz", "MPB", 25, 40.00, "NANDO REIS", "Relicário Music", "Brasil", "src/assets/images/cd3.jpg", "Um álbum de MPB com letras poéticas e melodias envolventes..."));
        produtos.add(new Cd("A Night at the Opera", "Rock", 25, 79.90, "QUEEN", "EMI", "Reino Unido", "src/assets/images/cd4.jpg", "Um álbum icônico do Queen..."));
        produtos.add(new Cd("Aventura", "Bachata", 25, 25.90, "AVENTURA", "Premium Latin", "EUA", "src/assets/images/cd5.jpg", "Álbum de bachata que consagrou o grupo Aventura..."));
        produtos.add(new Cd("Born This Way", "Pop", 25, 39.99, "LADY GAGA", "Interscope", "EUA", "src/assets/images/Cd6.png", "O segundo álbum de estúdio de Lady Gaga..."));
        produtos.add(new Cd("Emails I Can't Send", "Pop", 25, 24.20, "SABRINA CARPENTER", "Island Records", "EUA", "src/assets/images/cd7.jpg", "Um álbum pop moderno com letras introspectivas..."));
        produtos.add(new Cd("K-12", "Alternativo", 25, 50.00, "MELANIE MARTINEZ", "Atlantic Records", "EUA", "src/assets/images/cd9.jpg", "Um álbum conceitual alternativo de Melanie Martinez..."));
        produtos.add(new Cd("Legends Never Die", "Hip-Hop", 25, 34.50, "JUICE WRLD", "Grade A/Interscope", "EUA", "src/assets/images/cd10.jpg", "Um álbum póstumo do rapper Juice WRLD..."));
        produtos.add(new Cd("Midnights", "Pop", 25, 53.15, "TAYLOR SWIFT", "Republic Records", "EUA", "src/assets/images/cd11.jpg", "O décimo álbum de estúdio de Taylor Swift..."));
        produtos.add(new Cd("No.1", "K-pop", 25, 35.00, "BLACKPINK", "YG Entertainment", "Coreia do Sul", "src/assets/images/cd13.jpg", "Um álbum de K-pop com músicas vibrantes..."));
        produtos.add(new Cd("Planet Her", "R&B", 25, 35.00, "DOJA CAT", "RCA Records", "EUA", "src/assets/images/cd14.jpg", "Um álbum de R&B e pop futurista de Doja Cat..."));
        produtos.add(new Cd("Rumours", "Rock", 25, 39.99, "FLEETWOOD MAC", "Warner Bros. Records", "EUA", "src/assets/images/cd17.jpg", "Um álbum clássico do Fleetwood Mac..."));
        produtos.add(new Cd("Samba de Raiz", "Samba", 25, 29.90, "ZECA PAGODINHO", "Universal Music", "Brasil", "src/assets/images/cd18.jpg", "Um álbum autêntico de samba de raiz..."));
        produtos.add(new Cd("S.O.S", "R&B", 25, 49.90, "SZA", "Top Dawg Entertainment", "EUA", "src/assets/images/cd19.jpg", "O segundo álbum de estúdio de SZA..."));
        produtos.add(new Cd("The Dark Side of the Moon", "Rock Progressivo", 25, 35.00, "PINK FLOYD", "Harvest Records", "Reino Unido", "src/assets/images/cd20.jpg", "Um álbum conceitual seminal do Pink Floyd..."));
        produtos.add(new Cd("The Life of Pablo", "Rap", 25, 35.00, "KANYE WEST", "GOOD Music", "EUA", "src/assets/images/cd21.png", "Um álbum de rap experimental e multifacetado de Kanye West..."));
        produtos.add(new Cd("Unorthodox Junkebox", "Pop", 25, 120.00, "BRUNO MARS", "Atlantic Records", "EUA", "src/assets/images/cd24.jpg", "O segundo álbum de estúdio de Bruno Mars..."));
        produtos.add(new Cd("Viva la Vida", "Alternativo", 25, 50.00, "COLDPLAY", "Parlophone", "Reino Unido", "src/assets/images/cd23.jpg", "O quarto álbum de estúdio do Coldplay..."));
      
        // DVDs (Categoria: "DVD")
        produtos.add(new Dvd("A Culpa é das Estrelas", "Romance", 15, 29.90, "Josh Boone", "125 min", "12 anos", "imagens/aculpaedasestrelas.jpg", "Um filme emocionante sobre dois adolescentes com câncer..."));
        produtos.add(new Dvd("A Espera de um Milagre", "Drama", 12, 39.90, "Frank Darabont", "189 min", "14 anos", "imagens/aesperadeummilagre.jpg", "Um drama comovente sobre um guarda prisional..."));
        produtos.add(new Dvd("A Freira", "Terror", 20, 34.90, "Corin Hardy", "96 min", "16 anos", "imagens/afreira.jpg", "Um filme de terror sobrenatural que explora a origem de uma freira demoníaca..."));
        produtos.add(new Dvd("A Mentira", "Comédia", 18, 39.90, "Will Gluck", "92 min", "14 anos", "imagens/amentira.jpg", "Uma comédia adolescente sobre uma garota popular que inventa uma mentira..."));
        produtos.add(new Dvd("Ainda Estou Aqui", "Drama", 20, 34.90, "José Eduardo Belmonte", "120 min", "12 anos", "imagens/aindaestouaqui.jpg", "Um drama brasileiro que aborda temas de luto, memória..."));
        produtos.add(new Dvd("A Teoria de Tudo", "Biografia", 17, 39.90, "James Marsh", "123 min", "12 anos", "imagens/ateoriadetudo.jpg", "Uma cinebiografia inspiradora sobre a vida do renomado físico Stephen Hawking..."));
        produtos.add(new Dvd("Avengers: Endgame", "Ação", 25, 79.90, "Anthony Russo, Joe Russo", "181 min", "12 anos", "imagens/avengersendgame.jpg", "O épico final da saga dos Vingadores..."));
        produtos.add(new Dvd("Batman: O Cavaleiro das Trevas", "Ação", 20, 39.90, "Christopher Nolan", "152 min", "14 anos", "imagens/batmanocavaleirodastrevas.jpg", "Um filme de super-heróis aclamado pela crítica..."));
        produtos.add(new Dvd("Blade Runner 2049", "Ficção Científica", 15, 59.90, "Denis Villeneuve", "164 min", "14 anos", "imagens/bladerunner2049.jpg", "Uma sequência visualmente deslumbrante que explora temas de identidade..."));
        produtos.add(new Dvd("Cisne Negro", "Drama", 10, 49.90, "Darren Aronofsky", "108 min", "16 anos", "imagens/cisnenegro.jpg", "Um suspense psicológico intenso sobre uma bailarina atormentada..."));
        produtos.add(new Dvd("Coco", "Animação", 22, 49.90, "Lee Unkrich, Adrian Molina", "105 min", "Livre", "imagens/coco.jpg", "Uma animação emocionante e visualmente rica que celebra a cultura mexicana..."));
        produtos.add(new Dvd("Divertida Mente", "Animação", 30, 39.90, "Pete Docter", "95 min", "Livre", "imagens/divertidamente.jpg", "Uma animação criativa que explora as emoções de uma garota..."));
        produtos.add(new Dvd("E Se Fosse Verdade?", "Romance", 14, 29.90, "Mark Waters", "95 min", "10 anos", "imagens/esefosseverdade.jpg", "Uma comédia romântica adorável sobre um homem solitário..."));
        produtos.add(new Dvd("Hereditary: O Herdeiro", "Terror", 12, 39.90, "Ari Aster", "127 min", "16 anos", "imagens/hereditary.jpg", "Um filme de terror psicológico perturbador sobre uma família assombrada..."));
        produtos.add(new Dvd("Interestelar", "Ficção Científica", 18, 59.90, "Christopher Nolan", "169 min", "10 anos", "imagens/interestelar.jpg", "Uma ficção científica épica sobre um grupo de astronautas..."));
        produtos.add(new Dvd("It: A Coisa", "Terror", 15, 49.90, "Andy Muschietti", "135 min", "16 anos", "imagens/itacoisa.jpg", "Um filme de terror baseado no clássico livro de Stephen King..."));
        produtos.add(new Dvd("John Wick", "Ação", 20, 39.90, "Chad Stahelski", "101 min", "16 anos", "imagens/johnwick.jpg", "Um filme de ação eletrizante sobre um assassino de aluguel aposentado..."));
        produtos.add(new Dvd("Mad Max: Fury Road", "Ação", 17, 49.90, "George Miller", "120 min", "16 anos", "imagens/madmaxfuryroad.jpg", "Um filme de ação pós-apocalíptico visualmente impressionante..."));
        produtos.add(new Dvd("Parasita", "Suspense", 19, 45.90, "Bong Joon-ho", "132 min", "16 anos", "imagens/parasita.jpg", "Um suspense sul-coreano aclamado pela crítica com reviravoltas surpreendentes..."));
        produtos.add(new Dvd("O Poderoso Chefão", "Drama", 23, 55.90, "Francis Ford Coppola", "175 min", "16 anos", "imagens/opoderosochefao.jpg", "Um clássico do cinema sobre a ascensão e os conflitos de uma família mafiosa..."));
    }

 private void atualizarExibicaoProdutos() {
        produtosGridPanel.removeAll();
        String textoPesquisa = campoPesquisa.getText().toLowerCase();
        ArrayList<Produto> produtosParaExibir = new ArrayList<>();

        System.out.println("DEBUG: --- Início Atualização Exibição ---"); // Debug
        System.out.println("DEBUG: Texto na pesquisa: '" + textoPesquisa + "'"); // Debug
        System.out.println("DEBUG: Categoria atual: '" + categoriaAtual + "'"); // Debug
        System.out.println("DEBUG: Gênero atual: '" + generoAtual + "'"); // Debug


        if (!textoPesquisa.isEmpty()) {
            // Se houver texto na pesquisa, filtra por descrição e gênero (se aplicável)
            System.out.println("DEBUG: Modo: Pesquisa"); // Debug
            String lowerCaseQuery = textoPesquisa.toLowerCase();
            for (Produto p : produtos) {
                boolean pesquisaCorresponde = (p.getDescricao() != null && p.getDescricao().toLowerCase().contains(lowerCaseQuery)) ||
                                             (p.getGenero() != null && p.getGenero().toLowerCase().contains(lowerCaseQuery));
                boolean categoriaCorresponde = categoriaAtual.equals("HOME") || p.getClass().getSimpleName().equalsIgnoreCase(categoriaAtual);
                boolean generoCorresponde = true;

                if (categoriaAtual.equals("LIVROS") && generoAtual != null && p instanceof Livro) {
                    generoCorresponde = ((Livro) p).getGenero().equalsIgnoreCase(generoAtual);
                }

                if (pesquisaCorresponde && categoriaCorresponde && generoCorresponde) {
                    System.out.println("DEBUG:    -> Produto '" + p.getDescricao() + "' corresponde à pesquisa, categoria e gênero. Adicionado."); // Debug
                    produtosParaExibir.add(p);
                } else {
                    System.out.println("DEBUG:    -> Produto '" + p.getDescricao() + "' não corresponde à pesquisa, categoria ou gênero. Ignorado."); // Debug
                }
            }
        } else {
            // Se o campo de pesquisa estiver vazio, filtra pela categoria atual e gênero (se aplicável)
            System.out.println("DEBUG: Modo: Filtragem por Categoria"); // Debug
            if (categoriaAtual.equals("HOME")) {
                // Se for HOME, adiciona todos e embaralha
                System.out.println("DEBUG: Categoria HOME. Adicionando todos os produtos e embaralhando."); // Debug
                produtosParaExibir.addAll(produtos);
                Collections.shuffle(produtosParaExibir, new Random());
            } else if (categoriaAtual.equals("LIVROS")) {
                // Se for LIVROS, exibe todos os livros inicialmente (quando generoAtual é null)
                System.out.println("DEBUG: Categoria LIVROS. Exibindo todos os livros inicialmente."); // Debug
                for (Produto p : produtos) {
                    if (p instanceof Livro) {
                        System.out.println("DEBUG:    -> Livro '" + p.getDescricao() + "' adicionado."); // Debug
                        produtosParaExibir.add(p);
                    }
                }
                // Se um gênero estiver selecionado, filtra por gênero
                if (generoAtual != null) {
                    ArrayList<Produto> livrosFiltradosPorGenero = new ArrayList<>();
                    String lowerCaseGenero = generoAtual.toLowerCase();
                    System.out.println("DEBUG: Categoria LIVROS e gênero '" + generoAtual + "'. Filtrando por gênero."); // Debug
                    for (Produto p : produtosParaExibir) { // Itera sobre os livros já adicionados
                        if (p instanceof Livro && ((Livro) p).getGenero() != null && ((Livro) p).getGenero().toLowerCase().equals(lowerCaseGenero)) {
                            System.out.println("DEBUG:    -> Livro '" + p.getDescricao() + "' com gênero '" + ((Livro) p).getGenero() + "' corresponde. Mantido."); // Debug
                            livrosFiltradosPorGenero.add(p);
                        } else {
                            System.out.println("DEBUG:    -> Livro '" + p.getDescricao() + "' não corresponde ao gênero '" + generoAtual + "'. Removido."); // Debug
                        }
                    }
                    produtosParaExibir = livrosFiltradosPorGenero; // Atualiza a lista para exibir apenas os do gênero
                }
            } else {
                // Se for outra categoria (CD, DVD), filtra por categoria
                System.out.println("DEBUG: Categoria específica: '" + categoriaAtual + "'. Filtrando por categoria."); // Debug
                for (Produto p : produtos) {
                    if (p.getCategoria() != null && p.getCategoria().equals(categoriaAtual)) {
                        System.out.println("DEBUG:    -> Produto '" + p.getDescricao() + "' com categoria '" + p.getCategoria() + "' corresponde. Adicionado."); // Debug
                        produtosParaExibir.add(p);
                    } else {
                        String prodCategoria = (p.getCategoria() == null) ? "NULL" : p.getCategoria();
                        System.out.println("DEBUG:    -> Produto '" + p.getDescricao() + "' (Categoria: " + prodCategoria + ") não corresponde à categoria '" + categoriaAtual + "'. Ignorado."); // Debug
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