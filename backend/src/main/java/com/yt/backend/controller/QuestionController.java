package com.yt.backend.controller;

import com.yt.backend.model.Question;
import com.yt.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:8081")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    //add Patient
    @PostMapping("/question/add")
    public String addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return "Question Added successfully..";
    }
    // getQuestionById
    @RequestMapping ("/question/{id}")
    public Question getQuestionById(@PathVariable("id")long id){
        return questionService.getQuestionById(id);
    }
    //getQuestions
    @RequestMapping("/questions")
    public List<Question> getQuestions(){
        return questionService.getQuestions();
    }

    //updateQuestion
    @PutMapping("/question")
    public Question updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);}


    //deleteQuestionById
    @DeleteMapping("/question/{id}")
    public String deleteQuestion(@PathVariable("id") long id){
        questionService.deleteQuestion(id);
        return "Question Deleted ";
    }

}
