package br.com.imagemfilmes.desafio.dao;

import br.com.imagemfilmes.desafio.entity.Pedido;
import br.com.imagemfilmes.desafio.entity.PedidoItem;
import br.com.imagemfilmes.desafio.entity.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoItemDAO extends DAO {

    public PedidoItemDAO(final Connection connection) {
        super(connection);
    }
    
    public void create(PedidoItem item) {
        String sql = "INSERT INTO pedido_item (pedido_id, produto, quantidade) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, item.getIdPedido());
            statement.setString(2, item.getProduto());
            statement.setInt(3, item.getQuantidade());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<PedidoItem> findAllByPedidoId(int pedidoId) {
        List<PedidoItem> pedidoItens = new ArrayList<>();
        String sql = "SELECT * FROM pedido_item WHERE pedido_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pedidoId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PedidoItem pedidoItem = new PedidoItem();
                pedidoItem.setId(resultSet.getInt("id"));
                pedidoItem.setPedidoId(resultSet.getInt("pedido_id"));
                pedidoItem.setItem(resultSet.getString("item"));
                pedidoItem.setQuantidade(resultSet.getInt("quantidade"));
                pedidoItens.add(pedidoItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidoItens;
    }
    
}
