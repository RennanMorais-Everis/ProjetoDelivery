package com.everis.delivery.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Produto {


    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private String descricaoProduto;
    private Double  preco;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

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
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.getId() != null)
                return false;
        } else if (!id.equals(other.getId()))
            return false;
        return true;
    }
}
