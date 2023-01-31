package com.maru.socialnetwork4.Controller;

import com.maru.socialnetwork4.Configuration.SecurityConfig;
import com.maru.socialnetwork4.Model.User;
import com.maru.socialnetwork4.Service.UserService;
import com.maru.socialnetwork4.Utils.CustomResponseEntity;
import com.maru.socialnetwork4.Utils.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user", produces = "application/json")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping(path = "signIn")
    public CustomResponseEntity<User> signIn(@RequestBody User user) {
        CustomResponseEntity<User> responseEntity = new CustomResponseEntity<>();
        User loggedUser = userService.signIn(user);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loggedUser.getUsername(),
                loggedUser.getPassword()
        );
        responseEntity.setT(loggedUser);
        responseEntity.setToken(jwtTokenProvider.generateToken(loggedUser));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return responseEntity;
    }

    @PostMapping(path = "signUp")
    public User signUp(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping(path = "update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
}
