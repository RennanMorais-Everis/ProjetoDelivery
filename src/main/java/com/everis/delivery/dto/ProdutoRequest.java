package com.everis.delivery.dto;

import com.everis.delivery.model.Categoria;
import com.everis.delivery.model.Produto;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class ProdutoRequest {

    private Long id;

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String descricao;

    //Preço sera recebido como String para ser convertido na função toProduto alterando para BigDecimal
    @NotBlank
    private String preco;

    @NotBlank
    private Categoria categoria;

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setNomeProduto(nomeProduto);
        produto.setDescricao(descricao);

        //Convertendo o valor de preço para String para ser enviado como BigDecimal
        preco = preco.replaceAll(",", ".");
        produto.setPreco(new BigDecimal(preco));

        //Convertendo categoria para Enum
        Categoria cat = categoria;
        produto.setCategoria(cat);

        return produto;
    }
}
