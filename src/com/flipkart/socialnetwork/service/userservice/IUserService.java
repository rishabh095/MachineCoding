package com.flipkart.socialnetwork.service.userservice;

import com.flipkart.socialnetwork.exception.UserNameExistException;
import com.flipkart.socialnetwork.model.User;

public interface IUserService {
    User signup(User user) throws UserNameExistException;
    void followOtherUsers(User user,User toBeFollow);
}
