package com.examinationsystemmicroservices.examinationservice.examinationservice.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Table(name = "examCourseEntity" , schema = "public")
public class ExamCourseEntity {


}
