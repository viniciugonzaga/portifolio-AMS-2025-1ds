/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

public class Dvd extends Produto {
    // Atributos específicos de DVD
    private String diretor;
    private String duracao;
    private String censura;

    // Construtor da classe Dvd
    // Chama o construtor da superclasse (Produto), passando "DVD" como categoria
    public Dvd(String descricao, String genero, int estoque, double preco, String diretor, String duracao, String censura, String caminhoImagem, String descricaoDetalhada) {
        super(descricao, genero, estoque, preco, "DVD", caminhoImagem, descricaoDetalhada);
        this.diretor = diretor;
        this.duracao = duracao;
        this.censura = censura;
    }

    // Getters para diretor, duracao, censura
    public String getDiretor() {
        return diretor;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getCensura() {
        return censura;
    }

    // Setters (se necessário)
}