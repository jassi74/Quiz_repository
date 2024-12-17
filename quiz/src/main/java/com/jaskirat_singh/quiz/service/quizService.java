package com.jaskirat_singh.quiz.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.jaskirat_singh.quiz.model.*;
import com.jaskirat_singh.quiz.model.User;
import com.jaskirat_singh.quiz.model.quizSession;
import com.jaskirat_singh.quiz.repository.questionRepository;
import com.jaskirat_singh.quiz.repository.userRepository;
import com.jaskirat_singh.quiz.repository.quizSessionRepository;

public class quizService {

    @Autowired
    private questionRepository questionRepository;

    @Autowired
    private userRepository userRepository;

    @Autowired
    private quizSessionRepository quizSessionRepository;

    public quizSession startNewSession(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        quizSession session = new quizSession();
        session.setUser(user);
        return quizSessionRepository.save(session);
    }

    public question getRandomQuestion() {
        List<question> questions = questionRepository.findAll();
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }

    public boolean submitAnswer(Long sessionId, Long questionId, String answer) {
        quizSession session = quizSessionRepository.findById(sessionId).orElseThrow();
        question question = questionRepository.findById(questionId).orElseThrow();
        boolean isCorrect = question.getCorrectAnswer().equalsIgnoreCase(answer);
        session.getAnswers().put(questionId, isCorrect);
        quizSessionRepository.save(session);
        return isCorrect;
    }

    public quizSession getSummary(Long sessionId) {
        return quizSessionRepository.findById(sessionId).orElseThrow();
    }
}
