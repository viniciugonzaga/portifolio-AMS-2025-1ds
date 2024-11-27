/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matriz3;

import java.util.Random;
public class Matriz3 {

    public static void main(String[] args) {
         double[][] matriz = new double[4][4];
        Random random = new Random();

        // Preenchendo a matriz com valores aleatórios entre 0 e 100 (com 2 casas decimais)
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = Math.round((random.nextDouble() * 100) * 100.0) / 100.0; // Arredondar para 2 casas
            }
        }

        // Exibindo a matriz
        System.out.println("Matriz 4x4:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%.2f\t", matriz[i][j]);
            }
            System.out.println();
        }

        // a) Exibindo a diagonal principal
        System.out.println("\nValores da diagonal principal:");
        for (int i = 0; i < 4; i++) {
            System.out.printf("%.2f ", matriz[i][i]);
        }

        // b) Exibindo a diagonal secundária
        System.out.println("\n\nValores da diagonal secundária:");
        for (int i = 0; i < 4; i++) {
            System.out.printf("%.2f ", matriz[i][3 - i]);
        }
    }
}
