function calcularIdade() {
    const anoNascimento = document.getElementById('ano-nascimento').value;
    const anoAtual = new Date().getFullYear();
    
    if (anoNascimento) {
        const idade = anoAtual - anoNascimento;
        document.getElementById('resultado').innerText = `Sua idade é: ${idade} anos.`;
    } else {
        document.getElementById('resultado').innerText = 'Por favor, insira um ano válido.';
    }
}
