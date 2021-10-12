package com.everis.delivery.repository;

import com.everis.delivery.model.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
@NoRepositoryBean
public interface ContasRepository extends CrudRepository<Conta, Integer> {


    Conta findbyId(Integer origem);
}
