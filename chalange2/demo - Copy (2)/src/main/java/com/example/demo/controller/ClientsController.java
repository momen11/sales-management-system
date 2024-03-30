package com.example.demo.controller;

import com.example.demo.models.Clients;
import com.example.demo.models.Product;
import com.example.demo.services.ClientsServices;
import com.example.demo.services.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ClientsController {
    private ClientsServices clientsServices;
    @Autowired
    public ClientsController( ClientsServices theClientsServices){

        clientsServices=theClientsServices;
    }
    @GetMapping("/client")
    public List<Clients> findall(){
        return clientsServices.findall();
    }

    @GetMapping("/client/{clientid}")
    public Clients getClientsid(@PathVariable int clientid){
        Clients theClients =clientsServices.findbyid(clientid);
        if (theClients == null){
            throw new RuntimeException("client is not found "+clientid);
        }
        return theClients;

    }
    @PostMapping("/client")
    public Clients save(@RequestBody Clients theClients){
        Clients tempClients=clientsServices.save(theClients);
        return tempClients;
    }
    @DeleteMapping("/client/{clientid}")
    public String deleteClients(@PathVariable int clientid){
        Clients tempClients =clientsServices.findbyid(clientid);
        //thow exception if null
        if(tempClients == null){
            throw new RuntimeException("Clients is not found " + clientid);
        }
        clientsServices.deletebyid(clientid);
        return "Delete client id-> " + clientid;
    }

    @PutMapping("/client")
    public Clients updateClients(@RequestBody Clients theClients){
        Clients tempClients = clientsServices.save(theClients);
        return tempClients;
    }


}
