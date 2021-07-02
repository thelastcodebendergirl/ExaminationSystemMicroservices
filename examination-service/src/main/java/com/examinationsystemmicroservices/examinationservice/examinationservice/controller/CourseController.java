package com.examinationsystemmicroservices.examinationservice.examinationservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/course")
public class CourseController {
	@GetMapping(path ="/create" )
	public ResponseEntity<String>  create()
	{
		return ResponseEntity.ok("hello");
	}

}
