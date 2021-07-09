package com.examinationsystemmicroservices.examinationservice.examinationservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "exam" , schema = "public")
public class Exam implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Getter @Setter
	@NotNull
	@Column(name ="name" )
	private String examName ;
	
	
	@Getter @Setter
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY,
            optional = false)
	@JoinColumn(name="courseId",nullable=false)	
	private Course course ;
	

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "examQuestion", joinColumns = @JoinColumn(name = "examId"))
	private List<Question> examQestions= new ArrayList<Question>();
	
	public Exam( String name ,Course course ,List<Question> questions) {
		this.examName=name;
		this.course=course;
		examQestions=questions;
		
	}
	

}
