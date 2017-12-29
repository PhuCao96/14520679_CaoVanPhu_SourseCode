package com.example.phucao.lab3_2_sql;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;

    // Constructor
    public Contact(){}
    public Contact(String name,String phoneNumber) {

        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public Contact(int id, String name,String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
