package com.examinationsystemmicroservices.user.userservice.repository;

import com.examinationsystemmicroservices.user.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long userId);

}
