package com.example.demo.controller;

import com.example.demo.models.Clients;
import com.example.demo.models.Sallers;
import com.example.demo.services.ClientsServices;
import com.example.demo.services.SallersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class SallersController {

    private SallersServices sallersServices;
    @Autowired
    public SallersController( SallersServices theSallersServices)
    {

        sallersServices=theSallersServices;
    }
    @GetMapping("/saller")
    public List<Sallers> findall(){
        return sallersServices.findall();
    }

    @GetMapping("/saller/{sallerid}")
    public Sallers getSallersid(@PathVariable int sallerid){
        Sallers theSallers =sallersServices.findbyid(sallerid);
        if (theSallers == null){
            throw new RuntimeException("saller is not found "+sallerid);
        }
        return theSallers;

    }
    @PostMapping("/saller")
    public Sallers save(@RequestBody Sallers theSallers){
        Sallers tempSallers=sallersServices.save(theSallers);
        return tempSallers;
    }
    @DeleteMapping("/saller/{sallerid}")
    public String deleteSallers(@PathVariable int sallerid){
        Sallers tempSallers =sallersServices.findbyid(sallerid);
        //thow exception if null
        if(tempSallers == null){
            throw new RuntimeException("saller is not found " + sallerid);
        }
        sallersServices.deletebyid(sallerid);
        return "Delete saller id-> " + sallerid;
    }

    @PutMapping("/saller")
    public Sallers updateSallers(@RequestBody Sallers theSallers){
        Sallers tempSallers = sallersServices.save(theSallers);
        return tempSallers;
    }
}
