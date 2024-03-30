package com.example.demo.services;

import com.example.demo.models.Product;

import java.util.List;

public interface ProductServicesInter {
    Product save(Product product);
    List<Product> findall();

    Product findbyid(int theid);

    void deletebyid(int theid);
}
