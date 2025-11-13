/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exemplocarro;

import java.util.Scanner;

public class ExemploCarro {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        
        Carro UmCarro = new Carro();
        
        UmCarro.modelo = "gol";
        UmCarro.cor = "preto";
        UmCarro.motor = "1.0";
        UmCarro.nome = "Seu Carrinho: ";
        
        
         UmCarro.ligar();
         UmCarro.mudarMarcha();
         UmCarro.acelerar();
         UmCarro.brecar(); 
         UmCarro.desligar();
         
         
         System.out.println("");
         System.out.println(UmCarro.nome);
         System.out.println("");
         System.out.println(UmCarro.modelo);
         System.out.println(UmCarro.cor);
         System.out.println(UmCarro.motor);
         System.out.println("");
         
         UmCarro = null;
        
    }
}
