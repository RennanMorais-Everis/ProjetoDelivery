package com.everis.delivery.service.serviceImplements;


import com.everis.delivery.model.Produto;
import com.everis.delivery.repository.CardapioRepository;
import com.everis.delivery.service.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CardapioServiceImplements implements CardapioService {

    @Autowired
    CardapioRepository cardapioRepository;

    @Override
    public List<Produto> findAll() {
        return cardapioRepository.findAll();
    }

    @Override
    public Produto findById(Long id) {
        return cardapioRepository.findById(id).get();
    }

    @Override
    public Produto save(Produto produto) {
        return cardapioRepository.save(produto);
    }

}