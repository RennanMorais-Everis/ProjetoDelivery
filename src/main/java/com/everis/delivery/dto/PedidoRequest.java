package com.everis.delivery.dto;

import com.everis.delivery.model.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoRequest {

    private Long id;
    private Usuario cliente;
    private List<Produto> produto;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern =  "dd-MM-yyyy") //Formatando data para Json
    private LocalDateTime dataPedido = LocalDateTime.now();

    private BigDecimal frete = new BigDecimal("5");
    private BigDecimal total;

    //Em testes
    public Pedido addPedido() {
        Pedido pedido = new Pedido();
        pedido.setProduto(produto);
        pedido.setTipoPagamento(tipoPagamento);
        pedido.setStatusPedido(StatusPedido.PENDENTE);
        return pedido;
    }

    public Pedido update(Pedido pedido) {
        pedido.setTotal(total);
        pedido.setStatusPedido(StatusPedido.APROVADO);
        return pedido;
    }

    public Pedido finalizarStatus(Pedido pedido) {
        pedido.setStatusPedido(StatusPedido.CONCLUIDO);
        return pedido;
    }
}
