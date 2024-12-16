package br.edu.ifpb.pps.projeto.renderspring.modurender.model;

import br.edu.ifpb.pps.projeto.renderspring.modurender.repository.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Notification extends BaseEntity {

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime date;
    @Id
    private Long id;

    // Construtores
    public Notification() {}

    public Notification(String message, LocalDateTime date) {
        this.message = message;
        this.date = date;
    }

    // Getters e Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String getTableName() {
        return "notification"; // Nome da tabela no banco
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
