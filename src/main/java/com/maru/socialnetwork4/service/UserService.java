package com.maru.socialnetwork4.service;

import com.maru.socialnetwork4.model.User;

public interface UserService {
    public User signIn(User user);

    public User signUp(User user);

    public User update(User user);
}
