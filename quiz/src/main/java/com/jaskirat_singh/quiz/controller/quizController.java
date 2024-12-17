package com.jaskirat_singh.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaskirat_singh.quiz.model.question;
import com.jaskirat_singh.quiz.model.quizSession;
import com.jaskirat_singh.quiz.service.quizService;

public class quizController {

    @Autowired
    private quizService quizService;

    @PostMapping("/start/{userId}")
    public quizSession startNewQuiz(@PathVariable Long userId) {
        return quizService.startNewSession(userId);
    }

    @GetMapping("/question")
    public question getRandomQuestion() {
        return quizService.getRandomQuestion();
    }

    @PostMapping("/submit/{sessionId}/{questionId}")
    public String submitAnswer(@PathVariable Long sessionId,
                               @PathVariable Long questionId,
                               @RequestParam String answer) {
        boolean isCorrect = quizService.submitAnswer(sessionId, questionId, answer);
        return isCorrect ? "Correct Answer!" : "Incorrect Answer.";
    }

    @GetMapping("/summary/{sessionId}")
    public quizSession getSummary(@PathVariable Long sessionId) {
        return quizService.getSummary(sessionId);
    }

}
