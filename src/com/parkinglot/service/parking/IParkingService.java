package com.parkinglot.service.parking;

import com.parkinglot.exception.InvalidParkingLotException;
import com.parkinglot.model.display.DisplayTypeEnum;
import com.parkinglot.model.vehicle.Vehicle;
import com.parkinglot.model.vehicle.VehicleTypeEnum;

public interface IParkingService {
    void createParking(String parkingId, int noOfFloors, int noOfSlotsPerFloor) throws InvalidParkingLotException;

    String parkVehicle(Vehicle vehicle);

    void unParkVehicle(String ticketId);

    void display(DisplayTypeEnum display, VehicleTypeEnum vehicleType);
}
