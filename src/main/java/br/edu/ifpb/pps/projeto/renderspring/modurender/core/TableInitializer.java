package br.edu.ifpb.pps.projeto.renderspring.modurender.core;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

public class TableInitializer {

    private final DataSource dataSource;

    public TableInitializer(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Criação das tabelas no banco de dados.
     */
    public void createTables() {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();

            // SQL para criar a tabela 'usuario'
            String createUsuarioTable = """
                CREATE TABLE IF NOT EXISTS usuario (
                    id BIGSERIAL PRIMARY KEY,
                    nome VARCHAR(255) NOT NULL,
                    email VARCHAR(255) NOT NULL UNIQUE,
                    idade INTEGER NOT NULL,
                    senha VARCHAR(255) NOT NULL
                );
            """;

            // SQL para criar a tabela 'notification'
            String createNotificationTable = """
                CREATE TABLE IF NOT EXISTS notification (
                    id BIGSERIAL PRIMARY KEY,
                    message TEXT NOT NULL,
                    date TIMESTAMP NOT NULL
                );
            """;

            // SQL para criar a tabela 'course'
            String createCourseTable = """
                CREATE TABLE IF NOT EXISTS course (
                    id BIGSERIAL PRIMARY KEY,
                    name VARCHAR(255) NOT NULL,
                    category VARCHAR(255) NOT NULL,
                    imgLink VARCHAR(255),
                    price NUMERIC(10, 2) NOT NULL
                );
            """;

            String createSessionTable = """
                CREATE TABLE IF NOT EXISTS sessions (
                    id SERIAL PRIMARY KEY,
                    user_id INT NOT NULL REFERENCES usuario(id) ON DELETE CASCADE,
                    session_token VARCHAR(255) NOT NULL UNIQUE,
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    expires_at TIMESTAMP
                );
            """;

            String createLogsTable = """
                CREATE TABLE IF NOT EXISTS logs (
                    id SERIAL PRIMARY KEY,
                    level VARCHAR(20) NOT NULL,
                    message TEXT NOT NULL,
                    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                );
            """;

            // Executando os comandos SQL
            statement.execute(createUsuarioTable);
            statement.execute(createNotificationTable);
            statement.execute(createCourseTable);
            statement.execute(createSessionTable);
            statement.execute(createLogsTable);

            System.out.println("Tabelas criadas com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao criar tabelas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
