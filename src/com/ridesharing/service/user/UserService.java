package com.ridesharing.service.user;

import com.ridesharing.exception.DuplicateUserIdException;
import com.ridesharing.model.user.User;

import java.util.HashMap;
import java.util.Map;

public class UserService implements IUserService {

    public static Map<String, User> userMap=new HashMap<>();

    @Override
    public User addUser(User user) throws DuplicateUserIdException {
        if (userMap.containsKey(user.getId()))
            throw new DuplicateUserIdException("User id already exists.");
        userMap.put(user.getId(), user);
        System.out.println("User Created ");
        return user;
    }
}
