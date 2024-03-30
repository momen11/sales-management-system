package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.models.Sales;

import java.util.List;

public interface SalesServicesInter {
    Sales save(Sales sales);
    List<Sales> findall();

    Sales findbyid(int theid);

    void deletebyid(int theid);
}
