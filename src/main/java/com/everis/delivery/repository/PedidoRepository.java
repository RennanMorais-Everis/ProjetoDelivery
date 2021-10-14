package com.everis.delivery.repository;

import com.everis.delivery.model.Pedido;
import com.everis.delivery.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("select p from Pedido p where p.statusPedido = :statusPedido")
    Pedido findAllByStatusPedido(StatusPedido statusPedido);

}
