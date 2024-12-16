package br.edu.ifpb.pps.projeto.renderspring.modurender.config;

import org.springframework.stereotype.Component;

@Component
public class FrameworkInitializerImpl implements FrameworkInitializer {
    @Override
    public void initialize() {
        System.out.println("Inicializando os componentes do ModuRender...");
        // Coloque lógica de inicialização aqui
    }
}
