package com.everis.delivery.repository;

import com.everis.delivery.model.Categoria;
import com.everis.delivery.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    List<Produto> findByCategoria(Categoria pizza);
}
