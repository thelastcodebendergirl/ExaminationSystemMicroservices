package com.examinationsystemmicroservices.examinationservice.examinationservice.model;

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
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
@Table(name = "question" , schema = "public")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="question") @NotNull
	private String  question ;
	
	@Column(name="optionA") @NotNull
	private String optionA ;
	
	@Column(name="optionB") @NotNull
	private String optionB;
	
	@Column(name="optionC") @NotNull
	private String optionC;
	
	@Column(name="optionD") @NotNull
	private String optionD;
	
	@Column(name="answer" ,length = 1) @NotNull
	private char answer ;


}
