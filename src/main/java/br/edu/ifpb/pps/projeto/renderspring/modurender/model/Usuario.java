package br.edu.ifpb.pps.projeto.renderspring.modurender.model;

import br.edu.ifpb.pps.projeto.renderspring.modurender.repository.BaseEntity;
import jakarta.persistence.*;

@Entity
public class Usuario extends BaseEntity {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = true) // Permite que o curso seja nulo
    private Course curso;

    // Construtores
    public Usuario() {}

    public Usuario(String nome, String email, Integer idade, String senha, Course curso) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.senha = senha;
        this.curso = curso;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Course getCurso() {
        return curso;
    }

    public void setCurso(Course curso) {
        this.curso = curso;
    }

    @Override
    public String getTableName() {
        return "usuario"; // Nome da tabela no banco
    }


}
