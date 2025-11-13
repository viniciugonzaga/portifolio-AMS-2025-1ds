/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testepessoa2;

/**
 *
 * @author Vinicius
 */
public class Professor extends Pessoa{
       
     String formacao;
    
   void Aluno(){
        this.formacao = formacao;
    }
    void definirCurso(String val_formacao){
      
        formacao = val_formacao;
    }
    void retornarCurso(){
        
         System.out.println(formacao);
    }
}
