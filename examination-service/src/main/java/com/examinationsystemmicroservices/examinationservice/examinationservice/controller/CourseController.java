package com.examinationsystemmicroservices.examinationservice.examinationservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Course;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.CourseModel.CourseAddStudentModel;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.CourseModel.CourseCreateModel;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.User;
import com.examinationsystemmicroservices.examinationservice.examinationservice.service.CourseService;
import com.examinationsystemmicroservices.examinationservice.examinationservice.service.UserService;
@RestController
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	CourseService courseService ;
	@Autowired
	UserService userService ;
	
	@GetMapping(path ="/getCourses" )
	public ResponseEntity<List<Course>>  getCourses(@RequestParam(required=true) long teacherId)
	{
		try {
			 List<Course> courses = new ArrayList<Course>();
			 //service.findAll();
			 
			 if(courses.isEmpty()) 
				 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			 return new ResponseEntity<>(courses,HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    @RequestMapping(value = "/createCourse", method = RequestMethod.POST)
	public ResponseEntity<String>  createCourses(@RequestBody CourseCreateModel model)
	{
		try {
			
			// Course course = new Course ();
		
		}catch (Exception e) {
			// TODO: handle exception
		}
    	return ResponseEntity.ok("hello");
	}
	public ResponseEntity<String>  updateCourse()
	{
		return ResponseEntity.ok("hello");
	}
	public ResponseEntity<String>  getStudeents()
	{
		return ResponseEntity.ok("hello");
	}
	

    @RequestMapping(value = "/addStudents", method = RequestMethod.POST)
	public ResponseEntity<String>  addStudents(@RequestBody CourseAddStudentModel model )
	{
		try {
			Course course = courseService.getCourse(model.courseId);
			List<User> students= new ArrayList<User>();
			for (long user : model.studentIds) {
				User student = userService.getStudent(user);
				students.add(student);
				
			}
	    	courseService.addStudent(course, students);
		}catch (Exception e) {
	    	return new ResponseEntity<String>("Error occupied",HttpStatus.UNPROCESSABLE_ENTITY);
		}

    	return new ResponseEntity<String>("Successfull",HttpStatus.OK);
	}

}
