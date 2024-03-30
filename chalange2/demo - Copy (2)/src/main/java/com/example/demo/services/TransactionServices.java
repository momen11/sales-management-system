package com.example.demo.services;

import com.example.demo.dao.TransactionRepo;
import com.example.demo.models.Product;
import com.example.demo.models.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TransactionServices implements TransactionServicesInter{
    private TransactionRepo transactionRepo;

    public TransactionServices(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

@Transactional
    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    @Override
    public List<Transaction> findall() {
        // excute query and get result list
        List<Transaction> transactions = transactionRepo.findall();

        // return the result

        return transactions;
    }

    @Override
    public Transaction findbyid(int theid) {
        Transaction transaction = transactionRepo.findbyid(theid);
        return transaction;
    }
@Transactional
    @Override
    public void deletebyid(int theid) {
transactionRepo.deletebyid(theid);
    }
}
