/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ordenarnomes1;

import java.util.Arrays;
public class OrdenarNomes1 {

     public static void main(String[] args) {
      
        String[] nomes = {
            "Vinicius", "Carlos", "Amanda", "Bruno", "Fernanda",
            "Isabel", "Eduardo", "Daniel", "Ana", "Jorge"
        };

     
        System.out.println("Nomes antes da ordenação:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

       
        Arrays.sort(nomes);

       
        System.out.println("\nNomes após a ordenação:");
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}