package com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.config;

import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.entities.Barber;
import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.entities.Client;
import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.entities.Scheduling;
import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.enums.Status;
import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.repositories.BarberRepository;
import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.repositories.ClientRepository;
import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.repositories.ScheudlingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ScheudlingRepository scheudlingRepository;

    @Override
    public void run(String... args) throws Exception {

        Barber b1 = new Barber(null, "João", "barba", "imagem.jpg", true);
        Barber b2 = new Barber(null, "Pedro", "cabelo", "imagem2.jpg", true);
        Barber b3 = new Barber(null, "Maria", "cabelo e barba", "imagem3.jpg", true);

        Client c1 = new Client(null, "Carlos", "carlos@gmail.com", "21923456789", "215476");
        Client c2 = new Client(null, "Paulo", "paulo@gmail.com", "21998765432", "768674564");
        Client c3 = new Client(null, "Marcos", "marcos@gmail.com", "2197654635", "34355346");

        Scheduling s1 = new Scheduling(null, LocalDateTime.now(), c1, b1, Status.CONFIRMADO, BigDecimal.valueOf(50.00));
        Scheduling s2 = new Scheduling(null, LocalDateTime.now(), c2, b2, Status.PENDENTE, BigDecimal.valueOf(70.00));
        Scheduling s3 = new Scheduling(null, LocalDateTime.now(), c3, b3, Status.CANCELADO ,BigDecimal.valueOf(90.00));

        barberRepository.saveAll(Arrays.asList(b1, b2, b3));
        clientRepository.saveAll(Arrays.asList(c1, c2, c3));
        scheudlingRepository.saveAll(Arrays.asList(s1, s2, s3));

    }
}