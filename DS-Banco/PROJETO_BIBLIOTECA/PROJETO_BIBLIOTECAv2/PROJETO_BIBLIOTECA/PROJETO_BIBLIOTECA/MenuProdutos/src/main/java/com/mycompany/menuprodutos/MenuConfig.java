/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuprodutos;

import java.util.ArrayList;
import java.util.List;

class MenuConfig extends Menu_Produtos {
    private Menu menuObjeto;

    protected MenuConfig() {
        // Construtor da classe MenuConfig
        // MenuConfig agora é um JFrame (ou herda de um)

        // Criar uma instância da classe Menu (passando as informações necessárias)
        // Assumindo que a classe Menu precisa de um Produto e uma referência a Menu_Produtos
        // Agora podemos usar a classe Produto fornecida.
        Produto produtoDummy = new Produto("Produto Padrão", "Geral", 10, 19.99, "Outros", "caminho/padrao.png", "Descrição detalhada padrão.");
        this.menuObjeto = new Menu(produtoDummy, this); // 'this' referencia a instância de MenuConfig
    }

    public Menu getMenuObjeto() {
        return menuObjeto;
    }

    public int executar() {
        // Este método pode ser usado para iniciar alguma lógica na MenuConfig
        System.out.println("MenuConfig está executando.");
        return 0;
    }
}