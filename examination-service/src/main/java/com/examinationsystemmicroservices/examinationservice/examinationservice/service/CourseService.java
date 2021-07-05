package com.examinationsystemmicroservices.examinationservice.examinationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Course;
import com.examinationsystemmicroservices.examinationservice.examinationservice.repository.CourseRepository;

@Service("courseService")
public class CourseService {
	@Autowired
	CourseRepository courseRepository ;
	
	public List<Course> getAllCourses()
	{
		return null;
	}
	public Course getCourse(int id)
	{
		return null;
	}
	public void updateCourse(Course course)
	{
		
	}

}
