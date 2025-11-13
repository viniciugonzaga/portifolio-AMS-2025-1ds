<?php
require_once("../model/cadastro.php");

class CadastroController {

    private $cadastro;

    public function __construct() {
        $this->cadastro = new Cadastro();
        $this->incluir();
    }

    private function incluir() {
        // Captura os dados do formulário e configura os atributos
        $this->cadastro->setNome($_POST['txtNome']);
        $this->cadastro->setTelefone($_POST['txtTelefone']);
        $this->cadastro->setOrigem($_POST['txtOrigem']);
        $this->cadastro->setData_contato(date('Y-m-d', strtotime($_POST['txtDataContato'])));
        $this->cadastro->setObservacao($_POST['txtObservacao']);

        // Chama a função de inclusão
        $result = $this->cadastro->incluir();

        // Feedback visual
        if ($result >= 1) {
            echo "<script>alert('Registro incluído com sucesso!');document.location='../index.php'</script>";
        } else {
            echo "<script>alert('Erro ao gravar registro!');</script>";
        }
    }
}

// Instancia automaticamente o controller ao carregar
new CadastroController();
?>

