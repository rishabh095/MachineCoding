package com.ridesharing.service.ride;

import com.ridesharing.model.ride.OfferRide;
import com.ridesharing.model.ride.SelectRide;

public interface IRideService {
    OfferRide offerRide(OfferRide offerRide);
    void selectRide(SelectRide selectRide);
    void endRide(OfferRide offerRide);
    void printRideStats();
}
