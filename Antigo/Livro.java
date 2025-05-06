/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

// Classe que representa um Livro, herda de Produto
public class Livro extends Produto {
    // Atributos específicos de Livro
    private String autor;
    private String editora;
    private String edicao;

    // Construtor da classe Livro
    // Chama o construtor da superclasse (Produto), passando "LIVROS" como categoria
    public Livro(String descricao, String genero, int estoque, double preco, String autor, String editora, String edicao) {
        // Chama o construtor da superclasse, passando a categoria "LIVROS"
        super(descricao, genero, estoque, preco, "LIVROS");
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
    }

    // Sobrescreve o método exibirInformacoes para incluir detalhes específicos de Livro
    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() + // Chama o método da superclasse para informações básicas
               "\nAutor: " + autor +
               "\nEditora: " + editora +
               "\nEdição: " + edicao;
    }

    // Getters específicos para Livro (se necessário)
    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public String getEdicao() {
        return edicao;
    }
}
