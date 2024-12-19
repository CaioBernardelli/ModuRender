package br.edu.ifpb.pps.projeto.renderspring.modurender.model;

import br.edu.ifpb.pps.projeto.renderspring.modurender.repository.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Usuario extends BaseEntity {

    // Getters e Setters
    @Setter
    @Getter
    @Column(nullable = false)
    private String nome;

    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String email;

    @Getter
    @Column(nullable = false)
    private Integer idade;

    @Setter
    @Getter
    @Column(nullable = false)
    private String senha;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = true) // O curso é opcional
    private Course curso;

    @Setter
    @Getter
    @OneToMany(mappedBy = "criador", cascade = CascadeType.ALL)
    private List<Course> cursosCriados; // Lista de cursos que o usuário criou
    // Construtores
    public Usuario() {}

    public Usuario(String nome, String email, Integer idade, String senha, Course curso) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.senha = senha;
        this.curso = curso;
    }


    @Override
    public String getTableName() {
        return "usuario"; // Nome da tabela no banco
    }


}
