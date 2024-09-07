package com.security.demo_security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo_security.models.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Home {

    
//     @GetMapping("/")
//     public String home() {
//         return "home";
 
 
//     }
// //to get token
//     @GetMapping("/csrf")
//     public CsrfToken getCSRF(HttpServletRequest request) {
//         return (CsrfToken)request.getAttribute("_csrf");

//     }
    


    //
        private List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1, "Navin", 60),
                    new Student(2, "Kiran", 65)
            ));

        @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");


    }


    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

}

