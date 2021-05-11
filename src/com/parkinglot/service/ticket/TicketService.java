package com.parkinglot.service.ticket;

import com.parkinglot.model.parking.Parking;
import com.parkinglot.model.vehicle.Vehicle;
import com.parkinglot.service.parking.ParkingService;

import java.util.HashMap;
import java.util.Map;

public class TicketService implements ITicketService {
    public static Map<String, Vehicle> ticketMap = new HashMap<>();
    public static Map<String, Parking> parkingMap = ParkingService.parkingMap;
    String parkingId;
    static Map<Integer, Map<Integer, Vehicle>> slotsPerFloor = ParkingService.slotsPerFloor;

    @Override
    public String createTicket(Vehicle vehicle, int floor, int floorSlot) {
        for (Map.Entry<String, Parking> parking : parkingMap.entrySet()) {
            parkingId = parking.getKey();
            break;
        }
        String ticketId = generateTicketId(parkingId, floor, floorSlot);
        ticketMap.put(ticketId, vehicle);
        return ticketId;
    }

    @Override
    public void removeTicket(String ticketId) {
        Vehicle vehicle = null;
        boolean flag = false;
        if (ticketMap.containsKey(ticketId)) {
            vehicle = ticketMap.get(ticketId);
        }
        for (Map.Entry<Integer, Map<Integer, Vehicle>> floors : slotsPerFloor.entrySet()) {
            for (Map.Entry<Integer, Vehicle> slots : floors.getValue().entrySet()) {
                Vehicle parkedVehicle = slots.getValue();
                if (vehicle != null && parkedVehicle != null && (slots.getValue().getRegistrationNumber().equals(vehicle.getRegistrationNumber())
                        && slots.getValue().getColor().equals(vehicle.getColor()))) {
                    floors.getValue().put(slots.getKey(), null);
                    flag = true;
                }
            }
        }
        if (flag) {
            System.out.println("UnParked vehicle with Registration Number: " + vehicle.getRegistrationNumber()
                    + " and Color: " + vehicle.getColor());
            ticketMap.remove(ticketId);
        } else
            System.out.println("Invalid Ticket");
    }

    private String generateTicketId(String parkingId, int floor, int floorSlot) {
        return parkingId + "_" + floor + "_" + floorSlot;
    }
}
