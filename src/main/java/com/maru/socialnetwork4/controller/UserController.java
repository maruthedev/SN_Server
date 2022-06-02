package com.maru.socialnetwork4.controller;

import com.maru.socialnetwork4.model.User;
import com.maru.socialnetwork4.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user", produces = "application/json")
public class UserController {
    UserServiceImpl userServiceImpl = new UserServiceImpl();

    @PostMapping(path = "signIn")
    public User signIn(@RequestBody User user) {
        return userServiceImpl.signIn(user);
    }

    @PostMapping(path = "signUp")
    public User signUp(@RequestBody User user) {
        return userServiceImpl.signUp(user);
    }

    @PostMapping(path = "update")
    public User update(@RequestBody User user){
        return userServiceImpl.update(user);
    }
}
