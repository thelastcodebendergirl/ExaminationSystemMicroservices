package com.examinationsystemmicroservices.examinationservice.examinationservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	public List<Course> getCoursesByUser(User user )
	{
		List<Course> courses = new ArrayList<Course>();
		for (Course course : courseRepository.findAll()) {
			
			if(course.getTeacher().getUserId()==user.getUserId())
				courses.add(course);
		}
		
		
		return  courses;
	}
	public void updateCourse(Course course,String updatedName)
	{
		
		course.setName(updatedName);
		courseRepository.save(course);
	}
	public void createCourse(Course course)
	{
		courseRepository.save(course);
	}
	public void addStudent(Course course , List<User> students)
	{
		course.addStudent(students);
		courseRepository.save(course);
	}

}
