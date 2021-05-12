package com.ridesharing.model.ride;

import com.ridesharing.model.user.User;

public class Ride {
    private final String id;
    private final User user;
    private final String origin;
    private final String destination;

    public Ride(String id, User user, String origin, String destination) {
        this.id = id;
        this.user = user;
        this.origin = origin;
        this.destination = destination;
    }


    public User getUser() {
        return user;
    }

    public String getOrigin() {
        return origin;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", origin='" + origin + '\'' +
                ", destination=" + destination +
                '}';
    }

    public String getDestination() {
        return destination;
    }

}
