/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2.pkg4;
import java.util.Scanner;

public class JavaApplication24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        System.out.print("Escolha um número de 1 a 12(mês): ");
        int mes = scanner.nextInt();
        
        switch(mes) {
        case 1:
                System.out.println("Seu número escolhido é o mês de janeiro");
                break;
            case 2:
                System.out.println("Seu número escolhido é o mês de fevereiro");
                break;
            case 3:
                System.out.println("Seu número escolhido é o mês de março");
                break;
            case 4:
                System.out.println("Seu número escolhido é o mês de abril");
                break;
            case 5:
                System.out.println("Seu número escolhido é o mês de maio");
                break;
        case 6:
                System.out.println("Seu número escolhido é o mês de junho");
                break;
            case 7:
                System.out.println("Seu número escolhido é o mês de julho");
                break;
            case 8:
                System.out.println("Seu número escolhido é o mês de agosto");
                break;
            case 9:
                System.out.println("Seu número escolhido é o mês de setembro");
                break;
                   case 10:
                System.out.println("Seu número escolhido é o mês de outubro");
                break;
            case 11:
                System.out.println("Seu número escolhido é o mês de novembro");
                break;
            case 12:
                System.out.println("Seu número escolhido é o mês de dezembro");
                break;
            default:
                System.out.println("número não reconheido");
                
                
        
    }
    }
}
