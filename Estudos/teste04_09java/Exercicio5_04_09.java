/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio5_04_09;

import java.util.Scanner;


public class Exercicio5_04_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int valorInicial = scanner.nextInt();
        
       
        System.out.print("Digite o valor final: ");
        int valorFinal = scanner.nextInt();
        
        
        if (valorInicial > valorFinal) {
            System.out.println("O valor inicial deve ser menor ou igual ao valor final.");
        } else {
           
            if (valorInicial % 2 != 0) {
                valorInicial++;
            }
            
           
            System.out.println("Números pares entre " + valorInicial + " e " + valorFinal + ":");
            for (int i = valorInicial; i <= valorFinal; i += 2) {
                System.out.println(i); // Exibe o número par
            }
        
        
        
        
    }
    
}
