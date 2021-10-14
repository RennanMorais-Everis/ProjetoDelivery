package com.everis.delivery.dto;

import com.everis.delivery.model.Usuario;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UsuariosRequest {

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


    public Usuario toUsuario() {

        Usuario usuario = new Usuario();

        usuario.setNome(nome);;
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setCep(cep);
        usuario.setEndereco(endereco);
        usuario.setNumero(numero);
        usuario.setSenha(senha);

        return usuario;
    }

}
