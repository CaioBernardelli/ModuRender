package br.edu.ifpb.pps.projeto.renderspring.modurender.config;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ModuRenderApplication {

    // Injeção do FrameworkInitializer
    @Autowired
    private FrameworkInitializer frameworkInitializer;

    public static void main(String[] args) {
        // Inicia a aplicação Spring Boot
        SpringApplication.run(ModuRenderApplication.class, args);
    }


    @PostConstruct
    public void initFramework() {
        // Chama a inicialização personalizada do Framework
        frameworkInitializer.initialize();
        System.out.println("Framework ModuRender inicializado com sucesso!");
    }
}
