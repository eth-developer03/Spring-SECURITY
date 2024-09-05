package com.security.demo_security.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Home {

    
    @GetMapping("/")
    public String home() {
        return "home";
 
 
    }
//to get token
    @GetMapping("/csrf")
    public CsrfToken getCSRF(HttpServletRequest request) {
        return (CsrfToken)request.getAttribute("_csrf");

    }
    
}
