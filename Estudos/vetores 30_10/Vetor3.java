/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vetor3;

import java.util.Arrays;
import java.util.Scanner;
public class Vetor3 {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[50];
        
        // Receber 50 nomes do usuário
        System.out.println("Digite 50 nomes:");
        for (int i = 0; i < 50; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }

        // Ordenar os nomes em ordem crescente
        Arrays.sort(nomes);

        // Exibir os nomes ordenados
        System.out.println("\nNomes em ordem crescente:");
        for (String nome : nomes) {
            // Exibir apenas nomes não vazios
            if (nome != null && !nome.isEmpty()) {
                System.out.println(nome);
            }
        }
   }
}

