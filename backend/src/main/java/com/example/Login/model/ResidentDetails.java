package com.example.Login.model;

public class ResidentDetails {
    private String name;
    private String phone;
    private String societyId;
    private String societyName;
    private String flatNo;
    private String postal;
    private String block;  // Add this field

    // Constructor
    public ResidentDetails() {}

    public ResidentDetails(String name, String phone, String societyId, String societyName,
                           String flatNo, String postal) {
        this.name = name;
        this.phone = phone;
        this.societyId = societyId;
        this.societyName = societyName;
        this.flatNo = flatNo;
        this.postal = postal;
    }

    // Getters and Setters

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

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

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }
}
