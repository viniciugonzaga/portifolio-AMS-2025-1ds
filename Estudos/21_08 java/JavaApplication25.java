/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2.pkg5;

import java.util.Scanner;


 
public class JavaApplication25 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in); 
        
        System.out.print("digite sua (primeira) nota: ");
        double nota1 = scanner.nextDouble();
         System.out.print("digite sua (segunda) nota: ");
        double nota2 = scanner.nextDouble();
         System.out.print("digite sua (terça) nota: ");
        double nota3 = scanner.nextDouble();
         System.out.print("digite sua (quarta) nota: ");
        double nota4 = scanner.nextDouble();
        
        double media = (nota1+nota2+nota3+nota4)/4;
        System.out.println("Sua média é: " + media);
        
        
       char conceito;
        if (media >= 9) {
            conceito = 'A';
        } else if (media >= 7) {
            conceito = 'B';
        } else if (media >= 5) {
            conceito = 'C';
        } else if (media >= 2.5) {
            conceito = 'D';
        } else {
            conceito = 'E';
        }
  
         if (conceito == 'A' || conceito == 'B' || conceito == 'C') {
            System.out.println("Conceito: " + conceito + " - Aprovado");
        } else {
            System.out.println("Conceito: " + conceito + " - Reprovado");
        }
        
        
        
        
    }
    
}
