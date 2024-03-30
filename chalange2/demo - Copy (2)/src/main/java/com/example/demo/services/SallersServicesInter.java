package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.models.Sallers;

import java.util.List;

public interface SallersServicesInter {
    Sallers save(Sallers sallers);
    List<Sallers> findall();

    Sallers findbyid(int theid);

    void deletebyid(int theid);
}
