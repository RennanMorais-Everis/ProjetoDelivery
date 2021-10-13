package com.everis.delivery.dto;

import com.everis.delivery.model.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoRequest {

    private Long id;
    private Usuario cliente;
    private List<Produto> produto;
    private TipoPagamento tipoPagamento;
    private StatusPedido statusPedido;
    private LocalDateTime dataPedido = LocalDateTime.now();
    private BigDecimal frete;
    private BigDecimal total;

    //Em testes
    public Pedido addPedido() {
        Pedido pedido = new Pedido();
        pedido.setProduto(produto);

        TipoPagamento tipo = tipoPagamento;
        pedido.setTipoPagamento(tipo);

        return pedido;
    }
}