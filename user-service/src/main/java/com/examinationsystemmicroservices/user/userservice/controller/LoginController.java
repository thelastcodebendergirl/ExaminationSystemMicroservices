package com.examinationsystemmicroservices.user.userservice.controller;

import com.examinationsystemmicroservices.user.userservice.model.User;
import com.examinationsystemmicroservices.user.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findDepartmentById(@PathVariable("id") Long userId) {
        return userService.findUserById(userId);
    }
}
