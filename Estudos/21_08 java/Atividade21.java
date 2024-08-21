/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividade.pkg2.pkg1;
import java.util.Scanner;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class Atividade21 {
    public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 
 System.out.print("Digite a hora de início do turno (0 a 23): ");
 int hora =  scanner.nextInt();
 
  if (hora >= 5 && hora < 13) {
            System.out.println("Turno Manhã");
        } 
  else if (hora >= 13 && hora < 21) {
            System.out.println("Turno Tarde");
        } 
  else {
            System.out.println("Turno Noite");
        }
        
        
        
        
        
        
    }
    
}
