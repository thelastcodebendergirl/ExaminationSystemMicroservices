package com.examinationsystemmicroservices.examinationservice.examinationservice.controller;

import com.examinationsystemmicroservices.examinationservice.examinationservice.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/exam")
public class ExamController {

    @Autowired
    private ExaminationService examinationService;

    @GetMapping(path ="/create" )
    public ResponseEntity<String> create()
    {
        return ResponseEntity.ok("hello");
    }
/*
    @GetMapping(value = "/getAllCourses")
    public ResponseEntity<List<Course>> getAllCourses (){
        List<Course> courseList = courseService.getCoursesList();
        return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
    }

    @PostMapping(value = "/addExam")
    public ResponseEntity addCourse(@RequestBody Course course) {
        return new ResponseEntity(course, HttpStatus.OK);
    }*/

}
