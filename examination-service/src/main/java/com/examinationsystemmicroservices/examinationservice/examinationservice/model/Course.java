package com.examinationsystemmicroservices.examinationservice.examinationservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;





@Entity
@AllArgsConstructor
@Table(name = "course" , schema = "public")
public class Course implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Getter(value = AccessLevel.PUBLIC) @Setter(value = AccessLevel.PUBLIC)
	@NotNull
	@Column(name ="name" )
	private String name ;
	
	
	@Getter(value = AccessLevel.PUBLIC) @Setter(value = AccessLevel.PUBLIC)
	@NotNull
	@ManyToOne
	private User  teacher ;
	

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "studentCourse", joinColumns = @JoinColumn(name = "courseId"))
	private Set<User> courseStudents= new HashSet<User>();
	
	public Course( String name , User teacher ) {
		this.name=name ;
		this.teacher=teacher;
		
	}
	public void addStudent(Set<User> students)
	{
		Set<User> deletedStudents =new HashSet<User>(courseStudents);
		deletedStudents.removeAll(students);
		courseStudents.removeAll(deletedStudents);
		students.removeAll(courseStudents);
		courseStudents.addAll(students);
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getTeacher() {
		return teacher;
	}
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	

}
