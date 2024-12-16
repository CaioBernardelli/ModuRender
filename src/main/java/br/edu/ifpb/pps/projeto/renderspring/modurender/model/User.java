package br.edu.ifpb.pps.projeto.renderspring.modurender.model;

import br.edu.ifpb.pps.projeto.renderspring.modurender.model.BaseModel;
import br.edu.ifpb.pps.projeto.renderspring.modurender.model.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseModel {
   // @NotBlank
   // @Size(min = 2, max = 50)
    private String name;

  //  @Email
   // @NotBlank
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders ; // Inicialização necessária para evitar NullPointerException

    // Getters e Setters
}
