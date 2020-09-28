package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(Client client) {
        this.clientRepository.save(client);
    }

    public void deleteClient(UUID id) {
        this.clientRepository.deleteById(id);
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }
}
