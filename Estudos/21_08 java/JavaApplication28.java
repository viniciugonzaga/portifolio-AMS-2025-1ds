/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2.pkg8;

import java.util.Scanner;


public class JavaApplication28 {

  
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        
        System.out.print("Digite o comprimento do lado A (em cm): ");
        double a = scanner.nextDouble();
        System.out.print("Digite o comprimento do lado B (em cm): ");
        double b = scanner.nextDouble();
        System.out.print("Digite o comprimento do lado C (em cm): ");
        double c = scanner.nextDouble();     
          
        if (a + b > c && a + c > b && b + c > a) {
            
            if (a == b && b == c) {
                System.out.println("O triângulo é equilátero.");
            } else if (a == b || a == c || b == c) {
                System.out.println("O triângulo é isósceles.");
            } else {
                System.out.println("O triângulo é escaleno.");
            }
        } else {
            System.out.println("Os valores fornecidos não formam um triângulo.");
        }              
    }
    
}
