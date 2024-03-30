package com.example.demo.controller;

import com.example.demo.models.Clients;
import com.example.demo.models.Transaction;
import com.example.demo.services.TransactionServices;
import com.example.demo.services.TransactionServicesInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {
    private TransactionServices transactionServices;
@Autowired
    public TransactionController(TransactionServices transactionServices) {
        this.transactionServices = transactionServices;
    }
    @GetMapping("/transaction")
    public List<Transaction> findall(){
        return transactionServices.findall();
    }

    @GetMapping("/transaction/{transactionid}")
    public Transaction getTransactionid(@PathVariable int transactionid){
        Transaction theTransaction =transactionServices.findbyid(transactionid);
        if (theTransaction == null){
            throw new RuntimeException("theTransaction is not found "+transactionid);
        }
        return theTransaction;

    }
    @PostMapping("/transaction")
    public Transaction save(@RequestBody Transaction theTransaction){
        Transaction tempTransaction=transactionServices.save(theTransaction);
        return tempTransaction;
    }
    @DeleteMapping("/transaction/{transactionid}")
    public String deleteTransaction(@PathVariable int transactionid){
        Transaction tempTransaction =transactionServices.findbyid(transactionid);
        //thow exception if null
        if(tempTransaction == null){
            throw new RuntimeException("Transaction is not found " + transactionid);
        }
        transactionServices.deletebyid(transactionid);
        return "Delete Transaction id-> " + transactionid;
    }

    @PutMapping("/transaction")
    public Transaction updateTransaction(@RequestBody Transaction theTransaction){
        Transaction tempTransaction = transactionServices.save(theTransaction);
        return tempTransaction;
    }


}
