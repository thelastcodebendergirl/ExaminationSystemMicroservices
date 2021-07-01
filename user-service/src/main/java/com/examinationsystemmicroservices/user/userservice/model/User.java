package com.examinationsystemmicroservices.user.userservice.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    private long userId;

    private String name;
    private String lastName;
    private long userNo;
    private String password;
    private String userType;
}
