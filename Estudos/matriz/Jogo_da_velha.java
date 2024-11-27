/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jogo_da_velha;

/**
 *
 * @author Vinicius
 */
import java.util.Scanner;
public class Jogo_da_velha {

    public static void main(String[] args) {
        char[][] tabuleiro = new char[3][3]; // Tabuleiro 3x3
        inicializarTabuleiro(tabuleiro);

        Scanner scanner = new Scanner(System.in);
        boolean jogoAtivo = true;
        char jogadorAtual = 'X'; // Começa com o jogador X

        while (jogoAtivo) {
            exibirTabuleiro(tabuleiro);
            System.out.println("Vez do jogador " + jogadorAtual);
            System.out.print("Digite a linha (0-2): ");
            int linha = scanner.nextInt();
            System.out.print("Digite a coluna (0-2): ");
            int coluna = scanner.nextInt();

            // Verifica se a jogada é válida
            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogadorAtual;

                // Verifica se o jogador atual venceu
                if (verificarVencedor(tabuleiro, jogadorAtual)) {
                    exibirTabuleiro(tabuleiro);
                    System.out.println("Jogador " + jogadorAtual + " venceu!");
                    jogoAtivo = false;
                } else if (verificarEmpate(tabuleiro)) {
                    exibirTabuleiro(tabuleiro);
                    System.out.println("Empate!");
                    jogoAtivo = false;
                } else {
                    // Troca o jogador
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Jogada inválida! Tente novamente.");
            }
        }

        scanner.close();
    }

    // Inicializa o tabuleiro com espaços vazios
    private static void inicializarTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    // Exibe o tabuleiro no console
    private static void exibirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
    }

    // Verifica se o jogador venceu
    private static boolean verificarVencedor(char[][] tabuleiro, char jogador) {
        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
                (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
                return true;
            }
        }
        // Verifica diagonais
        if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
            (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)) {
            return true;
        }
        return false;
    }

    // Verifica se o jogo terminou em empate
    private static boolean verificarEmpate(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false; // Ainda há espaços vazios
                }
            }
        }
        return true; // Não há espaços vazios
    }
}
