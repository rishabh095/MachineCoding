package com.ridesharing.model.ride;

import com.ridesharing.model.user.User;
import com.ridesharing.model.vehicle.Vehicle;

public class OfferRide extends Ride {
    private final Vehicle vehicle;
    private int availableSeats;
    private RideStatusEnum rideStatus;

    public OfferRide(String id, User user, String origin, String destination, Vehicle vehicle, int availableSeats) {
        super(id, user, origin, destination);
        this.vehicle = vehicle;
        this.availableSeats = availableSeats;
        this.rideStatus = RideStatusEnum.OFFERED;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public RideStatusEnum getRideStatus() {
        return rideStatus;
    }

    @Override
    public String toString() {
        return "OfferRide{" +
                "vehicle=" + vehicle +
                ", availableSeats=" + availableSeats +
                ", rideStatus=" + rideStatus +
                "} " + super.toString();
    }

    public void setRideStatus(RideStatusEnum rideStatus) {
        this.rideStatus = rideStatus;
    }

}
