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

    @NotBlank
    private String cpf;

    @NotBlank
    private String email;

    @NotBlank
    private String cep;

    @NotBlank
    private String endereco;

    @NotBlank
    private String numero;

    @NotBlank
    private String senha;

    @Enumerated(EnumType.STRING)
    private NivelAcesso nivel = NivelAcesso.NORMAL;

}
