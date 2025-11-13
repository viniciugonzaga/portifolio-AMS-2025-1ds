fun main(args: Array<String>) {

    val numero = 5
    if (numero > 2) {
        println("O número é maior que 2.")
    } else {
        println("O número é menor ou igual a 2.")
    }

    // Caso 2: WHEN
    val diaDaSemana = 3
    when (diaDaSemana) {
        1 -> println("Segunda-feira")
        2 -> println("Terça-feira")
        3 -> println("Quarta-feira")
        4 -> println("Quinta-feira")
        5 -> println("Sexta-feira")
        6 -> println("Sábado")
        7 -> println("Domingo")
        else -> println("Dia inválido")
    }

    // Caso 3: FOR
    for (i in 1..5) {
        println("Número $i")
    }

    // Estruturas de Repetição

    // Caso 4: Exibir todos os itens de uma array
    val numeros = arrayOf(1, 2, 3, 4, 5, 6)
    for (numero in numeros) {
        println(numero)
    }

    // Caso 5: Exibir o 6º elemento da array
    if (numeros.size >= 6) {
        println("O 6º elemento é: ${numeros[5]}")
    } else {
        println("A array não tem 6 elementos.")
    }

    // Caso 6: Exibir uma condição de repetição com While
    var contador = 1
    while (contador <= 5) {
        println("Contador: $contador")
        contador++
    }

    // Orientação a Objetos

    // Caso 7: Função de soma
    val soma = OperacoesMatematicas.somar(5, 3)
    println("Resultado da soma: $soma")

    // Caso 8: Função de subtração
    val subtracao = OperacoesMatematicas.subtrair(10, 4)
    println("Resultado da subtração: $subtracao")

    // Caso 9: Função de multiplicação
    val multiplicacao = OperacoesMatematicas.multiplicar(7, 6)
    println("Resultado da multiplicação: $multiplicacao")

    // Caso 10: Função de divisão
    val divisao = OperacoesMatematicas.dividir(20, 4)
    println("Resultado da divisão: $divisao")
}

// Orientação a Objetos

object OperacoesMatematicas {

    fun somar(a: Int, b: Int): Int {
        return a + b
    }

    fun subtrair(a: Int, b: Int): Int {
        return a - b
    }

    fun multiplicar(a: Int, b: Int): Int {
        return a * b
    }

    fun dividir(a: Int, b: Int): Double {
        if (b != 0) {
            return a.toDouble() / b
        } else {
            println("Erro: Divisão por zero!")
            return Double.NaN
        }
    }

    fun main() {
        // Solicitar ao usuário para inserir os números
        println("Digite o primeiro número:")
        val num1 = readLine()!!.toInt()

        println("Digite o segundo número:")
        val num2 = readLine()!!.toInt()

        // Exemplo de uso das operações com os números fornecidos pelo usuário

        // Exemplo de Soma
        val soma = OperacoesMatematicas.somar(num1, num2)
        println("Resultado da soma: $soma")

        // Exemplo de Subtração
        val subtracao = OperacoesMatematicas.subtrair(num1, num2)
        println("Resultado da subtração: $subtracao")

        // Exemplo de Multiplicação
        val multiplicacao = OperacoesMatematicas.multiplicar(num1, num2)
        println("Resultado da multiplicação: $multiplicacao")

        // Exemplo de Divisão
        val divisao = OperacoesMatematicas.dividir(num1, num2)
        if (divisao.isNaN()) {
            println("Erro: Divisão por zero!")
        } else {
            println("Resultado da divisão: $divisao")
        }
    }

    // Objeto OperacoesMatematicas com funções para soma, subtração, multiplicação e divisão
    object OperacoesMatematicas {

        fun somar(a: Int, b: Int): Int {
            return a + b
        }

        fun subtrair(a: Int, b: Int): Int {
            return a - b
        }

        fun multiplicar(a: Int, b: Int): Int {
            return a * b
        }

        fun dividir(a: Int, b: Int): Double {
            if (b != 0) {
                return a.toDouble() / b
            } else {
                return Double.NaN //
            }
        }
    }
}




