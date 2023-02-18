package br.com.imagemfilmes.desafio.dao;

import br.com.imagemfilmes.desafio.entity.Pedido;
import br.com.imagemfilmes.desafio.entity.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO extends DAO {

    public PedidoDAO(final Connection connection) {
        super(connection);
    }
    
    public void create(Pedido pedido) {
        String sql = "INSERT INTO pedido (idPessoa, item) VALUES (?, ?)";
        try (PreparedStatement psmt = getConnection().prepareStatement(sql)) {
            psmt.setString(2, pedido.getIdPessoa());
            psmt.setString(3, pedido.getItens());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pedido> findAll() throws SQLException {
    	try (PreparedStatement psmt = getConnection().prepareStatement("SELECT * FROM pedido")) {
            try (ResultSet rs = psmt.executeQuery()) {
                final List<Pedido> pedidos = new ArrayList<>();
                while (rs.next()) {
                    final Pedido pedido = new Pedido()
                            .setId(rs.getLong("id"))
                            .setIdPessoa(rs.getString("pessoa"))
                            .setItens(rs.getString("item"));
                    pedidos.add(pedido);
                }
                return pedidos;
            }     
    	}
    }
    
    public void update(Pedido pedido) {
    	try (PreparedStatement psmt = getConnection().prepareStatement("UPDATE pedido SET idPessoa = ?, item = ?,  WHERE id = ?")) {
    		try (ResultSet rs = psmt.executeQuery()) {
    			psmt.setString(1, pessoa.getNome());
    	    	psmt.setString(2, pessoa.getCpf());
    	    	psmt.setInt(3, pessoa.getId());
    	    	psmt.executeUpdate();
    	    	} catch (SQLException e) {
    	    	e.printStackTrace();
    	    	}
    	}
    }
 
    public void delete(int id) {
    	try (PreparedStatement psmt = getConnection().prepareStatement("DELETE FROM pessoa WHERE id = ?")) {
    		try (ResultSet rs = psmt.executeQuery()) {
    			psmt.setInt(1, id);
    			psmt.executeUpdate();
    			}
    			} catch (SQLException e) {
    			e.printStackTrace();
    			}
    	}
}
