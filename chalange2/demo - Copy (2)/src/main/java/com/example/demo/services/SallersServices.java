package com.example.demo.services;

import com.example.demo.dao.SallersRepo;
import com.example.demo.models.Clients;
import com.example.demo.models.Product;
import com.example.demo.models.Sallers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SallersServices implements SallersServicesInter {
    private SallersRepo sallersRepo;
@Autowired
    public SallersServices( SallersRepo sallersRepo) {
        this.sallersRepo = sallersRepo;
    }
@Transactional
    @Override
    public Sallers save(Sallers sallers) {
        return sallersRepo.save(sallers);
    }

    @Override
    public List<Sallers> findall() {
        List<Sallers> sallers = sallersRepo.findall();

        return sallers;
    }

    @Override
    public Sallers findbyid(int theid) {
        Sallers sallers=sallersRepo.findbyid(theid);
        return sallers;
    }
@Transactional
    @Override
    public void deletebyid(int theid) {
          sallersRepo.deletebyid(theid);
    }
}
