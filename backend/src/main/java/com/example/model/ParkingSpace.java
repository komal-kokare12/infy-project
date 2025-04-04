package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parking_spaces")
public class ParkingSpace {
    @Id
    private String id;
    private String parkingId;
    private String block;
    private String flatNo;
    private String residentName;
    private boolean isOccupied;

    // Constructors
    public ParkingSpace() {}

    public ParkingSpace(String parkingId, String block, String flatNo, String residentName, boolean isOccupied) {
        this.parkingId = parkingId;
        this.block = block;
        this.flatNo = flatNo;
        this.residentName = residentName;
        this.isOccupied = isOccupied;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}