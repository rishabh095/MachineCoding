package com.parkinglot.service.display;

import com.parkinglot.model.vehicle.Vehicle;
import com.parkinglot.model.vehicle.VehicleTypeEnum;
import com.parkinglot.service.parking.ParkingService;

import java.util.Map;

import static com.parkinglot.common.CommonConstant.*;

public class OccupiedSlotDisplay implements DisplayStrategy {
    Map<Integer, Map<Integer, Vehicle>> slotsPerFloor = ParkingService.slotsPerFloor;

    @Override
    public void display(VehicleTypeEnum vehicleType) {
        int occupiedSlots;
        switch (vehicleType) {
            case CAR:
                occupiedSlots = 0;
                for (int i = 1; i <= slotsPerFloor.size(); i++) {
                    for (Map.Entry<Integer, Vehicle> entry : slotsPerFloor.get(i).entrySet()) {
                        if (entry.getKey() >= CAR_SLOTS_START_FROM && entry.getValue() != null)
                            occupiedSlots++;
                    }
                    System.out.println("Occupied slots for CAR on Floor " + i + " : " + occupiedSlots);
                    occupiedSlots = 0;
                }
                break;
            case BIKE:
                occupiedSlots = 0;
                for (int i = 1; i <= slotsPerFloor.size(); i++) {
                    for (Map.Entry<Integer, Vehicle> entry : slotsPerFloor.get(i).entrySet()) {
                        if ((entry.getKey() >= BIKE_SLOTS_START_FROM && entry.getKey() < CAR_SLOTS_START_FROM)
                                && entry.getValue() != null)
                            occupiedSlots++;
                    }
                    System.out.println("Occupied slots for BIKE on Floor " + i + " : " + occupiedSlots);
                    occupiedSlots = 0;
                }
                break;
            case TRUCK:
                occupiedSlots = 0;
                for (int i = 1; i <= slotsPerFloor.size(); i++) {
                    for (Map.Entry<Integer, Vehicle> entry : slotsPerFloor.get(i).entrySet()) {
                        if ((entry.getKey() >= TRUCK_SLOTS_START_FROM && entry.getKey() < BIKE_SLOTS_START_FROM)
                                && entry.getValue() != null)
                            occupiedSlots++;
                    }
                    System.out.println("Occupied slots for TRUCK on Floor " + i + " : " + occupiedSlots);
                    occupiedSlots = 0;
                }
                break;
        }
    }
}
