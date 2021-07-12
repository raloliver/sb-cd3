package com.raloliver.sbcd3.models;

public class Client {

    private int id;
    private String name;
    private String taxNumber;

    public Client(int id, String name, String taxNumber) {
        this.id = id;
        this.name = name;
        this.taxNumber = taxNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

}
