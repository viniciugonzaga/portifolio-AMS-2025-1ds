/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcarro;

import javax.swing.JTextArea;

public class ExecultCarro2 {
    
     public String cor;
    public String modelo;
    public String motor;
    public String nome;

    public void ligar(JTextArea area) {
        area.append("🔑 Ligando o carro...\n");
    }

    public void desligar(JTextArea area) {
        area.append("🛑 Desligando o carro...\n");
    }

    public void acelerar(JTextArea area) {
        area.append("🏎️ Acelerando o carro...\n");
    }

    public void brecar(JTextArea area) {
        area.append("🛞 Freando o carro...\n");
    }

    public void mudarMarcha(JTextArea area) {
        area.append("⚙️ Engatando a marcha...\n");
    }
}
    

