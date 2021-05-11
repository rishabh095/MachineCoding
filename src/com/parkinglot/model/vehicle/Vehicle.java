package com.parkinglot.model.vehicle;

public class Vehicle {
    private String id;
    private VehicleTypeEnum vehicleType;
    private String registrationNumber;
    private String color;

    public Vehicle(String id, VehicleTypeEnum vehicleType, String registrationNumber, String color) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleTypeEnum getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleType = vehicleTypeEnum;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", vehicleType=" + vehicleType +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
