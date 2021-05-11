package com.parkinglot;

import com.parkinglot.exception.InvalidParkingLotException;
import com.parkinglot.model.display.DisplayTypeEnum;
import com.parkinglot.model.vehicle.Vehicle;
import com.parkinglot.model.vehicle.VehicleTypeEnum;
import com.parkinglot.service.display.DisplayStrategy;
import com.parkinglot.service.parking.ParkingService;
import com.parkinglot.service.ticket.TicketService;

public class ParkingLotMain {
    public static void main(String[] args) throws InvalidParkingLotException {
        ParkingService parkingService = new ParkingService();

        parkingService.createParking("PR1234", 2, 6);
        DisplayStrategy.display(DisplayTypeEnum.FREE_COUNT, VehicleTypeEnum.TRUCK);
        DisplayStrategy.display(DisplayTypeEnum.FREE_COUNT, VehicleTypeEnum.BIKE);
        DisplayStrategy.display(DisplayTypeEnum.FREE_COUNT, VehicleTypeEnum.CAR);

        DisplayStrategy.display(DisplayTypeEnum.FREE_SLOT, VehicleTypeEnum.TRUCK);
        DisplayStrategy.display(DisplayTypeEnum.FREE_SLOT, VehicleTypeEnum.BIKE);
        DisplayStrategy.display(DisplayTypeEnum.FREE_SLOT, VehicleTypeEnum.CAR);

        DisplayStrategy.display(DisplayTypeEnum.OCCUPIED_SLOT, VehicleTypeEnum.TRUCK);
        DisplayStrategy.display(DisplayTypeEnum.OCCUPIED_SLOT, VehicleTypeEnum.BIKE);
        DisplayStrategy.display(DisplayTypeEnum.OCCUPIED_SLOT, VehicleTypeEnum.CAR);

        //Vehicle vehicle=new Vehicle("1",VehicleTypeEnum.TRUCK,"truck-abc","red");
        String ticketId1 = parkingService.parkVehicle(new Vehicle("1", VehicleTypeEnum.TRUCK, "truck-abc", "red"));
    if(!ticketId1.equals(""))
        System.out.println("Parked vehicle. Ticket ID: "+ticketId1);
        String ticketId2 = parkingService.parkVehicle(new Vehicle("2", VehicleTypeEnum.TRUCK, "truck-abc2", "blue"));
        if(!ticketId2.equals(""))
            System.out.println("Parked vehicle. Ticket ID: "+ticketId2);
        DisplayStrategy.display(DisplayTypeEnum.FREE_COUNT, VehicleTypeEnum.TRUCK);
        DisplayStrategy.display(DisplayTypeEnum.FREE_SLOT, VehicleTypeEnum.TRUCK);
        DisplayStrategy.display(DisplayTypeEnum.OCCUPIED_SLOT, VehicleTypeEnum.TRUCK);
        String ticketId3 = parkingService.parkVehicle(new Vehicle("3", VehicleTypeEnum.TRUCK, "truck-abc3", "blue"));
        if(!ticketId3.equals(""))
            System.out.println("Parked vehicle. Ticket ID: "+ticketId3);
        //TicketService.
        parkingService.unParkVehicle(ticketId2);
        parkingService.unParkVehicle(ticketId3);
        DisplayStrategy.display(DisplayTypeEnum.FREE_COUNT, VehicleTypeEnum.TRUCK);
        DisplayStrategy.display(DisplayTypeEnum.FREE_SLOT, VehicleTypeEnum.TRUCK);
        DisplayStrategy.display(DisplayTypeEnum.OCCUPIED_SLOT, VehicleTypeEnum.TRUCK);
        String ticketId4 = parkingService.parkVehicle(new Vehicle("3", VehicleTypeEnum.TRUCK, "truck-abc3", "blue"));
        if(!ticketId4.equals(""))
            System.out.println("Parked vehicle. Ticket ID: "+ticketId4);
        System.out.println("Bike park");

        String bike1 = parkingService.parkVehicle(new Vehicle("4", VehicleTypeEnum.BIKE, "bike-abc", "black"));
        if(!bike1.equals(""))
            System.out.println("Parked vehicle. Ticket ID: "+bike1);
        String bike2 = parkingService.parkVehicle(new Vehicle("5", VehicleTypeEnum.BIKE, "bike-abc2", "blue"));
        if(!bike2.equals(""))
            System.out.println("Parked vehicle. Ticket ID: "+bike2);

        DisplayStrategy.display(DisplayTypeEnum.FREE_COUNT, VehicleTypeEnum.BIKE);
        DisplayStrategy.display(DisplayTypeEnum.FREE_SLOT, VehicleTypeEnum.BIKE);
        DisplayStrategy.display(DisplayTypeEnum.OCCUPIED_SLOT, VehicleTypeEnum.BIKE);

        String bike3 = parkingService.parkVehicle(new Vehicle("6", VehicleTypeEnum.BIKE, "bike-abc3", "green"));
        if(!bike3.equals(""))
            System.out.println("Parked vehicle. Ticket ID: "+bike3);

        System.out.println("-------------------");
        DisplayStrategy.display(DisplayTypeEnum.FREE_COUNT, VehicleTypeEnum.BIKE);
        DisplayStrategy.display(DisplayTypeEnum.FREE_SLOT, VehicleTypeEnum.BIKE);
        DisplayStrategy.display(DisplayTypeEnum.OCCUPIED_SLOT, VehicleTypeEnum.BIKE);
        System.out.println("-------------------");
        parkingService.unParkVehicle(bike2);
        System.out.println("-------after bike remove------------");
        DisplayStrategy.display(DisplayTypeEnum.FREE_COUNT, VehicleTypeEnum.BIKE);
        DisplayStrategy.display(DisplayTypeEnum.FREE_SLOT, VehicleTypeEnum.BIKE);
        DisplayStrategy.display(DisplayTypeEnum.OCCUPIED_SLOT, VehicleTypeEnum.BIKE);
        System.out.println("-------------------");

        String bike4 = parkingService.parkVehicle(new Vehicle("7", VehicleTypeEnum.BIKE, "bike-abc4", "silver"));
        if(!bike4.equals(""))
            System.out.println("Parked vehicle. Ticket ID: "+bike4);
        System.out.println("-------------------");
        DisplayStrategy.display(DisplayTypeEnum.FREE_COUNT, VehicleTypeEnum.BIKE);
        DisplayStrategy.display(DisplayTypeEnum.FREE_SLOT, VehicleTypeEnum.BIKE);
        DisplayStrategy.display(DisplayTypeEnum.OCCUPIED_SLOT, VehicleTypeEnum.BIKE);
        System.out.println("-------------------");

        String car1 = parkingService.parkVehicle(new Vehicle("8", VehicleTypeEnum.CAR, "car-abc1", "black"));
        if(!car1.equals(""))
            System.out.println("Parked vehicle. Ticket ID: "+car1);
        DisplayStrategy.display(DisplayTypeEnum.FREE_COUNT, VehicleTypeEnum.CAR);
        DisplayStrategy.display(DisplayTypeEnum.FREE_SLOT, VehicleTypeEnum.CAR);
        DisplayStrategy.display(DisplayTypeEnum.OCCUPIED_SLOT, VehicleTypeEnum.CAR);
    }

}
