package com.security.demo_security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.demo_security.models.UserPrincipal;
import com.security.demo_security.models.Users;
import com.security.demo_security.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{


    @Autowired
    private UserRepo userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user=userRepository.findByUsername(username);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found!!!!");
        }
        return new UserPrincipal(user);
    }

    
}
