package com.test.test.controller;

import com.test.test.entity.*;
import com.test.test.service.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class controller {

    private final service Service;
    public controller(service myService) {
    this.Service = myService;
    }
    @PostMapping("/register")
    public String registerUser(@RequestBody user newUser){
        // CONSTRUCTOR INJECTION (The missing link!)
        Service.registerUser(newUser.getUsername(), newUser.getEmail(), newUser.getPassword());
        return "Success";
    }

    @PostMapping("/login")
    public Object getUsercredentials(@RequestBody user loggingin){

        user verification = Service.loginrequest(loggingin.getUsername(),loggingin.getEmail(),loggingin.getPassword());
        if(verification != null){
            return verification;
        } else {
            return "Invalid credentials";
        }

    }
    
}
