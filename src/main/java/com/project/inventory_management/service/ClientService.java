package com.project.inventory_management.service;

import com.project.inventory_management.entity.Client;
import com.project.inventory_management.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private final ClientRepository repo;

    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }

    public List<Client> findAll() {
        return repo.findAll();
    }

    public Optional<Client> findById(Long id) {
        return repo.findById(id);
    }

    public Client save(Client client) {
        return repo.save(client);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}

