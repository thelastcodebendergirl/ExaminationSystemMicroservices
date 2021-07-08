package com.examinationsystemmicroservices.examinationservice.examinationservice.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Embeddable
public class CourseTeacherEntity {
	@Getter @Setter
	@NotNull
	@Column(name ="name" )
	private String name ;
	
	
	@Getter @Setter
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY,
            optional = false)
	@JoinColumn(name="user_id",nullable=false)	
	private User teacher ;

}
