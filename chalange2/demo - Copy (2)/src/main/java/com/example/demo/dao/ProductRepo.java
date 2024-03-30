package com.example.demo.dao;

import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepo {
 Product save(Product product);
 List<Product> findall();
 Product findbyid(int theid);
 void deletebyid(int theid);
}
