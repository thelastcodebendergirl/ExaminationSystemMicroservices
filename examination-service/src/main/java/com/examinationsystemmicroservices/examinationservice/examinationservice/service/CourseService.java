package com.examinationsystemmicroservices.examinationservice.examinationservice.service;

import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Course;
import com.examinationsystemmicroservices.examinationservice.examinationservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCoursesList() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }
}
