package com.examinationsystemmicroservices.examinationservice.examinationservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Course;
@RestController
@RequestMapping("/api/course")
public class CourseController {
	
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
	@PostMapping()
	public ResponseEntity<String>  createCourses()
	{
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
	public ResponseEntity<String>  addStudents()
	{
		return ResponseEntity.ok("hello");
	}

}
