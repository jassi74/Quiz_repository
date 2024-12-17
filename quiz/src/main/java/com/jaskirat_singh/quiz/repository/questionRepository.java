package com.jaskirat_singh.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaskirat_singh.quiz.model.question;

public interface questionRepository extends JpaRepository<question, Long> {

}
