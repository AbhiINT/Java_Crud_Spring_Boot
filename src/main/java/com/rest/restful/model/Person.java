package com.rest.restful.model;

public class Person {
    private Long id;
    private String name;
    private String address;
    private String MobileNumber;

    public Person(Long id, String name, String mobileNumber, String address) {
        this.id = id;
        this.name = name;
        this.MobileNumber = mobileNumber;
        this.address = address;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

}
