package com.security.demo_security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.demo_security.models.Users;
import com.security.demo_security.repo.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);
    public Users regsiter(Users user){
        user.setpassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

}
