package com.security.demo_security.models;

// import jakarta.persistence.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Users {
    
    @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String username;
    private String password;

    public String getPassword(){
        return password;
    }

    public String getUsername(){
        return username;
    }
    public void setpassword(String password){
        this.password = password;
    }
    public void setUsername(String username){
        this.username = username;
    }

}
