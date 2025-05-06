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

        // Definir o ícone da janela
        ImageIcon icon = new ImageIcon("src/assets/images/Logo.png"); // Caminho do ícone
        setIconImage(icon.getImage());

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

     // Painel da Esquerda (Logo + Texto)
JPanel logoPanel = new JPanel();
logoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
logoPanel.setBackground(navbarColor); // Usa mesma cor do topo

// Carrega a imagem da logo
String imagePath = "src/assets/images/Logo.png";
ImageIcon logoIcon = new ImageIcon(imagePath);

// Redimensiona a imagem (opcional)
Image image = logoIcon.getImage();
// Redimensiona a imagem (ajuste conforme o tamanho desejado)
Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Aumentado de 50x50 para 70x70
logoIcon = new ImageIcon(resizedImage);

// JLabel com a imagem
JLabel imageLabel = new JLabel(logoIcon);

// JLabel com o texto
JLabel textoLabel = new JLabel("<html><b>Livraria<br>Entre Palavras</b></html>");
textoLabel.setFont(new Font("Serif", Font.BOLD, 18));
textoLabel.setForeground(Color.WHITE);

// Adiciona imagem e texto no painel
logoPanel.add(imageLabel);
logoPanel.add(Box.createHorizontalStrut(10)); // Espaço entre imagem e texto
logoPanel.add(textoLabel);

// Adiciona o painel à esquerda do topo
topRowPanel.add(logoPanel, BorderLayout.WEST);

   


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



// Cria o botão "Sair"
JButton btnSair = new JButton("Sair");
btnSair.setFocusPainted(false);
btnSair.setBackground(new Color(200, 0, 0)); // Cor de fundo do botão "Sair"
btnSair.setForeground(Color.WHITE); // Cor do texto do botão "Sair"
btnSair.setFont(new Font("Serif", Font.BOLD, 16)); // Fonte do botão
btnSair.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0); // Fecha a aplicação
    }
});

// --- Linha Inferior (Botões de Navegação) ---
JPanel bottomRowPanel = new JPanel();
bottomRowPanel.setLayout(new BoxLayout(bottomRowPanel, BoxLayout.Y_AXIS)); // permite empilhar verticalmente
bottomRowPanel.setBackground(navbarColor);

// Painel de categorias (HOME, LIVROS, CD, DVD)
JPanel menu = new JPanel(new FlowLayout(FlowLayout.CENTER));
menu.setBackground(navbarColor);

// Painel de gêneros (visível somente quando LIVROS for selecionado)
JPanel generoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
generoPanel.setBackground(new Color(250, 235, 215));
generoPanel.setVisible(false); // inicia invisível

String[] categorias = {"HOME", "LIVROS", "CD", "DVD"};
String[] generosLivros = {"Romance", "Suspense", "Aventura", "Religioso", "Terror", "Drama", "Ficção", "Infantil", "Fantasia", "Auto Ajuda"};

final String[] generoAtual = {""}; // usado no filtro

// Botões de categorias
for (String categoria : categorias) {
    JButton botao = new JButton(categoria);
    botao.setFocusPainted(false);
    botao.setBackground(new Color(210, 180, 140));
    botao.setForeground(Color.BLACK);
    botao.setFont(new Font("Serif", Font.BOLD, 16));
    botao.addActionListener(e -> {
        categoriaAtual = botao.getText();
        campoPesquisa.setText("");
        generoAtual[0] = ""; // limpa o filtro de gênero
        atualizarExibicaoProdutos();
        generoPanel.setVisible("LIVROS".equals(categoriaAtual)); // mostra gêneros só se for LIVROS
    });
    menu.add(botao);
}

// Botões de gêneros (só afeta livros)
for (String genero : generosLivros) {
    JButton generoBotao = new JButton(genero);
    generoBotao.setFocusPainted(false);
    generoBotao.setBackground(new Color(244, 164, 96));
    generoBotao.setForeground(Color.BLACK);
    generoBotao.setFont(new Font("Serif", Font.PLAIN, 14));
    generoBotao.addActionListener(e -> {
        generoAtual[0] = genero;
        atualizarExibicaoProdutos();
    });
    generoPanel.add(generoBotao);
}

// Adiciona os painéis ao bottomRowPanel
bottomRowPanel.add(menu);        // primeiro nav bar
bottomRowPanel.add(generoPanel); // segundo nav bar, só aparece se LIVROS for selecionado

panel.add(bottomRowPanel); // adiciona ao painel principal do header

return panel; // <-- ESSA LINHA resolve o erro de compilação
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
        try {
        ImageIcon icon = new ImageIcon(produto.getCaminhoImagem());
        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imagem.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
          imagem.setText("Sem imagem");
          imagem.setHorizontalAlignment(SwingConstants.CENTER);
        }

        
        
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
comprarButton.setFont(new Font("Serif", Font.BOLD, 12));
comprarButton.setPreferredSize(new Dimension(100, 25));
comprarButton.setMaximumSize(new Dimension(120, 30));

// Aqui você abre o menu ao clicar
comprarButton.addActionListener(e -> {
    Menu menu = new Menu(produto);
    menu.setVisible(true);
});

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
       

// Livros (Categoria: "LIVROS")
produtos.add(new Livro("A Biblioteca da Meia-Noite", "Ficção", 10, 69.90, "Matt Haig", "Editora XYZ", "1ª Edição", "src/assets/images/livro1.png"));
produtos.add(new Livro("A Empregada", "Suspense", 8, 40.20, "Freida McFadden", "Editora XYZ", "1ª Edição", "src/assets/images/livro2.png"));
produtos.add(new Livro("A Garota do Lago", "Mistério", 12, 25.90, "Charlie Donlea", "Editora ABC", "Edição de Luxo", "src/assets/images/livro3.png"));
produtos.add(new Livro("A Hipótese do Amor", "Romance", 14, 39.99, "Ali Hazelwood", "Editora LER", "2ª Edição", "src/assets/images/livro4.png"));
produtos.add(new Livro("A Noiva", "Romance", 16, 49.90, "Ali Hazelwood", "Editora LER", "Edição Especial", "src/assets/images/livro5.png"));
produtos.add(new Livro("A Revolução dos Bichos", "Fábula", 20, 24.20, "George Orwell", "Editora XYZ", "Edição de Bolso", "src/assets/images/livro6.png"));
produtos.add(new Livro("A Sutil Arte de Ligar o F*da-se", "Autoajuda", 30, 35.00, "Mark Manson", "Editora Agora", "Edição Especial", "src/assets/images/livro7.png"));
produtos.add(new Livro("Assim que Acaba Assim que Começa", "Romance", 7, 150.00, "Colleen Hoover", "Editora Nova", "Primeira Edição", "src/assets/images/livro8.png"));
produtos.add(new Livro("Bíblia Sagrada", "Religião", 50, 50.00, "Diversos Autores", "Editora Record", "Edição Comemorativa", "src/assets/images/livro9.png"));
produtos.add(new Livro("Bobbie Goods - Para Pintar", "Arte", 15, 34.50, "Bobbie Goods", "Editora Art", "Edição de Arte", "src/assets/images/livro10.png"));
produtos.add(new Livro("Café com Deus Pai", "Religião", 25, 53.15, "Junior Rostirola", "Editora V&R", "Edição de Bolso", "src/assets/images/livro11.png"));
produtos.add(new Livro("Capitães da Areia", "Clássico", 22, 53.15, "Jorge Amado", "Editora Companhia", "Edição Popular", "src/assets/images/livro12.png"));
produtos.add(new Livro("Coleção Box do Harry Potter", "Fantasia", 10, 349.90, "J.K Rowling", "Editora Rocco", "Edição Limitada", "src/assets/images/livro13.png"));
produtos.add(new Livro("Coleção Percy Jackson", "Aventura", 18, 200.00, "Rick Riordan", "Editora Intrínseca", "Edição Completa", "src/assets/images/livro14.png"));
produtos.add(new Livro("Dona Flor e seus 2 Maridos", "Romance", 12, 15.00, "Jorge Amado", "Editora Record", "Edição Popular", "src/assets/images/livro15.png"));
produtos.add(new Livro("Espreitador - Ordem Paranormal", "Terror", 14, 85.10, "Diversos Autores", "Editora Criativa", "Edição Especial", "src/assets/images/livro16.png"));
produtos.add(new Livro("Extraordinário", "Drama", 11, 41.90, "R.J. Palacio", "Editora Intrínseca", "Primeira Edição", "src/assets/images/livro17.png"));
produtos.add(new Livro("Homem de Giz", "Mistério", 16, 39.90, "C.J. Tudor", "Editora Novo Conceito", "Edição Especial", "src/assets/images/livro18.png"));
produtos.add(new Livro("IT: A Coisa", "Terror", 5, 80.00, "Stephen King", "Editora Suma", "Edição Especial", "src/assets/images/livro19.png"));
produtos.add(new Livro("Jantar Secreto", "Suspense", 7, 50.90, "Raphael Montes", "Editora Companhia das Letras", "Primeira Edição", "src/assets/images/livro20.png"));
produtos.add(new Livro("O Homem Mais Rico da Babilônia", "Finanças", 20, 19.20, "George S. Clason", "Editora Gente", "Edição Completa", "src/assets/images/livro21.png"));
produtos.add(new Livro("O Massacre da Serra Elétrica", "Terror", 13, 39.30, "Stefan Jaworzyn", "Editora Mad", "Edição Especial", "src/assets/images/livro22.png"));
produtos.add(new Livro("O Pequeno Príncipe", "Infantil", 10, 15.00, "Antoine de Saint-Exupéry", "Editora Agir", "Edição de Luxo", "src/assets/images/livro23.png"));
produtos.add(new Livro("Trilogia Príncipe Cruel", "Fantasia", 12, 120.00, "Holly Black", "Editora Galera", "Edição Completa", "src/assets/images/livro24.png"));



produtos.add(new Cd("1989", "Pop", 25, 70.90, "TAYLOR SWIFT", "Republic Records", "EUA", "imagens/1989.jpg"));
produtos.add(new Cd("After Hours", "R&B", 25, 40.20, "THE WEEKND", "XO/Republic", "Canadá", "imagens/afterhours.jpg"));
produtos.add(new Cd("A Gente Tem Que Ser Feliz", "MPB", 25, 40.00, "NANDO REIS", "Relicário Music", "Brasil", "imagens/agentetemoserfeliz.jpg"));
produtos.add(new Cd("A Night at the Opera", "Rock", 25, 79.90, "QUEEN", "EMI", "Reino Unido", "imagens/anightattheopera.jpg"));
produtos.add(new Cd("Aventura", "Bachata", 25, 25.90, "AVENTURA", "Premium Latin", "EUA", "imagens/aventura.jpg"));
produtos.add(new Cd("Born This Way", "Pop", 25, 39.99, "LADY GAGA", "Interscope", "EUA", "imagens/bornthisway.jpg"));
produtos.add(new Cd("Emails I Can't Send", "Pop", 25, 24.20, "SABRINA CARPENTER", "Island Records", "EUA", "imagens/emailsicantsend.jpg"));
produtos.add(new Cd("Fearless (Taylor's Version)", "Pop Country", 25, 35.00, "TAYLOR SWIFT", "Republic Records", "EUA", "imagens/fearless.jpg"));
produtos.add(new Cd("K-12", "Alternativo", 25, 50.00, "MELANIE MARTINEZ", "Atlantic Records", "EUA", "imagens/k12.jpg"));
produtos.add(new Cd("Legends Never Die", "Hip-Hop", 25, 34.50, "JUICE WRLD", "Grade A/Interscope", "EUA", "imagens/legendsneverdie.jpg"));
produtos.add(new Cd("Midnights", "Pop", 25, 53.15, "TAYLOR SWIFT", "Republic Records", "EUA", "imagens/midnights.jpg"));
produtos.add(new Cd("Mayhem (CD Standard)", "Pop", 25, 100.00, "LADY GAGA", "Interscope", "EUA", "imagens/mayhem.jpg"));
produtos.add(new Cd("No.1", "K-pop", 25, 35.00, "BLACKPINK", "YG Entertainment", "Coreia do Sul", "imagens/no1.jpg"));
produtos.add(new Cd("Planet Her", "R&B", 25, 35.00, "DOJA CAT", "RCA Records", "EUA", "imagens/planether.jpg"));
produtos.add(new Cd("Red (Taylor's Version)", "Pop Country", 25, 35.00, "TAYLOR SWIFT", "Republic Records", "EUA", "imagens/red.jpg"));
produtos.add(new Cd("Rumours", "Rock", 25, 39.99, "FLEETWOOD MAC", "Warner Bros. Records", "EUA", "imagens/rumours.jpg"));
produtos.add(new Cd("Samba de Raiz", "Samba", 25, 29.90, "ZECA PAGODINHO", "Universal Music", "Brasil", "imagens/sambaderaiz.jpg"));
produtos.add(new Cd("S.O.S", "R&B", 25, 49.90, "SZA", "Top Dawg Entertainment", "EUA", "imagens/sos.jpg"));
produtos.add(new Cd("The Dark Side of the Moon", "Rock Progressivo", 25, 35.00, "PINK FLOYD", "Harvest Records", "Reino Unido", "imagens/darksideofthemoon.jpg"));
produtos.add(new Cd("The Life of Pablo", "Rap", 25, 35.00, "KANYE WEST", "GOOD Music", "EUA", "imagens/thelifeofpablo.jpg"));
produtos.add(new Cd("Unorthodox Junkebox", "Pop", 25, 120.00, "BRUNO MARS", "Atlantic Records", "EUA", "imagens/unorthodoxjunkebox.jpg"));
produtos.add(new Cd("Viva la Vida", "Alternativo", 25, 50.00, "COLDPLAY", "Parlophone", "Reino Unido", "imagens/vivalavida.jpg"));

produtos.add(new Dvd("A Culpa é das Estrelas", "Romance", 15, 29.90, "Josh Boone", "125 min", "12 anos", "imagens/aculpaedasestrelas.jpg"));
produtos.add(new Dvd("A Espera de um Milagre", "Drama", 12, 39.90, "Frank Darabont", "189 min", "14 anos", "imagens/aesperadeummilagre.jpg"));
produtos.add(new Dvd("A Freira", "Terror", 20, 34.90, "Corin Hardy", "96 min", "16 anos", "imagens/afreira.jpg"));
produtos.add(new Dvd("A Mentira", "Comédia", 18, 39.90, "Will Gluck", "92 min", "14 anos", "imagens/amentira.jpg"));
produtos.add(new Dvd("Ainda Estou Aqui", "Drama", 20, 34.90, "José Eduardo Belmonte", "120 min", "12 anos", "imagens/aindaestouaqui.jpg"));
produtos.add(new Dvd("A Teoria de Tudo", "Biografia", 17, 39.90, "James Marsh", "123 min", "12 anos", "imagens/ateoriadetudo.jpg"));
produtos.add(new Dvd("Avengers: Endgame", "Ação", 25, 79.90, "Anthony Russo, Joe Russo", "181 min", "12 anos", "imagens/avengersendgame.jpg"));
produtos.add(new Dvd("Batman: O Cavaleiro das Trevas", "Ação", 20, 39.90, "Christopher Nolan", "152 min", "14 anos", "imagens/batmanocavaleirodastrevas.jpg"));
produtos.add(new Dvd("Blade Runner 2049", "Ficção Científica", 15, 59.90, "Denis Villeneuve", "164 min", "14 anos", "imagens/bladerunner2049.jpg"));
produtos.add(new Dvd("Cisne Negro", "Drama", 10, 49.90, "Darren Aronofsky", "108 min", "16 anos", "imagens/cisnenegro.jpg"));
produtos.add(new Dvd("Coco", "Animação", 22, 49.90, "Lee Unkrich, Adrian Molina", "105 min", "Livre", "imagens/coco.jpg"));
produtos.add(new Dvd("Divertida Mente", "Animação", 30, 39.90, "Pete Docter", "95 min", "Livre", "imagens/divertidamente.jpg"));
produtos.add(new Dvd("E Se Fosse Verdade?", "Romance", 14, 29.90, "Mark Waters", "95 min", "10 anos", "imagens/esefosseverdade.jpg"));
produtos.add(new Dvd("Hereditary: O Herdeiro", "Terror", 12, 39.90, "Ari Aster", "127 min", "16 anos", "imagens/hereditary.jpg"));
produtos.add(new Dvd("Interestelar", "Ficção Científica", 18, 59.90, "Christopher Nolan", "169 min", "10 anos", "imagens/interestelar.jpg"));
produtos.add(new Dvd("It: A Coisa", "Terror", 15, 49.90, "Andy Muschietti", "135 min", "16 anos", "imagens/itacoisa.jpg"));
produtos.add(new Dvd("John Wick", "Ação", 20, 39.90, "Chad Stahelski", "101 min", "16 anos", "imagens/johnwick.jpg"));
produtos.add(new Dvd("Mad Max: Fury Road", "Ação", 17, 49.90, "George Miller", "120 min", "14 anos", "imagens/madmaxfuryroad.jpg"));
produtos.add(new Dvd("O Casamento do Meu Melhor Amigo", "Comédia Romântica", 15, 29.90, "P.J. Hogan", "105 min", "10 anos", "imagens/ocasamentodomelhoramigo.jpg"));
produtos.add(new Dvd("O Curioso Caso de Benjamin Button", "Drama", 13, 49.90, "David Fincher", "166 min", "14 anos", "imagens/obenjaminbutton.jpg"));
produtos.add(new Dvd("O Diário de Bridget Jones", "Comédia Romântica", 14, 29.90, "Sharon Maguire", "97 min", "12 anos", "imagens/bridgetjones.jpg"));
produtos.add(new Dvd("O Iluminado", "Terror", 16, 39.90, "Stanley Kubrick", "146 min", "16 anos", "imagens/oiluminado.jpg"));
produtos.add(new Dvd("O Lado Bom da Vida", "Drama", 12, 39.90, "David O. Russell", "122 min", "12 anos", "imagens/oladobomdavida.jpg"));
produtos.add(new Dvd("Orgulho e Preconceito", "Romance", 20, 39.90, "Joe Wright", "129 min", "12 anos", "imagens/orgulhoepreconceito.jpg"));
produtos.add(new Dvd("Vingadores: Ultimato", "Ação", 25, 69.90, "Anthony Russo, Joe Russo", "181 min", "12 anos", "imagens/vingadoresultimato.jpg"));

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

