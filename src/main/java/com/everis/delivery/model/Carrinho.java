package com.everis.delivery.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Carrinho {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne //Um Carrinho para um cliente
    private Cliente cliente;

    @OneToMany (mappedBy = "carrinho") //um carrinho  para varios produtos
    private List<Produto> produto;

    private LocalDateTime dataCriacao = LocalDateTime.now();
    private double subTotal;
    private double frete;
    private double total;
    private Boolean validaPedido = false;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carrinho other = (Carrinho) obj;
        if (id == null) {
            if (other.getId() != null)
                return false;
        } else if (!id.equals(other.getId()))
            return false;
        return true;
    }

}
