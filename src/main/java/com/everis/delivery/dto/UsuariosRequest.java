package com.everis.delivery.dto;

import javax.validation.constraints.NotBlank;

public class UsuariosRequest {

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

}
