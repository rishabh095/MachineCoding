package com.flipkart.socialnetwork.service.login;

import com.flipkart.socialnetwork.model.User;

public interface ILoginService {
    void login(User user);

    void showUsersFeed(User user);
}
