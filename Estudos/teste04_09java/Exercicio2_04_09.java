/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio2_04_09;

import java.util.Scanner;


public class Exercicio2_04_09 {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        
        
     System.out.println("Seu número da tabuada é:  ");
             int nu = scanner.nextInt();
             for (int i = 1; i <= 10; i++) {
                 
            int resultado = nu * i;
            System.out.println(nu + " x " + i + " = " + resultado);
        }
             
             
             
             
             
     
        
    }
    
}
