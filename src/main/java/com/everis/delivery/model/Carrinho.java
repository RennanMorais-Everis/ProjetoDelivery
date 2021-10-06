package com.everis.delivery.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "carrinho")
@Data
public class Carrinho {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne //Um Carrinho para um cliente
    private Usuario cliente;

    @OneToMany//um carrinho para varios produtos
    private List<Produto> produto;

    private LocalDateTime dataCriacao = LocalDateTime.now();
    private double subTotal;
    private double frete;
    private double total;
    private Boolean validaPedido = false;

}
