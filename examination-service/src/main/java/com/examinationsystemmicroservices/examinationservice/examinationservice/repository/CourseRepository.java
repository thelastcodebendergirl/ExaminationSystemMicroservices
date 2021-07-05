package com.examinationsystemmicroservices.examinationservice.examinationservice.repository;

import com.examinationsystemmicroservices.examinationservice.examinationservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CourseRepository extends JpaRepository<Course, Long> {
}
