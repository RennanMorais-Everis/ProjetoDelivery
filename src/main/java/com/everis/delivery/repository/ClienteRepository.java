package com.everis.delivery.repository;

import com.everis.delivery.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNome(String nome);
}
