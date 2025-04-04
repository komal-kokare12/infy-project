package com.example.Login.model;

public class AdminDetails {
    private String name;
    private String phone;
    private String societyId;
    private String societyName;
    private String societyAddress;
    private String city;
    private String district;
    private String postal;

    // Constructor
    public AdminDetails() {}

    public AdminDetails(String name, String phone, String societyId, String societyName,
                        String societyAddress, String city, String district, String postal) {
        this.name = name;
        this.phone = phone;
        this.societyId = societyId;
        this.societyName = societyName;
        this.societyAddress = societyAddress;
        this.city = city;
        this.district = district;
        this.postal = postal;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getSocietyAddress() {
        return societyAddress;
    }

    public void setSocietyAddress(String societyAddress) {
        this.societyAddress = societyAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }
}
