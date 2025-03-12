/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.metodosati1;

import javax.swing.JOptionPane;

public class MetodosAti1 {

    public static void main(String[] args) {
        
    String inputNum1 = JOptionPane.showInputDialog("Digite o primeiro número (num1):");
        String inputNum2 = JOptionPane.showInputDialog("Digite o segundo número (num2):");

        // Converter as entradas para double
        double num1 = Double.parseDouble(inputNum1);
        double num2 = Double.parseDouble(inputNum2);

        // Criar mensagens para exibir no JOptionPane
        String mensagem = "Soma: " + soma(num1, num2) + "\n";
        mensagem += "Subtração: " + subtracao(num1, num2) + "\n";
        mensagem += "Divisão: " + divisao(num1, num2) + "\n";
        mensagem += "Multiplicação: " + multiplicacao(num1, num2) + "\n";
        mensagem += "Resto da Divisão: " + restoDivisao(num1, num2) + "\n";
        mensagem += "Dobro: " + dobro(num1) + "\n";
        mensagem += "Quadrado: " + quadrado(num1) + "\n";
        mensagem += "Cubo: " + cubo(num1) + "\n";
        mensagem += "Raiz Quadrada: " + raizQuadrada(num1);

        // Exibir a mensagem com todas as operações no JOptionPane
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static double soma(double a, double b) { return a + b; }
    public static double subtracao(double a, double b) { return a - b; }
    public static double divisao(double a, double b) { return b != 0 ? a / b : Double.NaN; }
    public static double multiplicacao(double a, double b) { return a * b; }
    public static double restoDivisao(double a, double b) { return a % b; }
    public static double dobro(double a) { return a * 2; }
    public static double quadrado(double a) { return a * a; }
    public static double cubo(double a) { return a * a * a; }
    public static double raizQuadrada(double a) { return Math.sqrt(a); }
        
    }

