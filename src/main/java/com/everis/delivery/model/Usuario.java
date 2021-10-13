package com.everis.delivery.model;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id @GeneratedValue (strategy =GenerationType.IDENTITY)
    private Long id;

    private String nomeUsuario;

    private String cpf;

    private String email;

    private String cep;

    private String endereco;

    private String numero;

    private String senha;

    @Enumerated(EnumType.STRING)
    private NivelAcesso nivel = NivelAcesso.NORMAL;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
