package com.maru.socialnetwork4.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/admin", produces = "application/json")
@CrossOrigin
public class AdministratorController {

    @GetMapping(path = "/greeting")
    public String greetingMessage(){
        return "Administrator Page";
    }
}
