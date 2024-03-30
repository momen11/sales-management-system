package com.example.demo.dao;

import com.example.demo.models.Product;
import com.example.demo.models.Transaction;

import java.util.List;

public interface TransactionRepo {
    Transaction save(Transaction transaction);
    List<Transaction> findall();
    Transaction findbyid(int theid);
    void deletebyid(int theid);

}
