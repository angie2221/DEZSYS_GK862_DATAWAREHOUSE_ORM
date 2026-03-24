package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Warehouse {

    @Id
    private String warehouse_id;

    private String name;

    private String address;

    private String city;

    private String postal_code;

    private String country;

    private String timestamp;
    @OneToMany(mappedBy = "warehouse")
    private List<Product> products;
    @OneToMany(mappedBy = "warehouse")
    private List<Purchase> purchases;

    public String getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(String warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

