/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matriz6;

/**
 *
 * @author Vinicius
 */
import javax.swing.JOptionPane;
public class Matriz6 {

    public static void main(String[] args) {
        int[][] matriz = {
            {14, 22, 31, 55},
            {22, 32, 55, 12}
        };

        // Exibição dos elementos pares da matriz
        JOptionPane.showMessageDialog(null, "****** Exibindo apenas os elementos pares da matriz ******");

        for (int i = 0; i < matriz.length; i++) { // Percorre as linhas
            for (int j = 0; j < matriz[i].length; j++) { // Percorre as colunas
                if (matriz[i][j] % 2 == 0) { // Verifica se o elemento é par
                    System.out.print(matriz[i][j] + " ");
                } else {
                    System.out.print("- "); // Imprime traço para valores ímpares
                }
            }
            System.out.println(); // Quebra de linha para formatar a matriz
        }
    }
}
