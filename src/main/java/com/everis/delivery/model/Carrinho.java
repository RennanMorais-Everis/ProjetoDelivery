package com.everis.delivery.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "carrinho")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Carrinho {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne //Um Carrinho para um cliente
    private Usuario cliente;

    @OneToMany
    @ToString.Exclude//um carrinho para varios produtos
    private List<Produto> produto;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern =  "dd-MM-yyyy HH-mm") //formato de data
    private LocalDateTime dataCriacao = LocalDateTime.now();

    private double subTotal;
    private double frete;
    private double total;
    private Boolean validaPedido = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Carrinho carrinho = (Carrinho) o;
        return Objects.equals(id, carrinho.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
