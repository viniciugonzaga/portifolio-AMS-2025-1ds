/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.menuprodutos;

import javax.swing.SwingUtilities;


//Main
// Este é o método principal que inicia a aplicação Java.
// Ele é o ponto de entrada do programa quando você o executa.

public class MenuProdutos {

    public static void main(String[] args) {
       
        
// A classe SwingUtilities fornece métodos utilitários para Swing.
// O método invokeLater é usado para executar um bloco de código (Runnable)
// na Thread de Despacho de Eventos (Event Dispatch Thread - EDT) do Swing.    
// Tornamos a janela (ou componente) visível.
// Se 'tela' for um JFrame (uma janela de nível superior),
// chamar setVisible(true) a exibirá na tela.
        
            SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Menu_Produtos tela = new Menu_Produtos();
                tela.setVisible(true);
            }
        });
    }
        
        
}