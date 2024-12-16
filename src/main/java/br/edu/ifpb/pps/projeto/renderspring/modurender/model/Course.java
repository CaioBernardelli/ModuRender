package br.edu.ifpb.pps.projeto.renderspring.modurender.model;

import br.edu.ifpb.pps.projeto.renderspring.modurender.repository.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    private String imgLink;

    @Column(nullable = false)
    private Double price;
    @Id
    private Long id;

    // Construtores
    public Course() {}

    public Course(String name, String category, String imgLink, Double price) {
        this.name = name;
        this.category = category;
        this.imgLink = imgLink;
        this.price = price;
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

    @Override
    public String getTableName() {
        return "course"; // Nome da tabela no banco
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
