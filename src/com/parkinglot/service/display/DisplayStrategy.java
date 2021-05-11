package com.parkinglot.service.display;

import com.parkinglot.model.display.DisplayTypeEnum;
import com.parkinglot.model.vehicle.VehicleTypeEnum;

public class DisplayStrategy {

    public static void display(DisplayTypeEnum displayType, VehicleTypeEnum vehicleType){
        switch (displayType){
            case FREE_SLOT:
                new FreeSlotDisplay(vehicleType);
                break;
            case FREE_COUNT:
                new FreeCountDisplay(vehicleType);
                break;
            case OCCUPIED_SLOT:
                new OccupiedSlotDisplay(vehicleType);
                break;
        }
    }

}
