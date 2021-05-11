package com.trello.service.userservice;

import com.trello.model.user.User;

public interface IUserService {
    String createUser(User user);
    void showUser(String UserId);
    void showAllUsers();
    void deleteUser();
    void updateUser();
}
