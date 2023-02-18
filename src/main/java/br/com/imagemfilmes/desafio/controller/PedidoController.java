package br.com.imagemfilmes.desafio.controller;

import br.com.imagemfilmes.desafio.dao.PedidoDAO;
import br.com.imagemfilmes.desafio.entity.Pedido;
import br.com.imagemfilmes.desafio.service.PedidoService;
import br.com.imagemfilmes.desafio.entity.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {
	
	
	@RequestMapping("/listar")
    public List<Pedido> listar() throws Exception {
		return pedidoService.listar();
    }

    @RequestMapping("/listar/{idCliente}")
    public List<Pedido> listarByCliente(@PathVariable("idCliente") long idCliente) throws Exception {
		return pedidoService.listarByCliente(idCliente);
    }


    @RequestMapping("/listar/total")
    public List<Pessoa> listarOrdenadoPorValorTotal() throws Exception {
        return pedidoService.listarOrdenadoPorValorTotal();
    }

}
