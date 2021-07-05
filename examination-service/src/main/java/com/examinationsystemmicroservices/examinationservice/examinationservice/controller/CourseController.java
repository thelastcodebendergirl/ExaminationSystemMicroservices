package com.examinationsystemmicroservices.examinationservice.examinationservice.controller;

import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Course;
import com.examinationsystemmicroservices.examinationservice.examinationservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/create")
	public String create()
	{
		return "hello";
	}

	@GetMapping("/getAllCourses")
	public ResponseEntity<List<Course>> getAllCourses (){
		List<Course> courseList = courseService.getCoursesList();
		return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
	}

}
