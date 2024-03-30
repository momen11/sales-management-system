package com.example.demo.models;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="clients")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String Email;
    @Column(name = "mobile")
    private String Mobile;
    @Column(name = "address")
    private String Address;

   /* @OneToMany(mappedBy = "clients",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Sales> sales;*/

public Clients(){

}
    public Clients(String name, String lastName, String email, String mobile, String address) {
        Name = name;
        this.lastName = lastName;
        Email = email;
        Mobile = mobile;
        Address = address;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getAddress() {
        return Address;
    }



    public void setAddress(String address) {
        Address = address;
    }

  /*  public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    public void add(Sales tempSales){
        if(sales==null){
            sales=new ArrayList<>();

        }
        sales.add(tempSales);
        tempSales.setClients(this);
    }*/

    @Override
    public String toString() {
        return "Clients{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
