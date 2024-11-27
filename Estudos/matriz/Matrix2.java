/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matrix2;

import java.util.HashSet;
import java.util.Random;
public class Matrix2 {

    public static void main(String[] args) {
       int[][] matriz = new int[3][5];
        Random random = new Random();

     
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = random.nextInt(50) + 1; 
            }
        }

       
        System.out.println("Matriz 3x5:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        
        boolean temRepetidos = false;
        HashSet<Integer> elementos = new HashSet<>(); 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (!elementos.add(matriz[i][j])) { 
                    temRepetidos = true; 
                }
            }
        }
        System.out.println("\nA matriz possui elementos repetidos? " + (temRepetidos ? "Sim" : "Não"));

     
        int contPares = 0;
        int contImpares = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (matriz[i][j] % 2 == 0) {
                    contPares++;
                } else {
                    contImpares++;
                }
            }
        }
        System.out.println("\nQuantidade de números pares: " + contPares);

       
        System.out.println("Quantidade de números ímpares: " + contImpares);
    }
}
