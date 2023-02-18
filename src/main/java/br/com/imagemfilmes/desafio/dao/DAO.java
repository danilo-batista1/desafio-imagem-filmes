/*
 * AbstractDAO.java Created on 20 de Julho de 2006, 08:58
 */
package br.com.imagemfilmes.desafio.dao;

import java.sql.Connection;


public abstract class DAO {

    private Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    Connection getConnection() {
        return connection;
    }
}