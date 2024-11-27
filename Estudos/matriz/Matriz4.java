/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matriz4;

import javax.swing.JOptionPane;
public class Matriz4 {

    public static void main(String[] args) {
        double[][] matriz = {
            {4.5, 5.2, 2.4},
            {4.2, 2.1, 3.0}
        };

        // Exibindo os valores da matriz
        StringBuilder mensagem = new StringBuilder("Valores da Matriz:\n");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                mensagem.append("Linha ").append(i + 1).append(", Coluna ").append(j + 1)
                        .append(": ").append(matriz[i][j]).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, mensagem.toString());
    }
}
