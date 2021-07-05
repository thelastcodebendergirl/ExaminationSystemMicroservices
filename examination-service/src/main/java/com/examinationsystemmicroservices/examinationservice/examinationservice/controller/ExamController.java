package com.examinationsystemmicroservices.examinationservice.examinationservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exam/")
public class ExamController {

	@GetMapping(path ="getAllExams/{id}" )
	public ResponseEntity<String>  getAllExams()
	{
		return ResponseEntity.ok("hello");
	}
	@PostMapping()
	public ResponseEntity<String>  createExam()
	{
		return ResponseEntity.ok("hello");
	}
	public ResponseEntity<String>  deleteExam()
	{
		return ResponseEntity.ok("hello");
	}
	@GetMapping(path ="getExam/{id}" )
	public ResponseEntity<String>  getExam()
	{
		return ResponseEntity.ok("hello");
	}

}
