package com.parkinglot.model.parking;

import com.parkinglot.exception.InvalidParkingLotException;

public class Parking {
    private String id;
    private int noOfFloors;
    private int noOfSlotsPerFloor;

    public Parking(String id, int noOfFloors, int noOfSlotsPerFloor) throws InvalidParkingLotException {
        if(noOfFloors<=0 || noOfSlotsPerFloor<=0)
            throw new InvalidParkingLotException("invalid no of floors or slots for parking.");
        this.id = id;
        this.noOfFloors = noOfFloors;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public int getNoOfSlotsPerFloor() {
        return noOfSlotsPerFloor;
    }

    public void setNoOfSlotsPerFloor(int noOfSlotsPerFloor) {
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id='" + id + '\'' +
                ", noOfFloors=" + noOfFloors +
                ", noOfSlotsPerFloor=" + noOfSlotsPerFloor +
                '}';
    }
}
