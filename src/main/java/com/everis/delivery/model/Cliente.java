package com.everis.delivery.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity @Data
public class Cliente {

    @Id @GeneratedValue (strategy =GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String rg;
    private String cpf;

    @OneToOne // Um cliente para um endereco de email
    private EnderecoEmail enderecoEmail;

    @OneToMany // um cliente para varios endereco
    private List<Logradouro> logradouro;

    public Cliente() {
    }

    public Cliente(String rg, String cpf, EnderecoEmail email) {
        this.rg=rg;
        this.cpf=cpf;
        this.enderecoEmail=email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.getId() != null)
                return false;
        } else if (!id.equals(other.getId()))
            return false;
        return true;
    }

}
