package com.everis.delivery.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "produtos")
@Data
public class Produto {


    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;

    private String descricao;

    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
