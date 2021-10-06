package com.everis.delivery.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "produtos")
@Data
public class Produto {


    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String descricao;

    @NotBlank
    private Double  preco;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

}
