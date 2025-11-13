/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

import java.util.Objects;

public class Produto {
    private String descricao;
    private String genero;
    private int estoque;
    private double preco;
    private String categoria;
    private String caminhoImagem;
    private String descricaoDetalhada; // Novo campo para a descrição detalhada

    public Produto(String descricao, String genero, int estoque, double preco, String categoria, String caminhoImagem, String descricaoDetalhada) {
        this.descricao = descricao;
        this.genero = genero;
        this.estoque = estoque;
        this.preco = preco;
        this.categoria = categoria;
        this.caminhoImagem = caminhoImagem;
        this.descricaoDetalhada = descricaoDetalhada;
    }

    // Getters para os atributos (incluindo getDescricaoDetalhada)
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

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    // Setters para os atributos (se necessário)
    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }


    public String exibirInformacoes() {
        return "Descrição: " + descricao +
               "\nCategoria: " + categoria +
               "\nGênero: " + genero +
               "\nEstoque: " + estoque +
               "\nPreço: R$" + String.format("%.2f", preco);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        // Comparar os atributos que tornam dois produtos iguais.
        // Geralmente, a descrição e a categoria podem ser suficientes para identificar um produto único.
        // Você pode adicionar mais campos se necessário.
        return Objects.equals(descricao, produto.descricao) &&
               Objects.equals(categoria, produto.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, categoria);
    }
}