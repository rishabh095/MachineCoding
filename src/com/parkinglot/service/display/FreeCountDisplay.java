package com.parkinglot.service.display;

import com.parkinglot.model.vehicle.Vehicle;
import com.parkinglot.model.vehicle.VehicleTypeEnum;
import com.parkinglot.service.parking.ParkingService;

import java.util.Map;

import static com.parkinglot.common.CommonConstant.*;

public class FreeCountDisplay {
    Map<Integer, Map<Integer, Vehicle>> slotsPerFloor = ParkingService.slotsPerFloor;

    public FreeCountDisplay(VehicleTypeEnum vehicleType) {
        int freeCount;
        switch (vehicleType) {
            case CAR:
                freeCount = 0;
                for (int i = 1; i <= slotsPerFloor.size(); i++) {
                    for (Map.Entry<Integer, Vehicle> entry : slotsPerFloor.get(i).entrySet()) {
                        if (entry.getKey() >= CAR_SLOTS_START_FROM && entry.getValue() == null)
                            freeCount++;
                    }
                    System.out.println("No. of free slots for CAR on Floor " + i + " : " + freeCount);
                }
                break;
            case BIKE:
                freeCount = 0;
                for (int i = 1; i <= slotsPerFloor.size(); i++) {
                    for (Map.Entry<Integer, Vehicle> entry : slotsPerFloor.get(i).entrySet()) {
                        if ((entry.getKey() >= BIKE_SLOTS_START_FROM && entry.getKey() < CAR_SLOTS_START_FROM)
                                && entry.getValue() == null)
                            freeCount++;
                    }
                    System.out.println("No. of free slots for BIKE on Floor " + i + " : " + freeCount);
                }
                break;
            case TRUCK:
                freeCount = 0;
                for (int i = 1; i <= slotsPerFloor.size(); i++) {
                    for (Map.Entry<Integer, Vehicle> entry : slotsPerFloor.get(i).entrySet()) {
                        if ((entry.getKey() >= TRUCK_SLOTS_START_FROM && entry.getKey() < BIKE_SLOTS_START_FROM)
                                && entry.getValue() == null)
                            freeCount++;
                    }
                    System.out.println("No. of free slots for Truck on Floor " + i + " : " + freeCount);
                }
                break;
        }
    }
}
