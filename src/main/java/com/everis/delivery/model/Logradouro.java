package com.everis.delivery.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "logradouro")
@Data
public class Logradouro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String endereco;

    @NotBlank
    private Integer numeroLogradouro;

    @NotBlank
    private Integer cep;

}
