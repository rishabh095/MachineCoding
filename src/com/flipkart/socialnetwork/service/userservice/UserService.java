package com.flipkart.socialnetwork.service.userservice;

import com.flipkart.socialnetwork.exception.UserNameExistException;
import com.flipkart.socialnetwork.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class UserService implements IUserService {
    public static Map<String, User> userMap = new HashMap<>();

    @Override
    public User signup(User user) throws UserNameExistException {
        if (!userMap.isEmpty()) {
            for (Map.Entry<String, User> entry : userMap.entrySet()) {
                if (entry.getValue().getUserName().equalsIgnoreCase(user.getUserName()))
                    throw new UserNameExistException("UserName already exists");
            }
        }
        userMap.put(user.getId(), user);
        System.out.println(user.getUserName() + " Sign up done.");
        return user;
    }

    @Override
    public void followOtherUsers(User user, User toBeFollow) {
        if (!userMap.containsKey(user.getId())) {
            System.out.println("user does not exist");
            return;
        }
        if (!userMap.containsKey(toBeFollow.getId())) {
            System.out.println("ToBeFollow does not exist");
            return;
        }
        Set<User> followerSet = userMap.get(user.getId()).getFollowers();

        followerSet.add(toBeFollow);
        userMap.get(user.getId()).setFollowers(followerSet);
        //System.out.println(toBeFollow.getUserName() + " user has been followed by " + user.getUserName());
    }
}
