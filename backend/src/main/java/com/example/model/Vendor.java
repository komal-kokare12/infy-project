package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendors") // MongoDB collection name
public class Vendor {

    @Id
    private String id;
    private int serialNo;
    private String name;
    private String service;
    private String company;
    private String phoneNo;

    public Vendor() {}

    public Vendor(int serialNo, String name, String service, String company, String phoneNo) {
        this.serialNo = serialNo;
        this.name = name;
        this.service = service;
        this.company = company;
        this.phoneNo = phoneNo;
    }

    public String getId() {
        return id;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public String getService() {
        return service;
    }

    public String getCompany() {
        return company;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
