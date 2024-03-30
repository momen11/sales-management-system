package com.example.demo.dao;

import com.example.demo.models.Clients;
import com.example.demo.models.Product;
import com.example.demo.models.Sallers;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class SallersRepoImp implements SallersRepo{
    public EntityManager entityManager;
@Autowired
    public SallersRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Sallers save(Sallers sallers) {
        Sallers theSallers =  entityManager.merge(sallers);
        return theSallers;
    }

    @Override
    public List<Sallers> findall() {
        return entityManager.createQuery("SELECT p FROM sallers p", Sallers.class).getResultList();
    }

    @Override
    public Sallers findbyid(int theid) {
        Sallers sallers = entityManager.find(Sallers.class,theid);
        return sallers;
    }

    @Override
    public void deletebyid(int theid) {
        Sallers sallers= entityManager.find(Sallers.class,theid);
        entityManager.remove(sallers);
    }
}
