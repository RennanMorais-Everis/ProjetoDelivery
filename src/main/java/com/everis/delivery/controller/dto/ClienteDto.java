package com.everis.delivery.controller.dto;

import com.everis.delivery.model.Cliente;
import com.everis.delivery.model.Logradouro;
import com.everis.delivery.repository.ClienteRepository;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * não é uma boa prática retornar entidades JPA nos métodos dos controllers, sendo mais indicado
 * retornar classes que seguem o padrão DTO (Data Transfer Object);
 * Consigo controlar quais campos quero devolver, porque nem sempre eu quero devolver tudo que tem na
 * minha classe de domínio.
 */

@Data
public class ClienteDto {

    private Long id;
    private String nomeCliente;
    private String rg;
    private String cpf;
    private String email;


    public ClienteDto(Cliente cliente) {
        this.id=cliente.getId();
        this.nomeCliente = cliente.getNome();
        this.rg = cliente.getRg();
        this.cpf = cliente.getCpf();
        this.email=cliente.getEnderecoEmail().getEmail();
    }


    public static List<ClienteDto> converter(List<Cliente> clientes) {
            return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }
}
/**
        .stream().map(TopicoDto::new).collect(Collectors.toList())->Essa é a sintaxe do Java 8. Sem ele, teríamos que
        * pegar essa lista de clients, fazer um for para cada tópico, dar new no ClienteDto, guardar em uma lista de
        * ClienteDto e devolver essa lista de ClienteDTO no final. Desse jeito, ele faz tudo isso em uma linha só usando
        * API de strings do Java 8.
        *A função do mapeamento será ClienteDto::new, porque ele vai chamar o construtor que recebe o próprio tópico
        * como parâmetro. No final, tenho que transformar isso em uma lista, então vou encadear a chamada para o método
        * collect(), passando collectors.toList() para transformar numa lista.
        */