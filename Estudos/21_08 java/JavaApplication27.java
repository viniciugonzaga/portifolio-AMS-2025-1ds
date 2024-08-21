/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2.pkg7;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JavaApplication27 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Solicitar ao usuário que insira a primeira data
        System.out.print("Digite a primeira data (dd/MM/aaaa): ");
        LocalDate data1 = LocalDate.parse(scanner.nextLine(), formatter);

        // Solicitar ao usuário que insira a segunda data
        System.out.print("Digite a segunda data (dd/MM/aaaa): ");
        LocalDate data2 = LocalDate.parse(scanner.nextLine(), formatter);

        // Fechar o scanner
        scanner.close();

        // Comparar e exibir as datas em ordem crescente
        if (data1.isBefore(data2)) {
            System.out.println("Datas em ordem crescente:");
            System.out.println(data1.format(formatter));
            System.out.println(data2.format(formatter));
        } else if (data1.isAfter(data2)) {
            System.out.println("Datas em ordem crescente:");
            System.out.println(data2.format(formatter));
            System.out.println(data1.format(formatter));
        } else {
            System.out.println("As duas datas são iguais.");
        }
         
         
         
         
         
    }
    
}
