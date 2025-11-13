/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

public class Livro extends Produto {
    private String autor;
    private String editora;
    private String edicao;

    public Livro(String descricao, String genero, int estoque, double preco, String autor, String editora, String edicao, String caminhoImagem, String descricaoDetalhada) {
        super(descricao, genero, estoque, preco, "Livro", caminhoImagem, descricaoDetalhada);
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
    }

    // Getters para autor, editora, edicao
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