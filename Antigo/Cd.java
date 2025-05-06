/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

// Classe que representa um CD, herda de Produto
// Classe que representa um CD, herda de Produto
public class Cd extends Produto {
    // Atributos específicos de CD
    private String artista;
    private String gravadora;
    private String paisDeOrigem;

    // Construtor da classe Cd
    // Chama o construtor da superclasse (Produto), passando "CD" como categoria
    public Cd(String descricao, String genero, int estoque, double preco, String artista, String gravadora, String paisDeOrigem) {
        // Chama o construtor da superclasse, passando a categoria "CD"
        super(descricao, genero, estoque, preco, "CD");
        this.artista = artista;
        this.gravadora = gravadora;
        this.paisDeOrigem = paisDeOrigem;
    }

    // Sobrescreve o método exibirInformacoes para incluir detalhes específicos de CD
    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() + // Chama o método da superclasse para informações básicas
               "\nArtista: " + artista +
               "\nGravadora: " + gravadora +
               "\nPaís de Origem: " + paisDeOrigem;
    }

    // Getters específicos para CD (se necessário)
    public String getArtista() {
        return artista;
    }

    public String getGravadora() {
        return gravadora;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }
}
