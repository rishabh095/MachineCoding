package com.ridesharing.model.user;

public class User {
    private final String id;
    private final String name;
    private final char gender;
    private final int age;
    private int rideOffered;
    private int rideTaken;

    public User(String id, String name, char gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public int getRideOffered() {
        return rideOffered;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", rideOffered=" + rideOffered +
                ", rideTaken=" + rideTaken +
                '}';
    }

    public void setRideOffered(int rideOffered) {
        this.rideOffered = rideOffered;
    }

    public int getRideTaken() {
        return rideTaken;
    }

    public void setRideTaken(int rideTaken) {
        this.rideTaken = rideTaken;
    }

}
