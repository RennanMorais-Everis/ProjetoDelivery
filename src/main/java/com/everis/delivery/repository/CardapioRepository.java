package com.everis.delivery.repository;

import com.everis.delivery.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardapioRepository extends JpaRepository<Produto, Long> {
}
