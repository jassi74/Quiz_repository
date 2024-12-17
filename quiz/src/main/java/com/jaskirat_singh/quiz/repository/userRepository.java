package com.jaskirat_singh.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaskirat_singh.quiz.model.User;

public interface userRepository extends JpaRepository<User, Long> {

}
