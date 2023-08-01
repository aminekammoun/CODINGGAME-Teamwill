package com.yt.backend.controller;
import com.yt.backend.model.Question;
import com.yt.backend.model.Reponse;

import com.yt.backend.service.QuestionService;
import com.yt.backend.service.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins ="http://localhost:8081")
public class ReponseController {

    @Autowired
    private ReponseService reponseService;
    @Autowired
    private QuestionService questionService;

    @PostMapping("/reponse/add")
    public String addReponse(@RequestBody Reponse reponse){

        reponseService.addReponse(reponse);
        return "Reponse Added successfully..";



    }

    @RequestMapping ("/reponse/{id}")
    public Reponse getReponseById(@PathVariable("id")long id){
        return reponseService.getReponseById(id);
    }

    @RequestMapping("/reponses")
    public List<Reponse> getReponses(){
        return reponseService.getReponses();
    }


    @PutMapping("/reponse")
    public Reponse updateReponse(@RequestBody Reponse reponse){
        return reponseService.updateReponse(reponse);}



    @DeleteMapping("/reponse/{id}")
    public String deleteReponse(@PathVariable("id") long id){
        reponseService.deleteReponse(id);
        return "Reponse Deleted ";
    }


}
