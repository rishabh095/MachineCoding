package com.ridesharing;

import com.ridesharing.exception.DuplicateUserIdException;
import com.ridesharing.exception.DuplicateVehicleIdException;
import com.ridesharing.model.ride.OfferRide;
import com.ridesharing.model.ride.PreferredVehicleEnum;
import com.ridesharing.model.ride.SelectRide;
import com.ridesharing.model.user.User;
import com.ridesharing.model.vehicle.Vehicle;
import com.ridesharing.service.ride.RideService;
import com.ridesharing.service.user.UserService;
import com.ridesharing.service.vehicle.VehicleService;

public class RideSharingMain {
    public static void main(String[] args) throws DuplicateUserIdException, DuplicateVehicleIdException {

        // User Service test
        UserService userService=new UserService();
        User user1 = userService.addUser(new User("1", "rishabh", 'M', 26));
        // test for DuplicateUserIdException
       //User user7 = userService.addUser(new User("1", "rishabh", 'M', 26));
        User user2 = userService.addUser(new User("2","shivam",'M',20));
        User user3 = userService.addUser(new User("3","shipra",'F',28));
        User user4 = userService.addUser(new User("4","ashish",'M',30));
        User user5 = userService.addUser(new User("5","priya",'F',24));
        User user6 = userService.addUser(new User("6","Nitin",'M',25));
        System.out.println(userService.userMap);

        // Vehicle Service test
        VehicleService vehicleService=new VehicleService();
        Vehicle vehicle1 = vehicleService.addVehicle(new Vehicle("1", user5, "Activa", "UP-01-1998"));
        // test for DuplicateVehicleIdException
        //Vehicle vehicle1 = vehicleService.addVehicle(new Vehicle("1", user5, "Activa", "UP-01-1998"));
        Vehicle vehicle2 = vehicleService.addVehicle(new Vehicle("2",user1,"Baleno","UP-01-1998"));
        Vehicle vehicle3 = vehicleService.addVehicle(new Vehicle("3",user1,"Activa","UP-01-1998"));
        Vehicle vehicle4 = vehicleService.addVehicle(new Vehicle("4",user4,"XUV","UP-01-1998"));
        Vehicle vehicle5 = vehicleService.addVehicle(new Vehicle("5",user6,"Polo","UP-01-1998"));

        System.out.println(vehicleService.vehicleMap);
        System.out.println("----------End Vehicle Service------------------");
        // Ride Service test

        RideService rideService=new RideService();
        rideService.printRideStats();

        OfferRide offerRide1 = rideService.offerRide(new OfferRide("1", user1, "Shamli", "Delhi", vehicle2, 4));
        //rideService.offerRide(new OfferRide("2",user1,"Shamli","Delhi",vehicle2,4));
        //rideService.offerRide(new OfferRide("3",user1,"Shamli","Delhi",vehicle4,4));
        OfferRide offerRide2 = rideService.offerRide(new OfferRide("4", user4, "Delhi", "Mumbai", vehicle4, 5));
        OfferRide offerRide3 = rideService.offerRide(new OfferRide("5", user6, "Mumbai", "Pune", vehicle5, 3));
        OfferRide offerRide4 = rideService.offerRide(new OfferRide("6", user1, "Shamli", "Delhi", vehicle3, 1));

        rideService.printRideStats();
        System.out.println("-----------------------------");
        rideService.selectRide(new SelectRide("1",user3,"Shamli","Delhi",2, PreferredVehicleEnum.MOST_VACANT,""));
        rideService.printRideStats();
    }
}
