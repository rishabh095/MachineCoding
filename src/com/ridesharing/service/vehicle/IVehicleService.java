package com.ridesharing.service.vehicle;

import com.ridesharing.exception.DuplicateVehicleIdException;
import com.ridesharing.model.vehicle.Vehicle;

public interface IVehicleService {
    Vehicle addVehicle(Vehicle vehicle) throws DuplicateVehicleIdException;
}
