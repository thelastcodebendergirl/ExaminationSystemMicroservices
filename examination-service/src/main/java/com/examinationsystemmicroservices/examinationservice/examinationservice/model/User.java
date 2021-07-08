package com.examinationsystemmicroservices.examinationservice.examinationservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
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
    
    @Getter @Setter @NotNull
    private String name;
    @Getter @Setter  @NotNull
    private String lastName;
    @Getter @Setter @NotNull
    private String username;
    @Getter @Setter @NotNull
    private String password;
    @Getter @Setter @NotNull
    private String userType;
    

    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }
}