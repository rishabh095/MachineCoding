package com.ridesharing.model.vehicle;

import com.ridesharing.model.user.User;

public class Vehicle {
    private final String id;
    private final User user;
    private final String vehicleName;
    private final String registrationNumber;
    private VehicleRideStatusEnum rideStatus;

    public Vehicle(String id, User user, String vehicleName, String registrationNumber) {
        this.id = id;
        this.user = user;
        this.vehicleName = vehicleName;
        this.registrationNumber = registrationNumber;
        this.rideStatus = VehicleRideStatusEnum.RIDE_NOT_OFFERED;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleRideStatusEnum getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(VehicleRideStatusEnum rideStatus) {
        this.rideStatus = rideStatus;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", vehicleName='" + vehicleName + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", rideStatus=" + rideStatus +
                '}';
    }

}

