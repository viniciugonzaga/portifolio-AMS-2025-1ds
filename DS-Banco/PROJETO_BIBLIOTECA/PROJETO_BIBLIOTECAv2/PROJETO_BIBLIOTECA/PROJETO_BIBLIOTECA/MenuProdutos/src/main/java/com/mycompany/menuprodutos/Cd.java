/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

public class Cd extends Produto {
    // Atributos específicos de CD
    private String artista;
    private String gravadora;
    private String paisDeOrigem;

    // Construtor da classe Cd
    // Chama o construtor da superclasse (Produto), passando "CD" como categoria
    public Cd(String descricao, String genero, int estoque, double preco, String artista, String gravadora, String paisDeOrigem, String caminhoImagem, String descricaoDetalhada) {
        super(descricao, genero, estoque, preco, "CD", caminhoImagem, descricaoDetalhada);
        this.artista = artista;
        this.gravadora = gravadora;
        this.paisDeOrigem = paisDeOrigem;
    }

    // Getters para artista, gravadora, paisDeOrigem
    public String getArtista() {
        return artista;
    }

    public String getGravadora() {
        return gravadora;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    // Setters (se necessário)
}