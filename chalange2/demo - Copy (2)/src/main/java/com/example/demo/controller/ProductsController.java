package com.example.demo.controller;

import com.example.demo.models.Product;
import com.example.demo.services.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductsController {

    private ProductsServices productsServices;
@Autowired
    public ProductsController(ProductsServices theProductsServices){
        productsServices=theProductsServices;
    }
    @GetMapping("/product")
    public List<Product> findall(){
        return productsServices.findall();
    }

    @GetMapping("/product/{productid}")
    public Product getProductid(@PathVariable int productid){
        Product theProduct =productsServices.findbyid(productid);
        if (theProduct == null){
            throw new RuntimeException("Product is not found "+productid);
        }
        return theProduct;

    }
    @PostMapping("/product")
    public Product save(@RequestBody Product theProduct){
      Product tempProduct=productsServices.save(theProduct);
      return tempProduct;
    }
    @DeleteMapping("/product/{productid}")
    public String deleteProduct(@PathVariable int productid){
        Product tempProduct =productsServices.findbyid(productid);
        //thow exception if null
        if(tempProduct == null){
            throw new RuntimeException("Product is not found " + productid);
        }
        productsServices.deletebyid(productid);
        return "Delete Product id-> " + productid;
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product theProduct){
        Product tempProduct = productsServices.save(theProduct);
        return tempProduct;
    }
}
