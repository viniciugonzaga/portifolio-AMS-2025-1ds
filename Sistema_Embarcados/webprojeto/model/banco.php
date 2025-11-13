<?php

// timezone
date_default_timezone_set('America/Sao_Paulo');

// constantes do banco
define('BD_SERVIDOR', 'localhost');
define('BD_USUARIO', 'root');
define('BD_SENHA', '');
define('BD_BANCO', 'projetoweb');

class Banco {

    protected $mysqli;

    public function __construct() {
        $this->conexao();
    }

    private function conexao() {
        $this->mysqli = new mysqli(BD_SERVIDOR, BD_USUARIO, BD_SENHA, BD_BANCO);
        if ($this->mysqli->connect_error) {
            die("Erro de conexão: " . $this->mysqli->connect_error);
        }
    }

    public function setAgendamentos($nome, $telefone, $origem, $data_contato, $observacao) {
        $stmt = $this->mysqli->prepare("INSERT INTO agendamentos (nome, telefone, origem, data_contato, observacao) VALUES (?, ?, ?, ?, ?)");

        if (!$stmt) {
            echo "Erro na preparação: " . $this->mysqli->error;
            return false;
        }

        // Evita erro ao passar referências
        $stmt->bind_param("sssss", $nome, $telefone, $origem, $data_contato, $observacao);

        if ($stmt->execute()) {
            return true;
        } else {
            echo "Erro na execução: " . $stmt->error;
            return false;
        }
    }
}
?>
