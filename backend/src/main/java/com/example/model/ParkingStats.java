package com.example.model;


public class ParkingStats {
    private int totalSpaces;
    private int occupied;
    private int available;
    private int percentageOccupied;

    public ParkingStats(int totalSpaces, int occupied, int available, int percentageOccupied) {
        this.totalSpaces = totalSpaces;
        this.occupied = occupied;
        this.available = available;
        this.percentageOccupied = percentageOccupied;
    }

    // Getters
    public int getTotalSpaces() {
        return totalSpaces;
    }

    public int getOccupied() {
        return occupied;
    }

    public int getAvailable() {
        return available;
    }

    public int getPercentageOccupied() {
        return percentageOccupied;
    }
}