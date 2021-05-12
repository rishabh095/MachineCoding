package com.ridesharing.model.ride;

import com.ridesharing.model.user.User;

public class SelectRide extends Ride {
    private final int seats;
    private final PreferredVehicleEnum preferedVehicle;
    private final String preferedVehicleName;

    public SelectRide(String id, User user, String origin, String destination, int seats, PreferredVehicleEnum preferedVehicle, String preferedVehicleName) {
        super(id, user, origin, destination);
        this.seats = seats;

        this.preferedVehicle = preferedVehicle;
        this.preferedVehicleName = preferedVehicleName;
    }


    public int getSeats() {
        return seats;
    }

    public PreferredVehicleEnum getPreferedVehicle() {
        return preferedVehicle;
    }

    public String getPreferedVehicleName() {
        return preferedVehicleName;
    }

    @Override
    public String toString() {
        return "SelectRide{" +
                "seats=" + seats +
                ", preferedVehicle=" + preferedVehicle +
                ", preferedVehicleName='" + preferedVehicleName + '\'' +
                "} " + super.toString();
    }
}
