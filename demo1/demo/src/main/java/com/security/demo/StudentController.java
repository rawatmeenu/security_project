package com.security.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
public class StudentController {


    List<Student> list = new ArrayList<>(List.of(
            new Student(1,"okjh", "java"),
            new Student(3,"niua", " C++")
    ));

    @GetMapping("/students")
    public List<Student> getstudents(){
        return list;

    }

    @PostMapping("/students")
    public void addstudent(@RequestBody Student student){
        list.add(student);

    }

    @GetMapping("/csrftoken")
    public CsrfToken getcsrftoken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");


    }

}
