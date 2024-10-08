/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ordenarnumeros7;

import java.util.Arrays;

/**
 *
 * @author Vinicius
 */
public class OrdenarNumeros7 {

   public static void main(String[] args) {
    String[] nomes = {
            "Botafogo", "Palmeiras", "Fortaleza", "Flamengo", "São Paulo", 
            "Bahia", "Cruzeiro", "Internacional", "Vasco", "Atlético-MG", 
            "Juventude", "RB Bragantino", "Athletico-PR", "Grêmio", "Criciúma", 
            "Fluminense", "Corinthians", "Vitória", "Cuiabá", "Atlético-GO"
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
