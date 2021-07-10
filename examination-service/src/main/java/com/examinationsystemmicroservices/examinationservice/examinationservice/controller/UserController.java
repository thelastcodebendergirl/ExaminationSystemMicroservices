package com.examinationsystemmicroservices.examinationservice.examinationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Course;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.User;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.UserModel.UserDataModel;
import com.examinationsystemmicroservices.examinationservice.examinationservice.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService ;
	
	@RequestMapping(path ="/userCreated" , method = RequestMethod.POST)
	
	public void   getCourses(@RequestBody UserDataModel model)
	{
		User user = new User(model.username, model.password,model.name,model.lastname,model.userType);
		userService.createUser(user);
	}
}
