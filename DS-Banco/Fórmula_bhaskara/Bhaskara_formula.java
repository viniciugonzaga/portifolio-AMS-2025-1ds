/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bhaskara_formula;

import java.util.Scanner;

public class Bhaskara_formula {

    public static void main(String[] args) {
       
          Scanner scanner = new Scanner(System.in);

        // Solicitar coeficientes ao usuário
        System.out.print("Digite o valor de a: ");
        double a = scanner.nextDouble();
        System.out.print("Digite o valor de b: ");
        double b = scanner.nextDouble();
        System.out.print("Digite o valor de c: ");
        double c = scanner.nextDouble();

        // Calcular o delta
        double delta = (b * b) - (4 * a * c);

        // Verificar se existem raízes reais
        if (delta < 0) {
            System.out.println("Não existem raízes reais.");
        } else {
            // Calcular as raízes
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);

            // Exibir os resultados
            System.out.println("As raízes da equação são:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }

        scanner.close(); // Fechar o scanner
        
        
    }
}
