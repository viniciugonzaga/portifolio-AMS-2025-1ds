/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2.pkg3;
import java.util.Scanner;
/**
 *
 * @author FATEC ZONA LESTE
 */
public class JavaApplication23 {
    public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in); 
   
    System.out.println("Menu de Opções de lanches:");
        System.out.println("1. BigMac");
        System.out.println("2. Quarteirão");
        System.out.println("3. MacChicken");
        System.out.println("4. Cheddar");
        System.out.println("5. Cheese Burger");
        System.out.print("Digite o número da opção desejada: ");
        int opcao = scanner.nextInt();
          switch (opcao) {
            case 1:
                System.out.println("Você escolheu: BigMac.");
                break;
            case 2:
                System.out.println("você escolheu: Quarteirão.");
                break;
            case 3:
                System.out.println("Você escolheu: MacChicken.");
                break;
            case 4:
                System.out.println("Você escolheu: Cheddar.");
                break;
            case 5:
                System.out.println("Você escolheu: Cheese Burger.");
                break;
            default:
                System.out.println("Não existe essa opção.");
                break; 
    }
    }
}
