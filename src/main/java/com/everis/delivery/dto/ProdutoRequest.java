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

    @NotBlank
    private BigDecimal preco;

    @NotBlank
    private Categoria categoria;

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setNomeProduto(nomeProduto);
        produto.setDescricao(descricao);

        //Alterando valor pára BigDecimal para ser salvo no banco
        String big = String.valueOf(preco);
        produto.setPreco(new BigDecimal(big));

        //Convertendo String do formulario em Enum
        Categoria cat = categoria;
        produto.setCategoria(cat);


        return produto;
    }
}
