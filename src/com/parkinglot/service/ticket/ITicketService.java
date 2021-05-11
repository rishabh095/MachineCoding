package com.parkinglot.service.ticket;

import com.parkinglot.model.vehicle.Vehicle;

public interface ITicketService {
    String createTicket(Vehicle vehicle,int floor,int floorSlot);

    void removeTicket(String ticketId);
}
