package com.ridesharing.service.vehicle;

import com.ridesharing.exception.DuplicateUserIdException;
import com.ridesharing.exception.DuplicateVehicleIdException;
import com.ridesharing.model.user.User;
import com.ridesharing.model.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleService implements IVehicleService {
    public static Map<String, Vehicle> vehicleMap = new HashMap<>();

    @Override
    public Vehicle addVehicle(Vehicle vehicle) throws DuplicateVehicleIdException {
        if (vehicleMap.containsKey(vehicle.getId()))
            throw new DuplicateVehicleIdException("Vehicle id already exists.");
        vehicleMap.put(vehicle.getId(), vehicle);
        System.out.println("Vehicle registered ");
        return vehicle;
    }
}
