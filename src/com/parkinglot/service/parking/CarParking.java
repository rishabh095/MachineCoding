package com.parkinglot.service.parking;

import com.parkinglot.model.vehicle.Vehicle;
import com.parkinglot.service.ticket.TicketService;

import java.util.Map;

import static com.parkinglot.common.CommonConstant.BIKE_SLOTS_START_FROM;
import static com.parkinglot.common.CommonConstant.CAR_SLOTS_START_FROM;

public class CarParking {
    static Map<Integer, Map<Integer, Vehicle>> slotsPerFloor = ParkingService.slotsPerFloor;
    static boolean flag;
    TicketService ticketService = new TicketService();

    public String parkCar(Vehicle vehicle) {
        flag = false;
        for (int i = 1; i <= slotsPerFloor.size(); i++) {
            Map<Integer, Vehicle> slotsMap = slotsPerFloor.get(i);
            for (Map.Entry<Integer, Vehicle> entry : slotsMap.entrySet()) {
                if (entry.getKey() >= CAR_SLOTS_START_FROM
                        && entry.getValue() == null) {
                    slotsMap.put(entry.getKey(), vehicle);
                    flag = true;
                    return ticketService.createTicket(vehicle, i, entry.getKey());
                }
            }
        }
        if (!flag)
            System.out.println("Car Parking Lot is Full");
        return "";
    }
}