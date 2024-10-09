/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vetor4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Vetor4 {

   
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[50];
        
         System.out.println("Digite 50 nomes:");
         
        for (int i = 0; i < 50; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }

        // Ordenar os nomes em ordem decrescente
        Arrays.sort(nomes, Collections.reverseOrder());

        // Exibir os nomes ordenados
        System.out.println("\nNomes em ordem decrescente:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

    }
    
}

    
