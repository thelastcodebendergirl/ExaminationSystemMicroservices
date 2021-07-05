package com.examinationsystemmicroservices.examinationservice.examinationservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




@Entity
public class Course {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name ;
	
	@ManyToOne(fetch = FetchType.LAZY,
            optional = false)
	@JoinColumn(name="user_id",nullable=false)	
	private User teacher ;
	
	public Course( String name, User teacher) {
		this.name = name;
		this.teacher = teacher;
	}
	

}
