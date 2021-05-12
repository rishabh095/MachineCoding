package com.ridesharing.service.ride;

import com.ridesharing.model.ride.OfferRide;
import com.ridesharing.model.ride.SelectRide;
import com.ridesharing.model.user.User;
import com.ridesharing.service.user.UserService;

import java.util.Map;

public class PreferedVehicleRide implements SelectRideStrategy {
    Map<String, OfferRide> rideMap = RideService.rideMap;
    public static Map<String, User> userMap = UserService.userMap;

    @Override
    public void selectRide(SelectRide selectRide) {
        String offeredRideId = "";
        for (Map.Entry<String, OfferRide> ride : rideMap.entrySet()) {
            OfferRide offeredRide = ride.getValue();
            if (offeredRide.getOrigin().equalsIgnoreCase(selectRide.getOrigin()) &&
                    offeredRide.getDestination().equalsIgnoreCase(selectRide.getDestination()) &&
                    offeredRide.getAvailableSeats() >= selectRide.getSeats()) {
                if (offeredRide.getVehicle().getVehicleName().equalsIgnoreCase(selectRide.getPreferedVehicleName())) {
                    offeredRideId = offeredRide.getId();
                    break;
                }
            }
        }
        if (offeredRideId.equals("")) {
            System.out.println("No rides found");
            return;
        }
        OfferRide offerRide = rideMap.get(offeredRideId);
        offerRide.setAvailableSeats(offerRide.getAvailableSeats() - selectRide.getSeats());
        User user = userMap.get(selectRide.getUser().getId());
        user.setRideTaken(user.getRideTaken() + 1);
        System.out.println(offeredRideId + " is the desired Ride and selected");
    }
}
