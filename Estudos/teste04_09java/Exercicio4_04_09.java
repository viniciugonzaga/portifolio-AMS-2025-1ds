/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio4_04_09;

import java.util.Scanner;


public class Exercicio4_04_09 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
       System.out.print("Digite o valor inicial: ");
        int valorInicial = scanner.nextInt();
        
        
        System.out.print("Digite o valor final: ");
        int valorFinal = scanner.nextInt();
        
        
        int somaPares = 0;
        
       
        if (valorInicial > valorFinal) {
            System.out.println("O valor inicial deve ser menor que o valor final.");
        } else {
            
            for (int i = valorInicial; i <= valorFinal; i++) {
                if (i % 2 == 0) { 
                    somaPares += i; 
                }
            }
            
            
            System.out.println("A soma dos números pares entre " + valorInicial + " e " + valorFinal + " é: " + somaPares);
        }
          
          }
        
        
        
 
                   
        

            
        
        
        
        
    }
    
}
