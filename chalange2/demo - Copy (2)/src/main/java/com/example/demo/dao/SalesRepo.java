package com.example.demo.dao;

import com.example.demo.models.Clients;
import com.example.demo.models.Sales;

import java.util.List;

public interface SalesRepo {
    Sales save(Sales sales);
    List<Sales> findall();
    Sales findbyid(int theid);
    void deletebyid(int theid);
}
