package com.examinationsystemmicroservices.user.userservice.controller;

import com.examinationsystemmicroservices.user.userservice.model.User;
import com.examinationsystemmicroservices.user.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(value = "/login")
    public String login(@RequestBody User user) {
        userService.loadUserByUsername(user.getUsername());
        return "done";
    }

}
