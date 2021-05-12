package com.ridesharing.service.ride;

import com.ridesharing.model.ride.OfferRide;
import com.ridesharing.model.ride.RideStatusEnum;
import com.ridesharing.model.ride.SelectRide;
import com.ridesharing.model.user.User;
import com.ridesharing.model.vehicle.Vehicle;
import com.ridesharing.model.vehicle.VehicleRideStatusEnum;
import com.ridesharing.service.user.UserService;
import com.ridesharing.service.vehicle.VehicleService;

import java.util.HashMap;
import java.util.Map;

public class RideService implements IRideService {
    public static Map<String, OfferRide> rideMap = new HashMap<>();
    public static Map<String, Vehicle> vehicleMap = VehicleService.vehicleMap;
    public static Map<String, User> userMap = UserService.userMap;

    @Override
    public OfferRide offerRide(OfferRide offerRide) {
        Vehicle vehicle = vehicleMap.get(offerRide.getVehicle().getId());

        if (!vehicle.getUser().getId().equals(offerRide.getUser().getId())) {
            System.out.println("Vehicle " + vehicle.getId() + " does not belongs to user " + offerRide.getUser().getId());
            return null;
        }
        if (vehicle.getRideStatus().equals(VehicleRideStatusEnum.RIDE_OFFERED)) {
            System.out.println("Ride has already been offered for vehicle " + vehicle.getId());
            return null;
        }
        vehicle.setRideStatus(VehicleRideStatusEnum.RIDE_OFFERED);
        offerRide.setRideStatus(RideStatusEnum.OFFERED);
        rideMap.put(offerRide.getId(), offerRide);
        User user = userMap.get(offerRide.getUser().getId());
        user.setRideOffered(user.getRideOffered() + 1);
        System.out.println("Ride has been offered");
        return offerRide;

    }

    @Override
    public void selectRide(SelectRide selectRide) {
        if (selectRide.getSeats() < 1 || selectRide.getSeats() > 2) {
            System.out.println("Invalid seats selected for Select a Ride.");
            return;
        }
        SelectRideStrategyContext rideStrategyContext = new SelectRideStrategyContext();
        SelectRideStrategy rideSelectionStrategy = rideStrategyContext.getRideSelectionStrategy(selectRide.getPreferedVehicle());
        System.out.println(rideSelectionStrategy.getClass().getName());
        if (rideSelectionStrategy != null)
            rideSelectionStrategy.selectRide(selectRide);
    }

    @Override
    public void endRide(OfferRide offerRide) {
        if (rideMap.containsKey(offerRide.getId())) {
            vehicleMap.get(offerRide.getVehicle().getId()).setRideStatus(VehicleRideStatusEnum.RIDE_END);
            rideMap.get(offerRide.getId()).setRideStatus(RideStatusEnum.COMPLETED);
            System.out.println("Ride Completed.");
        }
    }

    @Override
    public void printRideStats() {
        if (!userMap.isEmpty()) {
            for (Map.Entry<String, User> user : userMap.entrySet()) {
                printRideStats(user.getValue().getName(), user.getValue().getRideTaken(), user.getValue().getRideOffered());
            }
        } else
            System.out.println("No Data Available");
    }

    private void printRideStats(String name, int rideTaken, int rideOffered) {
        System.out.println(name + " : " + rideTaken + " Taken, Offered " + rideOffered);
    }
}
