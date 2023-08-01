package com.yt.backend.service;
import com.yt.backend.model.Question;
import com.yt.backend.model.Reponse;
import com.yt.backend.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class QuestionServiceImpl implements QuestionService{
        @Autowired
        private   ReponseService reponseService;

        @Override
        public Question addQuestion(Question question) {
            return questionRepository.save(question);
        }

        @Override
        public Question getQuestionById(long idquest) {
            return questionRepository.findById(idquest).get() ;
        }

        @Override
        public List<Question> getQuestions() {
            return (List<Question>) questionRepository.findAll();
        }

        @Override
        public void deleteQuestion(long idquest) {questionRepository.deleteById(idquest);

        }
        private final QuestionRepository questionRepository;
        @Autowired
        public QuestionServiceImpl(QuestionRepository questionRepository) {
            this.questionRepository = questionRepository;
        }
        @Override
        public Question updateQuestion(Question question) {
            return questionRepository.save(question);
        }
        public Question createQuestionAndReponse(Question question, Reponse reponse) {
            question.setReponse(reponse); // Set UserProfile in User entity

            return questionRepository.save(question);
        }
        @Override
        public Question createQuestionAndReponse( Reponse reponse,Question question) {


            reponseService.addReponse(reponse);
            Question savedQuestion = questionRepository.save(question);


            return savedQuestion;
        }
    }
