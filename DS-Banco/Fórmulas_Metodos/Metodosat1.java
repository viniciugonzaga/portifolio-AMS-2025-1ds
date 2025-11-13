/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.metodosat1;


import javax.swing.JOptionPane;

public class Metodosat1 {

    public static void main(String[] args) {
          
        double num1 = 10; 
        double num2 = 5;

        // Exibir todas as operações no console
        System.out.println("Soma: " + soma(num1, num2));
        System.out.println("Subtração: " + subtracao(num1, num2));
        System.out.println("Divisão: " + divisao(num1, num2));
        System.out.println("Multiplicação: " + multiplicacao(num1, num2));
        System.out.println("Resto da Divisão: " + restoDivisao(num1, num2));
        System.out.println("Dobro: " + dobro(num1));
        System.out.println("Quadrado: " + quadrado(num1));
        System.out.println("Cubo: " + cubo(num1));
        System.out.println("Raiz Quadrada: " + raizQuadrada(num1));
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

