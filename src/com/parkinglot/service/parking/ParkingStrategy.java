package com.parkinglot.service.parking;

import com.parkinglot.model.vehicle.Vehicle;

public class ParkingStrategy {

    public static String parkVehicle(Vehicle vehicle) {
        switch (vehicle.getVehicleType()) {
            case CAR:
                CarParking carParking = new CarParking();
                return carParking.parkCar(vehicle);
            case BIKE:
                BikeParking bikeParking = new BikeParking();
                return bikeParking.parkBike(vehicle);
            case TRUCK:
                TruckParking truckParking = new TruckParking();
                return truckParking.parkTruck(vehicle);
            default:
                return "";
        }
    }
}
