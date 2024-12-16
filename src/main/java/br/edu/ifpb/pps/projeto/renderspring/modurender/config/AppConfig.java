package br.edu.ifpb.pps.projeto.renderspring.modurender.config;

import br.edu.ifpb.pps.projeto.renderspring.modurender.core.DatabaseManager;
import br.edu.ifpb.pps.projeto.renderspring.modurender.core.TableInitializer;
import br.edu.ifpb.pps.projeto.renderspring.modurender.repository.BaseEntity;
import br.edu.ifpb.pps.projeto.renderspring.modurender.repository.GenericRepository;
import br.edu.ifpb.pps.projeto.renderspring.modurender.utils.Logger;
import br.edu.ifpb.pps.projeto.renderspring.modurender.utils.Validator;
import br.edu.ifpb.pps.projeto.renderspring.modurender.utils.SessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Propriedades externas para configurar o DatabaseManager
    @Bean
    public DatabaseManager databaseManager() {
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.setUrl("jdbc:postgresql://localhost:5432/teste30");
        databaseManager.setUser("postgres");
        databaseManager.setPassword("12345");
        return databaseManager;
    }


    /**
     * Configuração do TableInitializer para criar tabelas no banco de dados.
     */
    @Bean
    public TableInitializer tableInitializer(DatabaseManager databaseManager) {
        return new TableInitializer(databaseManager);
    }

    /**
     * Configuração do GenericRepository para fornecer métodos genéricos de persistência.
     */
    @Bean
    public <T extends BaseEntity> GenericRepository<T> genericRepository(DatabaseManager databaseManager) {
        return new GenericRepository<>(databaseManager);
    }

    /**
     * Configuração do Logger para suporte a logs no framework.
     */
    @Bean
    public Logger logger() {
        return new Logger();
    }

    /**
     * Configuração do Validator para validação de dados.
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
     * Configuração final do framework, inicializando tabelas e registrando logs.
     */
    @Bean
    public FrameworkInitializer frameworkInitializer(TableInitializer tableInitializer, Logger logger) {
        return () -> {
            tableInitializer.createTables();
            logger.info("Framework iniciado com sucesso!");
        };
    }
}
