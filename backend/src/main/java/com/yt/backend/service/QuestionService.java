package com.yt.backend.service;

import com.yt.backend.model.Question;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    public Question addQuestion (Question question);
    public Question getQuestionById(long idquest);
    public List<Question> getQuestions();
    public void deleteQuestion(long idquest);
    public Question updateQuestion (Question question);
}
