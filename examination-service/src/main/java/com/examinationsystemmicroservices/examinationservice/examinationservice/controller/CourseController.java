package com.examinationsystemmicroservices.examinationservice.examinationservice.controller;

import java.util.*;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Course;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.CourseModel.CourseAddStudentModel;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.CourseModel.CourseCreateModel;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.CourseModel.CourseUpdateModel;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.User;
import com.examinationsystemmicroservices.examinationservice.examinationservice.service.CourseService;
import com.examinationsystemmicroservices.examinationservice.examinationservice.service.UserService;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	CourseService courseService ;
	@Autowired
	UserService userService ;


	
	@RequestMapping(path ="/getCourses/{username}" , method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Course>>  getCourses(@PathVariable(value="username") String username)
	{
		try {
			 List<Course> courses = new ArrayList<Course>();
			 User user = userService.getUserByUserName(username);
			 courses= courseService.getCoursesByUser(user);
			 
			 if(courses.isEmpty()) 
				 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			 return new ResponseEntity<>(courses,HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    @RequestMapping(value = "/createCourse", method = RequestMethod.POST)
	public ResponseEntity<Course>  createCourses(@RequestBody CourseCreateModel model, HttpServletRequest request)
	{
		try {

			if(request.getMethod().toLowerCase(Locale.ROOT).equals("options")){
				return null;
			}
			 User teacher = userService.getUserByUserName(model.teacherusername);
			 
			 if(teacher == null )
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			 
			 Course course = new Course (model.coursename ,teacher);
			 courseService.createCourse(course);
			 
		     return new ResponseEntity<Course>(course,HttpStatus.OK) ;
			 
		}catch (Exception e) {
	    	return new ResponseEntity<>(null,HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}
    @RequestMapping(value = "/updateCourse", method = RequestMethod.POST)
	public ResponseEntity<Course>  updateCourse(@RequestBody CourseUpdateModel model)
	{
		try { 
			Course course = courseService.getCourse(model.courseId);
			if(course == null )
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			courseService.createCourse(course);
	    	return new ResponseEntity<Course>(course,HttpStatus.OK);
		}catch (Exception e) {
	    	return new ResponseEntity<>(null,HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}
    
    @RequestMapping(value = "/getStudents/{courseId}", method = RequestMethod.GET)
	public ResponseEntity<List<User>>  getStudents(@PathVariable(value="courseId") long  courseId)
	{
    	List<User> students = new ArrayList<User>();
		try { 
			Course course = courseService.getCourse(courseId);
			
			if(course == null )
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			students= course.getCourseStudents();
			
		}catch (Exception e) {
	    	return new ResponseEntity<>(null,HttpStatus.UNPROCESSABLE_ENTITY);
		}
    	return new ResponseEntity<List<User>>(students,HttpStatus.OK);
	}
    @RequestMapping(value = "/getStudentsExceptTakesCourse/{courseId}", method = RequestMethod.GET)
	public ResponseEntity<List<User>>  getStudentsExceptTakesCourse(@PathVariable(value="courseId") long  courseId)
	{
    	List<User> students = new ArrayList<User>(userService.getAllStudents());
		try { 
			Course course = courseService.getCourse(courseId);
			
			if(course == null )
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			students.removeAll(course.getCourseStudents());
			
		}catch (Exception e) {
	    	return new ResponseEntity<>(null,HttpStatus.UNPROCESSABLE_ENTITY);
		}
    	return new ResponseEntity<List<User>>(students,HttpStatus.OK);
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
