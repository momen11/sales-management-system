package com.example.demo.dao;

import com.example.demo.models.Clients;
import com.example.demo.models.Product;

import java.util.List;

public interface ClientsRepo {
    Clients save(Clients clients);
    List<Clients> findall();
    Clients findbyid(int theid);
    void deletebyid(int theid);
}
