package com.ridesharing.service.ride;

import com.ridesharing.model.ride.PreferredVehicleEnum;

public class SelectRideStrategyContext {

    public SelectRideStrategy getRideSelectionStrategy(PreferredVehicleEnum preferredVehicle){
        switch (preferredVehicle){
            case MOST_VACANT:
                return new MostVacantRide();
            case PREFERRED_VEHICLE:
                return new PreferedVehicleRide();
            default:
                return null;
        }
    }
}

