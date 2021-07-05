package com.examinationsystemmicroservices.user.userservice.service;

import com.examinationsystemmicroservices.user.userservice.model.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    public User createUser(User user);
    public User findUserById(Long userId);
}
