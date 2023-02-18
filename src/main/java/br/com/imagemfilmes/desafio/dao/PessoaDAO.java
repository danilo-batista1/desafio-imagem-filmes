package br.com.imagemfilmes.desafio.dao;

import br.com.imagemfilmes.desafio.entity.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends DAO {

    public PessoaDAO(final Connection connection) {
        super(connection);
    }
    
    public void create(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, cpf) VALUES (?, ?)";
        try (PreparedStatement psmt = getConnection().prepareStatement(sql)) {
            psmt.setString(1, pessoa.getNome());
            psmt.setString(2, pessoa.getCpf());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pessoa findById(int id) {
    	try (PreparedStatement psmt = getConnection().prepareStatement("SELECT * FROM pessoa WHERE id = ?")) {
    		psmt.setInt(1, id);
    	try (ResultSet rs = psmt.executeQuery()) {
    	if (rs.next()) {
    		Pessoa pessoa = new Pessoa();
    		pessoa.setId(rs.getInt("id"));
    		pessoa.setNome(rs.getString("nome"));
    		pessoa.setCpf(rs.getString("cpf"));
    		return pessoa;
    		}
    		}
    		} catch (SQLException e) {
    		e.printStackTrace();
    		}
    		return null;
    		}

    public List<Pessoa> findAll() throws SQLException {
    	try (PreparedStatement psmt = getConnection().prepareStatement("SELECT * FROM pessoa")) {
            try (ResultSet rs = psmt.executeQuery()) {
                final List<Pessoa> pessoas = new ArrayList<>();
                while (rs.next()) {
                    final Pessoa pessoa = new Pessoa()
                            .setId(rs.getInt("id"))
                            .setNome(rs.getString("nome"))
                            .setCpf(rs.getString("cpf"));
                    pessoas.add(pessoa);
                }
                return pessoas;
            }     
    	}
    }
    
    public void update(Pessoa pessoa) throws SQLException {
    	try (PreparedStatement psmt = getConnection().prepareStatement("UPDATE pessoa SET nome = ?, cpf = ?,  WHERE id = ?")) {
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
