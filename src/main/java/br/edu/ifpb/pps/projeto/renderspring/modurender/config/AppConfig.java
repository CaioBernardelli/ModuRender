package br.edu.ifpb.pps.projeto.renderspring.modurender.config;

import br.edu.ifpb.pps.projeto.renderspring.modurender.core.DatabaseManager;
import br.edu.ifpb.pps.projeto.renderspring.modurender.core.TableInitializer;
import br.edu.ifpb.pps.projeto.renderspring.modurender.repository.GenericRepository;
import br.edu.ifpb.pps.projeto.renderspring.modurender.utils.Logger;
import br.edu.ifpb.pps.projeto.renderspring.modurender.utils.Validator;
import br.edu.ifpb.pps.projeto.renderspring.modurender.utils.SessionManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * Configuração do DatabaseManager para gerenciar conexões com o banco de dados.
     * Substitui JPA/Hibernate, sendo uma implementação manual de persistência.
     */
    @Bean
    public DatabaseManager databaseManager() {
        return new DatabaseManager(
                "jdbc:postgresql://localhost:5432/seu_banco",
                "seu_usuario",
                "sua_senha"
        );
    }

    /**
     * Configuração do TableInitializer para criar tabelas no banco de dados.
     * Ele é executado na inicialização do framework para garantir que as tabelas existam.
     */
    @Bean
    public TableInitializer tableInitializer(DatabaseManager databaseManager) {
        return new TableInitializer(databaseManager);
    }

    /**
     * Configuração do GenericRepository para fornecer métodos genéricos
     * de persistência e manipulação de dados.
     */
    @Bean
    public GenericRepository<?> genericRepository(DatabaseManager databaseManager) {
        return new GenericRepository<>(databaseManager);
    }

    /**
     * Configuração do Logger para fornecer suporte a logs no framework.
     */
    @Bean
    public Logger logger() {
        return new Logger();
    }

    /**
     * Configuração do Validator para validação de dados no framework.
     */
    @Bean
    public Validator validator() {
        return new Validator();
    }

    /**
     * Configuração do SessionManager para gerenciar sessões de usuário.
     */
    @Bean
    public SessionManager sessionManager() {
        return new SessionManager();
    }

    /**
     * Configuração final do framework.
     * Inicializa dependências e executa tarefas essenciais no início da aplicação.
     */
    @Bean
    public FrameworkInitializer frameworkInitializer(TableInitializer tableInitializer, Logger logger) {
        return () -> {
            // Inicializar tabelas
            tableInitializer.createTables();
            // Log de inicialização
            logger.info("Framework iniciado com sucesso!");
        };
    }
}

