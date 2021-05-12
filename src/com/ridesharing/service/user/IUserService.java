package com.ridesharing.service.user;

import com.ridesharing.exception.DuplicateUserIdException;
import com.ridesharing.model.user.User;

public interface IUserService {
    User addUser(User user) throws DuplicateUserIdException;
}
