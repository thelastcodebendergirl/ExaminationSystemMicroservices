package com.examinationsystemmicroservices.examinationservice.examinationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/course")
public class CourseController {
	@GetMapping("/create")
	public String create()
	{
		return "hello";
	}

}
