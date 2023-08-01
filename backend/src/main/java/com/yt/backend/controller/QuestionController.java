package com.yt.backend.controller;

import com.yt.backend.model.Question;
import com.yt.backend.model.Reponse;
import com.yt.backend.service.QuestionService;
import com.yt.backend.service.QuestionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor

@CrossOrigin(origins ="http://localhost:8081")
public class QuestionController {
    private final QuestionServiceImpl questionService;



    //add Patient
    @PostMapping("/question/add")
    public String addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return "Question Added successfully..";
    }



    @PostMapping("/question/addd")
    public ResponseEntity<Question> createUserAndProfile(@RequestBody QuestionAndReponseDTO questionAndReponseDTO) {
        Question question = questionAndReponseDTO.getQuestion();
        Reponse reponse = questionAndReponseDTO.getReponse();

        // Validate the user and userProfile data if needed

        Question createdQuestion = questionService.createQuestionAndReponse(question,reponse);
        return ResponseEntity.created(URI.create("/questions/" + createdQuestion.getIdquest())).body(createdQuestion);
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
