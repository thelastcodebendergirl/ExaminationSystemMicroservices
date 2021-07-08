package com.examinationsystemmicroservices.examinationservice.examinationservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;




@Entity
@AllArgsConstructor
public class Course {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@EmbeddedId
	private CourseTeacherEntity name_teacher ;
	

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "CourseStudents", joinColumns = @JoinColumn(name = "User"))
	private List<User> courseStudents= new ArrayList<User>();
	
	public Course( CourseTeacherEntity name_teacher) {
		this.name_teacher=name_teacher;
		
	}
	public void addStudent(List<User> students)
	{
		List<User> deletedStudents =new ArrayList<User>(courseStudents);
		deletedStudents.removeAll(students);
		courseStudents.removeAll(deletedStudents);
		students.removeAll(courseStudents);
		courseStudents.addAll(students);
	
	}
	

}
