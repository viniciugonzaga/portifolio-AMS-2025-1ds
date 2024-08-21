/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2.pkg2;
import java.util.Scanner;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class JavaApplication22 {

    public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);      
        
  System.out.print("Digite quantos kg vc tem: ");  
  double kg = scanner.nextDouble();
  
   System.out.print("Digite quanto você mede de altura: ");  
  double altura = scanner.nextDouble();
  
  double imc = kg/altura;
  
  if (imc >= 0 && imc < 18) {
            System.out.println(" Magreza ");
        } 
  else if (imc >= 18.1 && imc < 24.9) {
            System.out.println("Saudável ");
        } 
  else if (imc >= 25 && imc < 29.9) {
            System.out.println("Sobrepeso ");
        } 
  else if (imc >= 30) {
            System.out.println("obesidade ");
        } 
  else {
            System.out.println("dados inválidos ");
        }
  
        
        
        
        
    }
    
}
