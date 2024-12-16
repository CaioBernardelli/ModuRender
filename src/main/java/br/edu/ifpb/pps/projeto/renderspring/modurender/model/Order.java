package br.edu.ifpb.pps.projeto.renderspring.modurender.model;

import br.edu.ifpb.pps.projeto.renderspring.modurender.model.BaseModel;
import br.edu.ifpb.pps.projeto.renderspring.modurender.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Order extends BaseModel {
    //@NotNull
    private LocalDateTime orderDate;
    private BigDecimal getTotalAmount;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Deve ser o mesmo nome referenciado pelo "mappedBy" na classe User

   // @NotNull
    //@DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal totalAmount;

    // Getters e Setters
}
