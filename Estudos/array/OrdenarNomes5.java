/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ordenarnomes5;

/**
 *
 * @author Vinicius
 */
public class OrdenarNomes5 {

    public static void main(String[] args) {
        
        int[] numeros = new int[100];

        
        for (int i = 0; i < 100; i++) {
            numeros[i] = i + 1;
        }

       
        System.out.println("Números pares no array:");
        for (int i = 0; i < 100; i++) {
            if (numeros[i] % 2 == 0) { 
                System.out.println(numeros[i]);
            }
        }
    }
}