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
    public Optional<user> finduser(String username) {
        return Repository.findByUsername(username);
    }

    public user registerUser(String username, String email, String password) {
    
    // 1. Create the Object (The Container)
    // This 'user' class matches your database table
    user newUser = new user(); 

    // 2. Fill the Object with data (Using Setters)
    newUser.setUsername(username);
    newUser.setEmail(email);
    newUser.setPassword(password);

    // 3. Pass that FILLED object to the save method
    // The repository looks at this object, generates the SQL, and runs the INSERT.
    return Repository.save(newUser); 
}
    public user loginrequest(String username, String email, String password){
        // Is the email got from the controller from the url path present in the database?
        Optional<user> founduser = Repository.findByUsername(username);
        Optional<user> foundemail = Repository.findByEmail(email);

        if(founduser.isPresent() || foundemail.isPresent()){
            // if present now we get the data in the  user object with the email
            user userfound = founduser.get();
            user emailfound = foundemail.get();
            // Now after getting the data we prepare it for verification of the email
            if(userfound.getPassword().equals(password) || emailfound.getPassword().equals(password)){
                return userfound;
                // return emailfound;
            }
        }
        return null;
    }
}
