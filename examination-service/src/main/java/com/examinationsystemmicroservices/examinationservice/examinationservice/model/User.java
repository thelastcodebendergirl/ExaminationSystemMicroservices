package com.examinationsystemmicroservices.examinationservice.examinationservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user" , schema = "public")
public class User {

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "auto_gen", sequenceName = "A")
    private long userId;
    
    @Column(name="name")
    private String name;

	@Column(name="lastName")
    private String lastName;
	
 	@Column(name="username")
    private String username;
 	
	@Column(name="password")
    private String password;
	
	@Column(name="userType")
    private String userType;
    

 	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


    public User(String username, String password ,String name ,String lastname ,String type) {
        this.username=username;
        this.password=password;
        this.name=name;
        this.lastName=lastname;
        userType=type;
    }
}