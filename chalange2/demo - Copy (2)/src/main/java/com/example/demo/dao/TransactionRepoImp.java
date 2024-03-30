package com.example.demo.dao;

import com.example.demo.models.Product;
import com.example.demo.models.Transaction;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TransactionRepoImp implements TransactionRepo{
    public EntityManager entityManager;

    public TransactionRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Transaction save(Transaction transaction) {
        Transaction thetransaction =  entityManager.merge(transaction);
        return thetransaction;
    }

    @Override
    public List<Transaction> findall() {
        return entityManager.createQuery("SELECT p FROM transactions p", Transaction.class).getResultList();
    }

    @Override
    public Transaction findbyid(int theid) {
        Transaction transaction = entityManager.find(Transaction.class,theid);
        return transaction;
    }

    @Override
    public void deletebyid(int theid) {
        Transaction transaction= entityManager.find(Transaction.class,theid);
        entityManager.remove(transaction);
    }
}
