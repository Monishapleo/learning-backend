package com.practice.springboot.controller;

import com.practice.springboot.entity.User;
import com.practice.springboot.dto.LoginRequest;
import com.practice.springboot.dto.RegisterRequest;
import com.practice.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody RegisterRequest request){
        User user = loginService.createUser(request);
        return ResponseEntity.ok(user);

    }

    @PostMapping("/login-user")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request){
        User user = loginService.loginUser(request);
        return ResponseEntity.ok(user);

    }
    public static void main(String[] args) {

        Employee e1 = new Employee();

        Employee e2 = e1;

        change(e2);

        System.out.println(e1.salary);

    }

    static void change(Employee emp) {

        emp.salary = 7000;

    }
}
