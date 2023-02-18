package br.com.imagemfilmes.desafio.controller;

import br.com.imagemfilmes.desafio.entity.Produto;
import br.com.imagemfilmes.desafio.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

    @Autowired
    PessoaService pessoaService;

    @RequestMapping("/listar")
    public List<Produto> listar() throws Exception {
        return Collections.emptyList(); //TODO IMPLEMENTAR
    }

    @RequestMapping("/listar/preco")
    public List<Produto> listarOrdenadoPorPreco() throws Exception {
        return Collections.emptyList(); //TODO IMPLEMENTAR
    }

}
