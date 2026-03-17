package com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.services;

import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.entities.Client;
import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client insert(Client client) {
        client = clientRepository.save(client);
        return client;
    }

    public Client findById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        return clientOptional.orElseThrow(() -> new NoSuchElementException("Not found"));
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client update(Client client, Client clientEntity) {

    }

}