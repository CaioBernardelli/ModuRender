package br.edu.ifpb.pps.projeto.renderspring.modurender.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados.
 */
public class DatabaseManager {
    private final String url;
    private final String user;
    private final String password;

    /**
     * Construtor para inicializar o DatabaseManager com configurações dinâmicas.
     *
     * @param url      URL de conexão do banco de dados.
     * @param user     Nome do usuário para autenticação.
     * @param password Senha para autenticação.
     */
    public DatabaseManager(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    /**
     * Obtém uma conexão com o banco de dados.
     *
     * @return Instância de Connection configurada.
     * @throws SQLException Se ocorrer um erro ao conectar.
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * Método para testar a conexão com o banco de dados.
     */
    public void testConnection() {
        try (Connection connection = getConnection()) {
            System.out.println("Conexão bem-sucedida com o banco de dados!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
