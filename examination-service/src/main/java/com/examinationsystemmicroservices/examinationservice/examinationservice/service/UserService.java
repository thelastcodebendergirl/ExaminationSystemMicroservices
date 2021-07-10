package com.examinationsystemmicroservices.examinationservice.examinationservice.service;

import java.util.ArrayList;
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
		List<User> students = new ArrayList<User>();
		for (User user : userRepository.findAll()) {
			if(user.getUserType().equalsIgnoreCase("s"))
				students.add(user);
		}
		return students;
	}
	public User getStudent(long studentId)
	{
		return userRepository.getById(studentId);
	}
	public User getTeacherById(long teacherId)
	{
		return userRepository.getById(teacherId);
	}
	public User getUserByUserName(String username)
	{
		List <User> allUser = userRepository.findAll();
		
		for (User user : allUser) {
			if(user.getUsername().equals(username))
				return user ;
		}
		
		return  null ;
	}
		public User createUser(User user)
	{
		return userRepository.save(user);
	}


}
