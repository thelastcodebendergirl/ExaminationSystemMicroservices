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

    /*@Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findDepartmentById(@PathVariable("id") Long userId) {
        return userService.findUserById(userId);
    }*/

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        userService.loadUserByUsername(user.getUsername());
        return "redirect:api/user/login";
    }

}
