package com.parkinglot.model.ticket;

import com.parkinglot.model.vehicle.Vehicle;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;

    public Ticket(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
