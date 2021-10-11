package com.everis.delivery.dto;

import com.everis.delivery.model.Categoria;
import com.everis.delivery.model.Produto;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class ProdutoRequest {

    private Long id;

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String descricao;

    @NotBlank
    private Double  preco;


    @NotBlank
    private Categoria categoria;

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setNomeProduto(nomeProduto);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        produto.setCategoria(categoria);
        return produto;
    }

}
