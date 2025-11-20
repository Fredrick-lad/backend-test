package com.test.test.controller;

import com.test.test.entity.*;
import com.test.test.service.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class controller {

    public service Service;

    @PostMapping("/register")
    public String registerUser(@RequestBody user newUser){
        Service.registerUser(newUser.getUsername(), newUser.getEmail(), newUser.getPassword());
        return "Success";
    }
    
}
