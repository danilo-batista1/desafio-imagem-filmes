package br.com.imagemfilmes.desafio.service;

import br.com.imagemfilmes.desafio.dao.PedidoDAO;
import br.com.imagemfilmes.desafio.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@Service
public class PedidoService {

@Autowired
private PedidoDAO pedidoDAO;

public List<Pedido> getAllPedidos() throws Exception {
    return pedidoDAO.readAll();
}

public List<Pedido> getPedidosByPessoa(long idPessoa) throws Exception {
    return pedidoDAO.listarByPessoa(idPessoa);
}

public List<Pedido> getPedidosOrdenadosPorValorTotal() throws Exception {
    return pedidoDAO.findAllOrderedByTotalValue();
    
	}
}