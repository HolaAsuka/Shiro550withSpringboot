package com.example.shirospring.controller;

import com.example.shirospring.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/login")
    public String login(String username,String password){
        try {
            userService.checkLogin(username,password);
            return "login successfully!";
        } catch (Exception e) {
            return "error";
        }
    }
}
