package com.flipkart.socialnetwork.model;

public class Login {
    private User user;
    private NewsFeed newsFeed;

    public Login(User user, NewsFeed newsFeed) {
        this.user = user;
        this.newsFeed = newsFeed;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Login{" +
                "user=" + user +
                ", newsFeed=" + newsFeed +
                '}';
    }

    public void setUser(User user) {
        this.user = user;
    }

    public NewsFeed getNewsFeed() {
        return newsFeed;
    }

    public void setNewsFeed(NewsFeed newsFeed) {
        this.newsFeed = newsFeed;
    }
}
