/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

public class Produto {

    private String descricao;
    private String genero;
    private int estoque;
    private double preco;
    private String categoria;
    private String caminhoImagem; // <- NOVO CAMPO

    public Produto(String descricao, String genero, int estoque, double preco, String categoria, String caminhoImagem) {
        this.descricao = descricao;
        this.genero = genero;
        this.estoque = estoque;
        this.preco = preco;
        this.categoria = categoria;
        this.caminhoImagem = caminhoImagem;
    }

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

    public String getCategoria() {
        return categoria;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public String exibirInformacoes() {
        return "Descrição: " + descricao +
               "\nCategoria: " + categoria +
               "\nGênero: " + genero +
               "\nEstoque: " + estoque +
               "\nPreço: R$" + String.format("%.2f", preco);
    }
}



