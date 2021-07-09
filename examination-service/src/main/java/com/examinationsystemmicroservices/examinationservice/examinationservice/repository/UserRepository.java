package com.examinationsystemmicroservices.examinationservice.examinationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examinationsystemmicroservices.examinationservice.examinationservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findAll(String username);
}
