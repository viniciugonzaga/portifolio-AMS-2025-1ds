function calculadora(){
    const n1 =parseFloat(document.getElementById("n1").value);
    const n2 =parseFloat(document.getElementById("n2").value);
    const n3 =parseFloat(document.getElementById("operation").value);
    let result

    if(isNaN (n1) || isNaN(n2) ){
result = "por favor, digite um valor válido";
}

else{
switch(operation){
    case "adição":
        result = n1 + n2;
        break
        case "subtração":
        result = n1 - n2;
        break
        case "multiplicação":
        result = n1 * n2;
        break
        case "divisão":
        if (n2 == 0){
            result = "infinito"
        }
        else{
            result = n1 / n2; }
        break;

        default:
            result = "operação inválida";
}

}

document.getElementById('result').innerText = "resultado" + result;
    }
