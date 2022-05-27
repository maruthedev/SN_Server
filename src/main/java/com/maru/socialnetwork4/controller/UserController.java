package com.maru.socialnetwork4.controller;

import com.maru.socialnetwork4.model.User;
import com.maru.socialnetwork4.service.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    UserServiceImpl userServiceImpl = new UserServiceImpl();

    @PostMapping(path = "/signIn")
    public User signIn(@RequestBody User user) {
        return userServiceImpl.signIn(user);
    }

    @PostMapping(path = "/signUp")
    public User signUp(@RequestBody User user) {
        return userServiceImpl.signUp(user);
    }
}
