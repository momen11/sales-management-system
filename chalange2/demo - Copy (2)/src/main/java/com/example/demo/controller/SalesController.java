package com.example.demo.controller;

import com.example.demo.models.Sales;
import com.example.demo.models.Sallers;
import com.example.demo.services.SalesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SalesController {
    public SalesServices salesServices;
@Autowired
    public SalesController(SalesServices salesServices) {
        this.salesServices = salesServices;
    }
    @GetMapping("/sales")
    public List<Sales> findall(){
        return salesServices.findall();
    }

    @GetMapping("/sales/{salesid}")
    public Sales getSallersid(@PathVariable int salesid){
        Sales theSales =salesServices.findbyid(salesid);
        if (theSales == null){
            throw new RuntimeException("sales is not found "+salesid);
        }
        return theSales;

    }
    @PostMapping("/sales")
    public Sales save(@RequestBody Sales theSales){
        Sales tempSales=salesServices.save(theSales);
        return tempSales;
    }
    @DeleteMapping("/sales/{salesid}")
    public String deleteSales(@PathVariable int salesid){
        Sales tempSales =salesServices.findbyid(salesid);
        //thow exception if null
        if(tempSales == null){
            throw new RuntimeException("saller is not found " + salesid);
        }
        salesServices.deletebyid(salesid);
        return "Delete sales id-> " + salesid;
    }

    @PutMapping("/sales")
    public Sales updateSallers(@RequestBody Sales theSales){
        Sales tempSales = salesServices.save(theSales);
        return tempSales;
    }

}
