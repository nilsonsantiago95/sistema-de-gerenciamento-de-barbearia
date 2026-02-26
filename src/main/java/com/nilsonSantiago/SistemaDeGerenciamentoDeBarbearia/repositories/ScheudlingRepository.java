package com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.repositories;

import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.entities.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheudlingRepository extends JpaRepository<Scheduling, Long> {
}
