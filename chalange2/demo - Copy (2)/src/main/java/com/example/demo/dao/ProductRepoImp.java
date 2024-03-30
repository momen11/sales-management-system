package com.example.demo.dao;

import com.example.demo.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepoImp implements ProductRepo {
    public EntityManager entityManager;

    public ProductRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

   /* public  ProductRepoImp(){

    }*/

    @Override
    public Product save(Product product) {
        Product theProduct =  entityManager.merge(product);
        return theProduct;
    }

    @Override
    public List<Product> findall() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();

       /* TypedQuery<Product> theQuery =     entityManager.createQuery("from products",Product.class);

        // excute query and get result list
        List<Product> Product = theQuery.getResultList();

        // return the result

        return Product;*/

    }

    @Override
    public Product findbyid(int theid) {
        Product product = entityManager.find(Product.class,theid);
        return product;
    }

    @Override
    public void deletebyid(int theid) {
        Product product= entityManager.find(Product.class,theid);
        entityManager.remove(product);
    }
}
