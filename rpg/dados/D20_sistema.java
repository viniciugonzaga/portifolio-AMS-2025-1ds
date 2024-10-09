/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package d20_sistema;
import java.util.Random;
import java.util.Scanner;
public class D20_sistema {

    
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
          System.out.println("Role o dado(enter): ");
        scanner.nextLine();
        
        int resultado = random.nextInt(20) + 1;
        System.out.println("Você rolou o numero: " + resultado + "!");
        
        
        if (resultado >= 1 && resultado <= 5) {
    System.out.println("Fracasso total");
} else if (resultado >= 6 && resultado <= 10) {
    System.out.println("Normal");
} else if (resultado >= 11 && resultado <= 15) {
    System.out.println("Bom");
} else if (resultado >= 16 && resultado <= 19) {
    System.out.println("Muito bom");
} else if (resultado == 20) {
    System.out.println("Extremo");
} else {
    System.out.println("Número fora do intervalo esperado.");
}
        
        
        scanner.close();
        
        
    }
    
}
