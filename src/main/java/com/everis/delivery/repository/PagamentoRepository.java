package com.everis.delivery.repository;



import com.everis.delivery.model.Pagamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;



@Repository
@NoRepositoryBean
public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {

}
