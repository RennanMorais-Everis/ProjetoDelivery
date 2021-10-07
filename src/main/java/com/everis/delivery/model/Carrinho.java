package com.everis.delivery.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

}
