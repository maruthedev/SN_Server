package com.maru.socialnetwork4.service;

import com.maru.socialnetwork4.dao.UserDAO;
import com.maru.socialnetwork4.model.User;

public class UserServiceImpl implements UserService {
    @Override
    public User signIn(User user) {
        return new UserDAO().check(user);
    }

    @Override
    public User signUp(User user) {
        return new UserDAO().add(user);
    }
}
