package com.examinationsystemmicroservices.examinationservice.examinationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.User;
import com.examinationsystemmicroservices.examinationservice.examinationservice.repository.UserRepository;


@Service("userService")
public class UserService {
	@Autowired
	UserRepository userRepository ;
	
	public List<User> getAllStudents()
	{
		return userRepository.findAll();
	}
	public User getStudent(long studentId)
	{
		return userRepository.getById(studentId);
	}



}
