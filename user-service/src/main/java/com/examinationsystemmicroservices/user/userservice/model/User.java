package com.examinationsystemmicroservices.user.userservice.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user" , schema = "public")
public class User {

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "auto_gen", sequenceName = "A")
    private long userId;

    private String name;
    private String lastName;
    private String username;
    private String password;
    private String userType;

    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
