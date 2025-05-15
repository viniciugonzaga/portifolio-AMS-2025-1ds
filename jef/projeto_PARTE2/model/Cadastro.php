<?php

require_once("banco.php");

class Cadastro extends Banco {

    private $nome;
    private $telefone;
    private $origem;
    private $data_contato;
    private $observacao;

    //Metodos Set
    public function setNome($string){
        $this->nome = $string;
    }

    public function setTelefone($string){
        $this->telefone = $string;
    }

    public function setOrigem($string){
        $this->origem = $string;
    }

    public function setData_contato($string){
        $this->data_contato = $string;
    }

    public function setObservacao($string){
        $this->observacao = $string;
    }

    //Metodos Get
    public function getNome(){
        return $this->nome;
    }
    public function getTelefone(){
        return $this->telefone;
    }

    public function getOrigem(){
        return $this->origem;
    }

    public function getData_contato(){
        return $this->data_contato;
    }

    public function getObservacao(){
        return $this->observacao;
    }

    public function cadastrar(){
        $sql = "INSERT INTO clientes (nome, telefone, origem, data_contato, observacao) VALUES (:nome, :telefone, :origem, :data_contato, :observacao)";
        $stmt = DB::prepare($sql);
        $stmt->bindParam(':nome', $this->nome);
        $stmt->bindParam(':telefone', $this->telefone);
        $stmt->bindParam(':origem', $this->origem);
        $stmt->bindParam(':data_contato', $this->data_contato);
        $stmt->bindParam(':observacao', $this->observacao);
        return $stmt->execute();
    }
}