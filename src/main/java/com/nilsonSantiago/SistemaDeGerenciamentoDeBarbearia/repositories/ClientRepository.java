package com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.repositories;

import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
