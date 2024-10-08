/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ordenarnomes4;
import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author Vinicius
 */
public class OrdenarNomes4 {

    public static void main(String[] args) {
  String[] nomes = {
            "Ana", "Beatriz", "Carlos", "Daniel", "Eduardo", "Fernanda", "Gabriela", "Henrique", "Isabel", "João", 
"Karen", "Lucas", "Mariana", "Nathalia", "Otávio", "Pedro", "Quésia", "Ricardo", "Sofia", "Thiago", 
"Ubiratan", "Valéria", "William", "Xavier", "Yara", "Zilda", "Bruno", "Camila", "Diego", "Elisa", 
"Felipe", "Giovana", "Heitor", "Ícaro", "Juliana", "Leonardo", "Melissa", "Nícolas", "Olga", "Paulo", 
"Quirino", "Rafael", "Sabrina", "Tânia", "Ulisses", "Vanessa", "Wagner", "Yasmin", "Zeca", "Vicente"
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