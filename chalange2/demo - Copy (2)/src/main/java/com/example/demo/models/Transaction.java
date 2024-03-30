package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "product")
    private String product;
    @Column(name = "quntity")
    private int quntity;
    @Column(name = "price_for_one")
    private float priceForone;
    @Column(name = "total_price")
    private float totalPrice;
    @Column(name = "sale_id")
private int saleId;
    @Column(name = "product_id")
private int ProductId;

    public Transaction(String product, int quntity, float priceForone, float totalPrice, int saleId, int productId) {
        this.product = product;
        this.quntity = quntity;
        this.priceForone = priceForone;
        this.totalPrice = totalPrice;
        this.saleId = saleId;
        ProductId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }

    public float getPriceForone() {
        return priceForone;
    }

    public void setPriceForone(float priceForone) {
        this.priceForone = priceForone;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }
}
