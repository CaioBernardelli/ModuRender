package br.edu.ifpb.pps.projeto.renderspring.modurender.core;



import java.sql.Connection;
import java.sql.Statement;

/**
 * Classe para inicializar tabelas no banco de dados.
 */
public class TableInitializer {
    private final DatabaseManager databaseManager;

    public TableInitializer(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void createTables() {
        try (Connection connection = databaseManager.getConnection();
             Statement statement = connection.createStatement()) {

            // Criação da tabela User
            statement.executeUpdate("""
                CREATE TABLE IF NOT EXISTS users (
                    id SERIAL PRIMARY KEY,
                    name VARCHAR(50) NOT NULL,
                    email VARCHAR(100) NOT NULL UNIQUE
                );
            """);

            // Criação da tabela Order com relacionamento
            statement.executeUpdate("""
                CREATE TABLE IF NOT EXISTS orders (
                    id SERIAL PRIMARY KEY,
                    order_date TIMESTAMP NOT NULL,
                    total_amount DECIMAL(10, 2) NOT NULL,
                    user_id INTEGER NOT NULL REFERENCES users(id)
                );
            """);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar tabelas: " + e.getMessage(), e);
        }
    }
}
