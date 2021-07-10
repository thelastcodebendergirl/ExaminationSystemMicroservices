package com.examinationsystemmicroservices.examinationservice.examinationservice.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Exam;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.ExamModel.ExamCreateModel;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.ExamModel.CourseSearchModel;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.ExamModel.QuestionDataModel;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Question;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.ExamModel.*;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Course;
import com.examinationsystemmicroservices.examinationservice.examinationservice.service.CourseService;
import com.examinationsystemmicroservices.examinationservice.examinationservice.service.ExamService;
import com.examinationsystemmicroservices.examinationservice.examinationservice.service.UserService;

import lombok.Builder;

@RestController
@RequestMapping("/api/exam/")
public class ExamController {

	@Autowired
	CourseService courseService ;
	@Autowired
	UserService userService ;
	@Autowired
	ExamService examService ;

	@GetMapping(path ="getAllExams/{courseid}" )
	@ResponseBody
	public ResponseEntity<List<Exam>>  getAllExams(@PathVariable(value="courseid") long courseid )
	{
		try
		{
			List<Exam> exams = new ArrayList<Exam>();
			Course course= courseService.getCourse(courseid);
			
			if(course==null)
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			for (Exam exam : examService.getAllExams()) {
				if(exam.getCourse().equals(course))
					exams.add(exam);
			}
			
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
	public ResponseEntity<Exam>  createExam(@RequestBody ExamCreateModel model )
	{
		Exam exam = new Exam();
		try
		{
			List<Question> questions = new ArrayList<Question>();
			for (QuestionDataModel question : model.questions) {
				Question q = new Question(question.question,question.optionA,question.optionB,question.optionC,question.optionD,question.answer);
				questions.add(q);
			}
			
			Course course = courseService.getCourse(model.courseId);
			if(course==null)
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			exam = new Exam(model.examName, course, questions);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>(exam,HttpStatus.OK);
	}

	public ResponseEntity<String>  deleteExam()
	{
		return ResponseEntity.ok("hello");
	}

	@GetMapping(path ="getExam/{examid}" )
	@ResponseBody
	public ResponseEntity<Exam>  getExam(@PathVariable(value="courseid") long examid)
	{
		try
		{
			Exam exam = examService.getExam(examid);
			
			if(exam==null)
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(exam,HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
}
