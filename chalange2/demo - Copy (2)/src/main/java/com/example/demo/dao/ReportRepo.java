package com.example.demo.dao;

import com.example.demo.models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepo extends JpaRepository<Sales,Integer> {
    List<Sales> findBycreationDate(String startDate);


}
