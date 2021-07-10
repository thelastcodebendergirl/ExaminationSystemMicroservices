package com.examinationsystemmicroservices.user.userservice.service;

import com.examinationsystemmicroservices.user.userservice.model.User;
import com.examinationsystemmicroservices.user.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());
    }
    public User getUserByUsername(String username)
    {
    	for (User  user  : userRepository.findAll()) {
    		if(user.getUsername().equals(username))
    			return user;
			
		}
    	return null ;
    }



}
