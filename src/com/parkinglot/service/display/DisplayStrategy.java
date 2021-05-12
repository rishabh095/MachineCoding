package com.parkinglot.service.display;

import com.parkinglot.model.vehicle.VehicleTypeEnum;

public interface DisplayStrategy {
    void display(VehicleTypeEnum vehicleType);
}
