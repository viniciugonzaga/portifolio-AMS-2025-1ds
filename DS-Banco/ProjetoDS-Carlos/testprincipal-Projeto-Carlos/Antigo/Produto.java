/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

// Classe base para todos os produtos da livraria
public class Produto {

    // Atributos comuns a todos os produtos
    private String descricao;
    private String genero;
    private int estoque;
    private double preco;
    private String categoria; // Campo para armazenar a categoria do produto

    // Construtor da classe Produto
    // Recebe todos os atributos comuns, incluindo a categoria
    public Produto(String descricao, String genero, int estoque, double preco, String categoria) {
        this.descricao = descricao;
        this.genero = genero;
        this.estoque = estoque;
        this.preco = preco;
        this.categoria = categoria; // Define a categoria do produto
    }

    // Métodos getters para acessar os atributos
    public String getDescricao() {
        return descricao;
    }

    public String getGenero() {
        return genero;
    }

    public int getEstoque() {
        return estoque;
    }

    public double getPreco() {
        return preco;
    }

    // Getter para a categoria do produto
    public String getCategoria() {
        return categoria;
    }

    // Método para exibir informações básicas do produto (pode ser sobrescrito pelas subclasses)
    public String exibirInformacoes() {
        return "Descrição: " + descricao +
               "\nCategoria: " + categoria +
               "\nGênero: " + genero +
               "\nEstoque: " + estoque +
               "\nPreço: R$" + String.format("%.2f", preco); // Formata o preço
    }
}


