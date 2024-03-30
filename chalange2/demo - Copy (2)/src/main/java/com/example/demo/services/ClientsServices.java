package com.example.demo.services;

import com.example.demo.dao.ClientsRepo;
import com.example.demo.models.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClientsServices implements ClientsServicesInter {
   private ClientsRepo clientsRepo;
@Autowired
    public ClientsServices( ClientsRepo clientsRepo) {
        this.clientsRepo = clientsRepo;
    }
@Transactional
    @Override
    public Clients save(Clients clients) {
        return clientsRepo.save(clients);
    }

    @Override
    public List<Clients> findall() {
    List<Clients> clients = clientsRepo.findall();
        return clients;
    }

    @Override
    public Clients findbyid(int theid) {
    Clients clients=clientsRepo.findbyid(theid);
        return clients;
    }
@Transactional
    @Override
    public void deletebyid(int theid) {
      clientsRepo.deletebyid(theid);
    }
}
