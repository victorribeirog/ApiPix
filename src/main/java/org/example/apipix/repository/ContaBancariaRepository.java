package org.example.apipix.repository;

import org.example.apipix.model.entities.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
    Optional<ContaBancaria> findByChavePix(String chavePix);
}
