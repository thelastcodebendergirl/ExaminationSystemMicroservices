package com.examinationsystemmicroservices.examinationservice.examinationservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examinationsystemmicroservices.examinationservice.examinationservice.model.*;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.User;
import com.examinationsystemmicroservices.examinationservice.examinationservice.repository.*;

@Service("examService")
public class ExamService {

    @Autowired
    ExamRepository examRepository ;

    public List<Exam> getAllExams()
    {
        return examRepository.findAll();
    }

    public void createExam(Exam exam)
    {
        examRepository.save(exam);
    }

    public Exam getExam(long examId)
    {
        return examRepository.getById(examId);
    }
}
