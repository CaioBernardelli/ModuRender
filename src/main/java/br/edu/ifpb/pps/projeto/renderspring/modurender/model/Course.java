package br.edu.ifpb.pps.projeto.renderspring.modurender.model;

import br.edu.ifpb.pps.projeto.renderspring.modurender.repository.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Course extends BaseEntity {

    @Setter
    @Getter
    @Column(nullable = false)
    private String name;

    @Setter
    @Getter
    @Column(nullable = false)
    private String category;

    @Setter
    @Getter
    private String imgLink;

    @Setter
    @Getter
    @Column(nullable = false)
    private Double price;

    @Setter
    @Getter
    @ManyToOne(optional = false) // Curso deve ter um criador obrigatoriamente
    @JoinColumn(name = "creator_id", nullable = false)
    private Usuario criador;

    // Construtores
    public Course() {}

    public Course(String name, String category, String imgLink, Double price, Usuario criador) {
        this.name = name;
        this.category = category;
        this.imgLink = imgLink;
        this.price = price;
        this.criador = criador;
    }

    @Override
    public String getTableName() {
        return "course"; // Nome da tabela no banco
    }
}
