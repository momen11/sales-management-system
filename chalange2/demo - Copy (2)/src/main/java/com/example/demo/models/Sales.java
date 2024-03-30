package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "creation_date")
    private String creationDate;
    @Column(name = "total")
    private float total;
    @Column(name = "id_client")
private int idClients;
    @Column(name = "id_seller")
    private int idSeller;
  /*  @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_client")
    private Clients clients;


    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_seller")
    private Sallers sallers;*/
    public Sales(){

    }




/*public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public Sallers getSallers() {
        return sallers;
    }

    public void setSallers(Sallers sallers) {
        this.sallers = sallers;
    }*/

    public Sales(String creationDate, float total, int idClients, int idSeller) {
        this.creationDate = creationDate;
        this.total = total;
        this.idClients = idClients;
        this.idSeller = idSeller;
    }

    public int getIdClients() {
        return idClients;
    }

    public void setIdClients(int idClients) {
        this.idClients = idClients;
    }

    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", creationDate='" + creationDate + '\'' +
                ", total=" + total +
                '}';
    }
}
