package com.example.demo.controller;

import com.example.demo.dao.ReportRepo;
import com.example.demo.models.Sales;
import com.example.demo.services.ReportServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReportController {
    private ReportServices reportServices;

    public ReportController(ReportServices reportServices) {
        this.reportServices = reportServices;
    }
    @GetMapping("/report")
    public String getFristReport(@RequestBody String date){
        String frist =reportServices.fristRepo(date);
        if (frist == null){
            throw new RuntimeException("sales is not found "+date);
        }
        return frist;

    }
}
