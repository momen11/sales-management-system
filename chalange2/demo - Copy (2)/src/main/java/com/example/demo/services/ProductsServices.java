package com.example.demo.services;

import com.example.demo.dao.ProductRepo;
import com.example.demo.models.Product;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductsServices implements ProductServicesInter
{
    private ProductRepo productRepo;

@Autowired
    public ProductsServices(ProductRepo productRepo){

        this.productRepo = productRepo;
    }
    @Transactional
    @Override
    public Product save(Product theProduct){
       return productRepo.save(theProduct);
    }
    @Override
    public List<Product> findall() {

        // excute query and get result list
        List<Product> Products = productRepo.findall();

        // return the result

        return Products;

    }

    @Override
    public Product findbyid(int theid) {
        Product product = productRepo.findbyid(theid);
        return product;
    }
@Transactional
    @Override
    public void deletebyid(int theid) {
        productRepo.deletebyid(theid);
    }

}
