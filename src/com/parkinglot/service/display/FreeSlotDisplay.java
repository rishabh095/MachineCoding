package com.parkinglot.service.display;

import com.parkinglot.model.vehicle.Vehicle;
import com.parkinglot.model.vehicle.VehicleTypeEnum;
import com.parkinglot.service.parking.ParkingService;

import java.util.Map;

import static com.parkinglot.common.CommonConstant.*;

public class FreeSlotDisplay implements DisplayStrategy {
    Map<Integer, Map<Integer, Vehicle>> slotsPerFloor = ParkingService.slotsPerFloor;

    @Override
    public void display(VehicleTypeEnum vehicleType) {
        switch (vehicleType) {
            case CAR:
                for (int i = 1; i <= slotsPerFloor.size(); i++) {
                    System.out.print("Free slots for CAR on Floor " + i + " : ");
                    for (Map.Entry<Integer, Vehicle> entry : slotsPerFloor.get(i).entrySet()) {
                        if (entry.getKey() >= CAR_SLOTS_START_FROM && entry.getValue() == null)
                            System.out.print(entry.getKey() + " ");
                    }
                    System.out.println();
                }
                break;
            case BIKE:
                for (int i = 1; i <= slotsPerFloor.size(); i++) {
                    System.out.print("Free slots for BIKE on Floor  " + i + " : ");
                    for (Map.Entry<Integer, Vehicle> entry : slotsPerFloor.get(i).entrySet()) {
                        if ((entry.getKey() >= BIKE_SLOTS_START_FROM && entry.getKey() < CAR_SLOTS_START_FROM)
                                && entry.getValue() == null)
                            System.out.print(entry.getKey() + " ");
                    }
                    System.out.println();
                }
                break;
            case TRUCK:
                for (int i = 1; i <= slotsPerFloor.size(); i++) {
                    System.out.print("Free slots for TRUCK on Floor " + i + " : ");
                    for (Map.Entry<Integer, Vehicle> entry : slotsPerFloor.get(i).entrySet()) {
                        if ((entry.getKey() >= TRUCK_SLOTS_START_FROM && entry.getKey() < BIKE_SLOTS_START_FROM)
                                && entry.getValue() == null)
                            System.out.print(entry.getKey() + " ");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
