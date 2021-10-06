package com.everis.delivery.controller.form;

import com.everis.delivery.model.Cliente;
import com.everis.delivery.model.EnderecoEmail;
import com.everis.delivery.repository.ClienteRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ClienteForm {

    @NotNull @NotEmpty @Length(min=5)
    private String nomeCliente;
    @NotNull @NotEmpty @Length(min=11,max=11)
    private String rg;
    @NotNull @NotEmpty @Length(min=11,max=11)
    private String cpf;
    @NotNull @NotEmpty @Length(min=10)
    private EnderecoEmail email;

    public Cliente converter(ClienteRepository clienteRepository) {
        List<Cliente> cliente = clienteRepository.findByNome(nomeCliente);
        return new Cliente(rg, cpf,email);
    }
}
