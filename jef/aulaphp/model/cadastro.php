<?php

require_once("banco.php");

class cadastro extends banco{
    private $nome;
    private $telefone;
    private $origem;
    private $data_contato;
    private $observacao;

public function setNome($string){

    $this->nome = $string;
}

public function setTelefone(){

    $this->telefone = $string;
}

public function setOrigem(){

    $this->origem = $string;
}

public function setData_contato(){

    $this->data_contato = $string;
}

public function setObservacao(){

    $this->observacao = $string;
}

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

}




?>