/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testepessoa2;

import javax.swing.JOptionPane;

public class TestePessoa2 {

    public static void main(String[] args) {
      
     Pessoa pes = new Pessoa();
     
     Professor prof = new Professor();
     
     prof.nome = JOptionPane.showInputDialog("Digite o nome:");
     prof.idade = JOptionPane.showInputDialog("Digite a idade:");
     prof.formacao = JOptionPane.showInputDialog("Digite a formação:");
     
     System.out.println("nome: "+ prof.nome + ","+"Idade: "+prof.idade + ","+ "Formação: " +prof.formacao);
             
     Aluno alu = new Aluno();
     
       
     alu.idade = JOptionPane.showInputDialog("Digite o nome:");
     alu.nome = JOptionPane.showInputDialog("Digite a idade:");
     alu.curso = JOptionPane.showInputDialog("Digite a formação:");
     
     System.out.println("nome: "+ alu.nome + ","+"Idade: "+alu.idade + ","+ "Formação: " +alu.curso);
     
        
    }
}
