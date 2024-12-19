package br.edu.ifpb.pps.projeto.renderspring.modurender.config;

import br.edu.ifpb.pps.projeto.renderspring.modurender.core.TableInitializer;
import br.edu.ifpb.pps.projeto.renderspring.modurender.utils.Logger;
import br.edu.ifpb.pps.projeto.renderspring.modurender.utils.SessionManager;
import br.edu.ifpb.pps.projeto.renderspring.modurender.utils.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class AppConfig {

    // Carrega propriedades do banco de dados a partir do application.properties
    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String databaseUser;

    @Value("${spring.datasource.password}")
    private String databasePassword;

    /**
     * Configura o DataSource gerenciado pelo Spring.
     */
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(databaseUrl)
                .username(databaseUser)
                .password(databasePassword)
                .build();
    }

    /**
     * Inicializador para criar tabelas no banco de dados.
     */
    @Bean
    public TableInitializer tableInitializer(DataSource dataSource) {
        return new TableInitializer(dataSource);
    }

    /**
     * Logger para registro de eventos.
     */
    @Bean
    public Logger logger() {
        return new Logger();
    }

    /**
     * Validator para validação de dados.
     */
    @Bean
    public Validator validator() {
        return new Validator();
    }

    /**
     * Gerenciador de sessões.
     */
    @Bean
    public SessionManager sessionManager() {
        return new SessionManager();
    }

    /**
     * Inicializador do framework, incluindo criação de tabelas e logs de inicialização.
     */
    @Bean
    public FrameworkInitializer frameworkInitializer(TableInitializer tableInitializer, Logger logger) {
        return () -> {
            try {
                tableInitializer.createTables();
                logger.info("Framework iniciado com sucesso!");
            } catch (Exception e) {
                logger.error("Erro durante a inicialização do framework: " + e.getMessage());
            }
        };
    }
}
