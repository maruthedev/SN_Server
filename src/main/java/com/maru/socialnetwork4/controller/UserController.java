package com.maru.socialnetwork4.controller;

import com.maru.socialnetwork4.model.User;
import com.maru.socialnetwork4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user", produces = "application/json")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "signIn")
    public User signIn(@RequestBody User user) {
        System.out.println(user);
        return userService.signIn(user);
    }

    @PostMapping(path = "signUp")
    public User signUp(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping(path = "update")
    public User update(@RequestBody User user){
        System.out.println(user);
        return userService.update(user);
    }
}
