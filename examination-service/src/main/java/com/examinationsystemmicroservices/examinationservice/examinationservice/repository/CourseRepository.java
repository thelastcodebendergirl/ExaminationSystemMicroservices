package com.examinationsystemmicroservices.examinationservice.examinationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
