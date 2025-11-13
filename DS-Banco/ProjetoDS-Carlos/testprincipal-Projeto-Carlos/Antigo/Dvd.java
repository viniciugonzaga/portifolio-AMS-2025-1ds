/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

// Classe que representa um DVD, herda de Produto
public class Dvd extends Produto {
    // Atributos específicos de DVD
    private String diretor;
    private String duracao;
    private String censura;

    // Construtor da classe Dvd
    // Chama o construtor da superclasse (Produto), passando "DVD" como categoria
    public Dvd(String descricao, String genero, int estoque, double preco, String diretor, String duracao, String censura) {
        // Chama o construtor da superclasse, passando a categoria "DVD"
        super(descricao, genero, estoque, preco, "DVD");
        this.diretor = diretor;
        this.duracao = duracao;
        this.censura = censura;
    }

    // Sobrescreve o método exibirInformacoes para incluir detalhes específicos de DVD
    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() + // Chama o método da superclasse para informações básicas
               "\nDiretor: " + diretor +
               "\nDuração: " + duracao +
               "\nCensura: " + censura;
    }

    // Getters específicos para DVD (se necessário)
    public String getDiretor() {
        return diretor;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getCensura() {
        return censura;
    }
}