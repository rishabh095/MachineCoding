package com.parkinglot.service.parking;

import com.parkinglot.exception.InvalidParkingLotException;
import com.parkinglot.model.display.DisplayTypeEnum;
import com.parkinglot.model.parking.Parking;
import com.parkinglot.model.vehicle.Vehicle;
import com.parkinglot.model.vehicle.VehicleTypeEnum;
import com.parkinglot.service.display.DisplayStrategy;
import com.parkinglot.service.display.DisplayStrategyContext;
import com.parkinglot.service.ticket.TicketService;

import java.util.HashMap;
import java.util.Map;

public class ParkingService implements IParkingService {
    public static Map<String, Parking> parkingMap = new HashMap<>();
    public static Map<Integer, Map<Integer, Vehicle>> slotsPerFloor = new HashMap<>();

    TicketService ticketService = new TicketService();
    DisplayStrategyContext displayStrategyContext = new DisplayStrategyContext();
    ParkingStrategyContext parkingStrategyContext = new ParkingStrategyContext();

    @Override
    public void createParking(String parkingId, int noOfFloors, int noOfSlotsPerFloor) throws InvalidParkingLotException {
        initializePalingSlots(noOfFloors, noOfSlotsPerFloor);
        parkingMap.put(parkingId, new Parking(parkingId, noOfFloors, noOfSlotsPerFloor));
        System.out.println("Created parking lot with " + noOfFloors + " floors and " + noOfSlotsPerFloor + " slots per floor");
    }

    private void initializePalingSlots(int noOfFloors, int noOfSlotsPerFloor) {
        for (int i = 1; i <= noOfFloors; i++) {
            Map<Integer, Vehicle> slots = new HashMap<>();
            for (int j = 1; j <= noOfSlotsPerFloor; j++) {
                slots.put(j, null);
            }
            slotsPerFloor.put(i, slots);
        }
    }


    @Override
    public String parkVehicle(Vehicle vehicle) {
        ParkingStrategy parkingStrategy = parkingStrategyContext.getParkingStrategy(vehicle.getVehicleType());
        return parkingStrategy.parkVehicle(vehicle);
    }

    @Override
    public void unParkVehicle(String ticketId) {
        ticketService.removeTicket(ticketId);
    }

    @Override
    public void display(DisplayTypeEnum displayType, VehicleTypeEnum vehicleType) {
        DisplayStrategy displayStrategy = displayStrategyContext.getDisplayStrategy(displayType);
        if (displayStrategy != null)
            displayStrategy.display(vehicleType);
    }
}
