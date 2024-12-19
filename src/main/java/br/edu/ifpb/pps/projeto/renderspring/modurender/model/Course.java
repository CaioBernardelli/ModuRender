package br.edu.ifpb.pps.projeto.renderspring.modurender.model;

import br.edu.ifpb.pps.projeto.renderspring.modurender.repository.BaseEntity;
import jakarta.persistence.*;

@Entity
public class Course extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    private String imgLink;

    @Column(nullable = false)
    private Double price;

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

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    @Override
    public String getTableName() {
        return "course"; // Nome da tabela no banco
    }

}
