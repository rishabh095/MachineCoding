package com.flipkart.socialnetwork.model;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class User {
    private final String id;
    private final String userName;
    private String password;
    private final char gender;
    private Set<User> followers;

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public User(String id, String userName, String password, char gender) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        followers=new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

}

