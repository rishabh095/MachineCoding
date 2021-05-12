package com.parkinglot.service.parking;

import com.parkinglot.model.vehicle.Vehicle;

public interface ParkingStrategy {

    String parkVehicle(Vehicle vehicle);
}
