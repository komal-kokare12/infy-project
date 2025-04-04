package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "guards")
public class Guard {

    @Id
    private String id;
    private String name;
    private String block;
    private String phone;

    // Constructors
    public Guard() {}

    public Guard(String name, String block, String phone) {
        this.name = name;
        this.block = block;
        this.phone = phone;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBlock() {
        return block;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
