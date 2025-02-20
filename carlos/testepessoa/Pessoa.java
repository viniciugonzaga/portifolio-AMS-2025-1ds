/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testepessoa;

/**
 *
 * @author dti
 */
public class Pessoa {
    
     String nome ;
    String idade ;
    
    void Pessoa (String nome, String idade){
    this.nome = nome;
    this.idade = idade;        
    }
    void definirNome(String Valor){
        nome = Valor;
    }
    void retornarNome(){
        System.out.println(nome);
    }
      
    void definirIdade(String Valor){
        idade = Valor;
    }
     void retornarIdade (){
       System.out.println(idade);
    }
}
