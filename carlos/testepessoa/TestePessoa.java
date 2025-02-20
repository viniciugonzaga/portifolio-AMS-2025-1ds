/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testepessoa;




public class TestePessoa {

    public static void main(String[] args) {
        
     Pessoa pes = new Pessoa();
     
     Professor prof = new Professor();
     
     prof.idade = "55 anos";
     prof.nome = "Carlos";
     prof.formacao = "Ciencias da Computação";
     
     System.out.println("nome: "+ prof.nome + ","+"Idade: "+prof.idade + ","+ "Formação: " +prof.formacao);
             
     Aluno alu = new Aluno();
     
     alu.idade = "16 anos";
     alu.nome = "Vinícius";
     alu.curso = "Desenvolvimento de Sistemas";
     
     System.out.println("nome: "+ alu.nome + ","+"Idade: "+alu.idade + ","+ "Formação: " +alu.curso);
     
     
     
     
     
     

        
        
    }
}
