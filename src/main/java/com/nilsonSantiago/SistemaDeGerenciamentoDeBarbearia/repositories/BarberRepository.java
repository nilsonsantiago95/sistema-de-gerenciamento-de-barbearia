package com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.repositories;

import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.entities.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, Long> {
}