package com.test.test.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable=false, unique = true)
    private String Username;

    @Column(name="email", nullable=false,unique = true)
    private String Email;

    @Column(name = "pass", nullable= false, unique = true)
    private String Password;

    //Default constructor
    public user(){};

    //constructor wit parameters
    public user(String Username, String Email, String Password){
        this.Username = Username;
        this.Email=Email;
        this.Password=Password;
    }
     
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return Username;
    }
    
    public void setUsername(String Username) {
        this.Username = Username;
    }
    
    public String getEmail() {
        return Email;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getPassword(){
        return Password;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }
    
}

