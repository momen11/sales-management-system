package com.example.demo.services;

import com.example.demo.dao.ReportRepo;
import com.example.demo.models.Sales;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class ReportServices implements ReportServicesInter{
    private ReportRepo reportRepo;

    public ReportServices(ReportRepo reportRepo) {
        this.reportRepo = reportRepo;
    }

    @Override
    public String fristRepo(String date) {
        List<Sales> Saless=reportRepo.findBycreationDate(date);
        double totalRevenue = 0;
        HashMap<Integer, Integer> bestSellers = new HashMap<Integer, Integer>();
        for(Sales sale:Saless) {
            totalRevenue += sale.getTotal();
            int count =
                    bestSellers.getOrDefault(sale.getIdSeller(), 0);
            bestSellers.put(sale.getIdSeller(), count + 1);
        }
        int big=0;
        int best=0;
        for (int i=0;i<bestSellers.size();i++){
            if(big<bestSellers.get(i)){
                big=bestSellers.get(i);
                best=i;
            }

        }
        String result="totalSales is "+Saless.size()+" total Revenue is "+totalRevenue+" best saller id is "+ best;
        return result;
    }
}
