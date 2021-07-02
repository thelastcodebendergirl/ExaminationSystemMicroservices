package com.examinationsystemmicroservices.user.userservice.service;

import com.examinationsystemmicroservices.user.userservice.model.User;
import com.examinationsystemmicroservices.user.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    //todo: examination meto servise rest atılacak???

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

}
