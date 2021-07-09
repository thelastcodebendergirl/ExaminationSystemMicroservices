package com.examinationsystemmicroservices.examinationservice.examinationservice.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Exam;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.ExamModel.ExamgGetByCourseIdModel;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.ExamModel.ExamCreateModel;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.ExamModel.CourseSearchModel;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.ExamModel.QuestionDataModel;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.ExamModel.*;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Course;
import com.examinationsystemmicroservices.examinationservice.examinationservice.service.CourseService;
import com.examinationsystemmicroservices.examinationservice.examinationservice.service.ExamService;

@RestController
@RequestMapping("/api/exam/")
public class ExamController {

	@Autowired
	CourseService courseService ;
	@Autowired
	UserService userService ;
	@Autowired
	ExamService examService ;

	@GetMapping(path ="getAllExams/{id}" )
	public ResponseEntity<List<Exam>>  getAllExams()
	{
		try
		{
			List<Exam> exams = new ArrayList<Exams>();
			exams = examService.getAllExams();

			if(exams.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<>(exams,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/createExam", method = RequestMethod.POST)
	public ResponseEntity<String>  createExam(@RequestBody ExamCreateModel model )
	{
		try
		{
			//question kısmı nasıl olcak
			Course course = courseService.getCourse(model.courseId);
			Exam exam = new Exam(model.examName, course, model.questions);
		}
		catch (Exception e)
		{
			return new ResponseEntity<String>("Error occupied",HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<String>("Successfull",HttpStatus.OK);
	}

	public ResponseEntity<String>  deleteExam()
	{
		return ResponseEntity.ok("hello");
	}

	@GetMapping(path ="getExam/{id}" )
	public ResponseEntity<List<Exam>>  getExam(@RequestParam(required=true) ExamSearchModel model)
	{
		try
		{
			Exam exam = examService.getExam(model.examId);

			return new ResponseEntity<>(exam,HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<String>("Error occupied",HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
}
