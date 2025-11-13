/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testepessoa2;

/**
 *
 * @author Vinicius
 */
public class Aluno extends Pessoa {
      String curso;
   
    void Aluno(){
        this.curso = curso;
    }
   
    
    void definirCurso(String val_curso){
      
        curso = val_curso;
    }
    void retornarCurso(){
        
         System.out.println(curso);
    }
}
