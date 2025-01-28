package com.security.demo_security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.demo_security.models.Users;
@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{
    
Users findByUsername(String username); // automatic fetch by sql as findBy prefix it searches as SELECT * FROM users WHERE username = ?;

}
