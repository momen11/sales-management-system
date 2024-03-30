package com.example.demo.models;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="sallers")
public class Sallers {
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

  /*  @OneToMany(mappedBy = "sallers",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Sales> sales;*/
    public Sallers(){

    }
    public Sallers(String name, String lastName, String email, String mobile, String address) {
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

  /*  public void add(Sales tempSales){
        if(sales==null){
            sales=new ArrayList<>();

        }
        sales.add(tempSales);
        tempSales.setSallers(this);
    }*/

    @Override
    public String toString() {
        return "Sallers{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
