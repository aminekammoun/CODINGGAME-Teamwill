package com.yt.backend.controller;


import com.yt.backend.model.Test;
import com.yt.backend.service.TestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins ="http://localhost:8081")
public class TestController {
    private final TestServiceImpl testService;
    //add Patient
    @PostMapping("/test/add")
    public String addTest(@RequestBody Test test){
        testService.addTest(test);
        return "Test Added successfully..";
    }


    // getTestById
    @RequestMapping("/test/{id}")
    public Test getTestById(@PathVariable("id")long id){
        return testService.getTestById(id);
    }
    //getTests
    @RequestMapping("/tests")
    public List<Test> getTests(){
        return testService.getTests();
    }

    //updateTest
    @PutMapping("/test")
    public Test updateTest(@RequestBody Test test){
        return testService.updateTest(test);}


    //deleteTestById
    @DeleteMapping("/test/{id}")
    public String deleteTest(@PathVariable("id") long id){
        testService.deleteTest(id);
        return "Test Deleted ";
    }

}

