/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ordenarnomes2;
import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author Vinicius
 */
public class OrdenarNomes2 {

  public static void main(String[] args) {
        
        String[] nomes = {
            "Vinicius", "Carlos", "Amanda", "Bruno", "Fernanda",
            "Isabel", "Eduardo", "Daniel", "Ana", "Jorge",
            "Lucas", "Pedro", "Mariana", "Beatriz", "Sophia",
            "Thiago", "Ricardo", "Camila", "Gustavo", "Paula"
        };

       
        System.out.println("Nomes antes da ordenação:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        
        Arrays.sort(nomes);

       
        Collections.reverse(Arrays.asList(nomes));

        
        System.out.println("\nNomes em ordem decrescente:");
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}