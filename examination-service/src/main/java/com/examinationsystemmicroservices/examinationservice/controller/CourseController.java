package com.examinationsystemmicroservices.examinationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	@GetMapping("/hello")
	public String hello()
	{
		return "hello";
	}

}
