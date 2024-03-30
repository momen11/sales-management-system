package com.example.demo.dao;

import com.example.demo.models.Clients;
import com.example.demo.models.Product;
import com.example.demo.models.Sallers;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ClientsRepoImp implements ClientsRepo{
    public EntityManager entityManager;
@Autowired
    public ClientsRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public Clients save(Clients clients) {
        Clients theClients =  entityManager.merge(clients);
        return theClients;
    }

    @Override
    public List<Clients> findall() {
        return entityManager.createQuery("SELECT s FROM clients s", Clients.class).getResultList();
    }

    @Override
    public Clients findbyid(int theid) {
        Clients clients = entityManager.find(Clients.class,theid);
        return clients;
    }

    @Override
    public void deletebyid(int theid) {
        Clients clients= entityManager.find(Clients.class,theid);
        entityManager.remove(clients);
    }
}
