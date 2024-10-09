function verificarParImpar() {
    const numero = parseInt(document.getElementById('numero').value);
    
    if (!isNaN(numero)) {
        if (numero % 2 === 0) {
            document.getElementById('resultado').innerText = `O número ${numero} é par.`;
        } else {
            document.getElementById('resultado').innerText = `O número ${numero} é ímpar.`;
        }
    } else {
        document.getElementById('resultado').innerText = 'Por favor, insira um número válido.';
    }
}
