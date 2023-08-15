package com.yt.backend.auth;

import com.yt.backend.config.LogoutService;
import com.yt.backend.model.Question;
import com.yt.backend.model.User;
import com.yt.backend.service.QuestionService;
import com.yt.backend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service ;
    @Autowired
    private QuestionService questionService;

    private UserService userService;
@PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
){
    return ResponseEntity.ok(service.register(request));

}

    @RequestMapping("/questions")
    public List<Question> getQuestions(){

        return questionService.getQuestions();
    }



    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
){ return ResponseEntity.ok(service.authenticate(request));

}




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



