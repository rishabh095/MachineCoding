package com.trello.service.userservice;

import com.trello.model.user.User;
import com.trello.service.Utils.TrelloUtility;

import java.util.HashMap;
import java.util.Map;

public class UserService implements IUserService {
    public static Map<String, User> userMap = new HashMap<>();


    @Override
    public String createUser(User user) {
        String randomId = TrelloUtility.getRandomId(Integer.parseInt(user.getUserId()));
        user.setUserId(randomId);
        userMap.put(user.getUserId(), user);
        return user.getUserId();
    }

    @Override
    public void showUser(String userId) {
        if (userMap.containsKey(userId))
            System.out.println(userMap.get(userId));
        else
            System.out.println("User " + userId + " does not Exist");
    }

    @Override
    public void showAllUsers() {
        if (userMap.size() > 0) {
            for (Map.Entry<String, User> entry : userMap.entrySet())
                System.out.println(entry.getValue());
        } else
            System.out.println("No User Exist");
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void updateUser() {

    }
}
