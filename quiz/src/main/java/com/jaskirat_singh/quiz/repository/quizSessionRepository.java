package com.jaskirat_singh.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaskirat_singh.quiz.model.quizSession;

public interface quizSessionRepository extends JpaRepository<quizSession, Long> {

}
