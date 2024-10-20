package com.security.demo_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo_security.models.Users;
import com.security.demo_security.services.UserService;


@RestController
public class UserController {

@Autowired
private UserService service;

@PostMapping("/register")
public Users register(@RequestBody Users user) {
    //TODO: process POST request
    
    return service.regsiter(user);
}

}
 