/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matriz5;

/**
 *
 * @author Vinicius
 */
import javax.swing.JOptionPane;
public class Matriz5 {

    public static void main(String[] args) {
         final int N_Lin = 3, N_Col = 3; // Define uma matriz 3x3
        int[][] mat = new int[N_Lin][N_Col];
        
        // Entrada de dados para preencher a matriz
        JOptionPane.showMessageDialog(null, "**** Cadastro de valores na matriz ****\n"
                + "Insira os valores de cada posição da matriz:");

        for (int l = 0; l < N_Lin; l++) {
            for (int c = 0; c < N_Col; c++) {
                mat[l][c] = Integer.parseInt(JOptionPane.showInputDialog("Valor para a linha " + (l + 1)
                        + " e coluna " + (c + 1) + ":"));
            }
        }

        // Exibição dos dados preenchidos na matriz
        JOptionPane.showMessageDialog(null, "**** Exibindo os dados da matriz ****");

        StringBuilder resultado = new StringBuilder();
        for (int l = 0; l < N_Lin; l++) {
            for (int c = 0; c < N_Col; c++) {
                resultado.append(mat[l][c]).append("\t"); // Exibição tabulada
            }
            resultado.append("\n"); // Próxima linha
        }

        JOptionPane.showMessageDialog(null, "Matriz preenchida:\n" + resultado.toString());
    }
}
