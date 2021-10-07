package com.everis.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.everis.delivery.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findNByname(String name); //Somente para teste.
}
