package com.example.demo.dao;

import com.example.demo.models.Clients;
import com.example.demo.models.Product;
import com.example.demo.models.Sales;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SalesRepoImp implements SalesRepo{
    public EntityManager entityManager;
    @Autowired
    public SalesRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Sales save(Sales sales) {
        Sales theSales =  entityManager.merge(sales);
        return theSales;    }

    @Override
    public List<Sales> findall() {
        return entityManager.createQuery("SELECT p FROM sales p", Sales.class).getResultList();
    }

    @Override
    public Sales findbyid(int theid) {
        Sales sales = entityManager.find(Sales.class,theid);
        return sales;
    }

    @Override
    public void deletebyid(int theid) {
        Sales sales= entityManager.find(Sales.class,theid);
        entityManager.remove(sales);
    }
}
