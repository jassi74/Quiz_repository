package com.jaskirat_singh.quiz.model;

import java.util.HashMap;
import java.util.Map;


import jakarta.persistence.ElementCollection;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


public class quizSession {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ElementCollection
    private Map<Long, Boolean> answers = new HashMap<>(); 

    
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Map<Long, Boolean> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Long, Boolean> answers) {
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }
}

