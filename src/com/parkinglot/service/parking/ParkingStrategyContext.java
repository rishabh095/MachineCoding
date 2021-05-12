package com.parkinglot.service.parking;

import com.parkinglot.model.vehicle.VehicleTypeEnum;

public class ParkingStrategyContext {

    public ParkingStrategy getParkingStrategy(VehicleTypeEnum vehicleType) {
        switch (vehicleType) {
            case CAR:
                return new CarParking();
            case BIKE:
                return new BikeParking();
            case TRUCK:
                return new TruckParking();
            default:
                return null;
        }
    }
}
