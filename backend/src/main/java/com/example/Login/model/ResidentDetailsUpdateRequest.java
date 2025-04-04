package com.example.Login.model;

public class ResidentDetailsUpdateRequest {
    private String name;
    private String block;
    private String flatNo;
    private String phone;

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBlock() { return block; }
    public void setBlock(String block) { this.block = block; }
    public String getFlatNo() { return flatNo; }
    public void setFlatNo(String flatNo) { this.flatNo = flatNo; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}