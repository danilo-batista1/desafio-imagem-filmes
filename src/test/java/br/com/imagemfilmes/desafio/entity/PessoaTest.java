package br.com.imagemfilmes.desafio.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PessoaTest {

    @Test
    public void testToString(){
        Assertions.assertEquals("Pessoa{id=666, cpf='0123456789', nome='Pessoa Teste'}",  new Pessoa());
    }

}