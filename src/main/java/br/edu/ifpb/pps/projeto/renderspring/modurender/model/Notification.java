package br.edu.ifpb.pps.projeto.renderspring.modurender.model;

import br.edu.ifpb.pps.projeto.renderspring.modurender.repository.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class Notification extends BaseEntity {

    @Setter
    @Getter
    @Column(nullable = false)
    private String message;

    @Setter
    @Getter
    @Column(nullable = false)
    private LocalDateTime date;

    // Construtores
    public Notification() {}

    public Notification(String message, LocalDateTime date) {
        this.message = message;
        this.date = date;
    }

    @Override
    public String getTableName() {
        return "notification"; // Nome da tabela no banco
    }
}
