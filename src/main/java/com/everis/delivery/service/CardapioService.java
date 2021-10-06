package com.everis.delivery.service;

import com.everis.delivery.model.Produto;

import java.util.List;

public interface CardapioService {

    List<Produto> findAll();
    Produto findById(Long id);
    Produto save(Produto produto);

}