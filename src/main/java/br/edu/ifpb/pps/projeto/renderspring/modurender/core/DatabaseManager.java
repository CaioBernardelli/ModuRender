package br.edu.ifpb.pps.projeto.renderspring.modurender.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private String url;
    private String user;
    private String password;

    // Construtor sem argumentos
    public DatabaseManager() {
    }

    // Métodos para configurar as propriedades
    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void testConnection() {
        try (Connection connection = getConnection()) {
            System.out.println("Conexão bem-sucedida com o banco de dados!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
