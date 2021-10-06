package com.everis.delivery.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id @GeneratedValue (strategy =GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;
    private String rg;

    @NotBlank
    private String cpf;

    @NotBlank
    private String email;

    @OneToMany // um cliente para varios endereco
    private List<Logradouro> logradouro;

}
