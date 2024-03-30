package com.example.demo.services;

import com.example.demo.dao.SalesRepo;
import com.example.demo.models.Product;
import com.example.demo.models.Sales;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SalesServices implements SalesServicesInter{
    public SalesRepo salesRepo;

    public SalesServices(SalesRepo salesRepo) {
        this.salesRepo = salesRepo;
    }

@Transactional
    @Override
    public Sales save(Sales sales) {
    return salesRepo.save(sales);
    }

    @Override
    public List<Sales> findall() {
        // excute query and get result list
        List<Sales> sales = salesRepo.findall();

        // return the result

        return sales;

    }

    @Override
    public Sales findbyid(int theid) {
        Sales sales = salesRepo.findbyid(theid);
        return sales;
    }
    @Transactional
    @Override
    public void deletebyid(int theid) {
        salesRepo.deletebyid(theid);
    }
}
