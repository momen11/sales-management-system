package com.example.demo.services;

import com.example.demo.models.Clients;
import com.example.demo.models.Product;

import java.util.List;

public interface ClientsServicesInter {
    Clients save(Clients clients);
    List<Clients> findall();

    Clients findbyid(int theid);

    void deletebyid(int theid);
}
