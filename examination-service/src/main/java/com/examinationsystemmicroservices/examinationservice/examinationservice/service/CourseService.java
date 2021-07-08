package com.examinationsystemmicroservices.examinationservice.examinationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Course;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.User;
import com.examinationsystemmicroservices.examinationservice.examinationservice.repository.CourseRepository;

@Service("courseService")
public class CourseService {
	@Autowired
	CourseRepository courseRepository ;
	
	public List<Course> getAllCourses()
	{
		return courseRepository.findAll();
	}
	public Course getCourse(long courseId)
	{
		return courseRepository.getById(courseId);
	}
	public void updateCourse(Course course)
	{
		
	}
	public void addStudent(Course course , List<User> students)
	{
		course.addStudent(students);
		courseRepository.save(course);
	}

}
