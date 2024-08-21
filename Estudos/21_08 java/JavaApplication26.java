/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2.pkg6;

import java.util.Scanner;


public class JavaApplication26 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in); 
      
       System.out.print("Digite a idade do nadador: ");
        int idade = scanner.nextInt();
      
       String etapa;
        if (idade >= 5 && idade <= 7) {
            etapa = "Infantil A";
        } else if (idade >= 8 && idade <= 10) {
            etapa = "Infantil B";
        } else if (idade >= 11 && idade <= 13) {
            etapa = "Juvenil A";
        } else if (idade >= 14 && idade <= 17) {
            etapa = "Juvenil B";
        } else if (idade >= 18) {
            etapa = "Senior";
        } else {
           etapa = "Idade fora do intervalo válido";
        }
        
          System.out.println("Categoria: " + etapa);
      
      
      
      
      
      
      
      
    }
    
}
