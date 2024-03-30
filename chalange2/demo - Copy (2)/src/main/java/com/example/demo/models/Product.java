package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "description")
    private String Description;
    @Column(name = "category")
    private String Category;
    @Column(name = "creation_date")
    private String CreationDate;
    @Column(name = "available_quantity")
    private int AvailableQuantity;
    @Column(name = "price")
    private float Price;
    public Product(){

    }

    public Product(String name, String description, String category, String creationDate, int availableQuantity, float price)
    {
        Name = name;
        Description = description;
        Category = category;
        CreationDate = creationDate;
        AvailableQuantity = availableQuantity;
        Price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public int getAvailableQuantity() {
        return AvailableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        AvailableQuantity = availableQuantity;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Category='" + Category + '\'' +
                ", CreationDate='" + CreationDate + '\'' +
                ", AvailableQuantity=" + AvailableQuantity +
                ", Price=" + Price +
                '}';
    }
}
