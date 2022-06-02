package com.maru.socialnetwork4.service;

import com.maru.socialnetwork4.dao.UserDAO;
import com.maru.socialnetwork4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public User signIn(User user) {
        return new UserDAO().check(user);
    }

    @Override
    public User signUp(User user) {
        return new UserDAO().add(user);
    }

    @Override
    public User update(User user) {
        return new UserDAO().update(user);
    }
}
