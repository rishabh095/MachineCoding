package com.parkinglot.model.ticket;

import com.parkinglot.model.vehicle.Vehicle;

public class Ticket {
    private String ticketId;
    private Vehicle vehicel;

    public Ticket(Vehicle vehicel) {
        this.vehicel = vehicel;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicel() {
        return vehicel;
    }

    public void setVehicel(Vehicle vehicel) {
        this.vehicel = vehicel;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicel=" + vehicel +
                '}';
    }
}
