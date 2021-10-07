package com.everis.delivery.repository;

import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}