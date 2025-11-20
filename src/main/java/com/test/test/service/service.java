package com.test.test.service;

import com.test.test.repository.*;
import com.test.test.entity.*;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service

public class service {
    private final  repository Repository;
    // CONSTRUCTOR INJECTION
    public service(repository myRepository) {
        this.Repository = myRepository;
    }
    public Optional<user> finduser(String Username) {
        return Repository.findByUsername(Username);
    }

    public user registerUser(String Username, String Email, String Password) {
    
    // 1. Create the Object (The Container)
    // This 'user' class matches your database table
    user newUser = new user(); 

    // 2. Fill the Object with data (Using Setters)
    newUser.setUsername(Username);
    newUser.setEmail(Email);
    newUser.setPassword(Password);

    // 3. Pass that FILLED object to the save method
    // The repository looks at this object, generates the SQL, and runs the INSERT.
    return Repository.save(newUser); 
}
}
