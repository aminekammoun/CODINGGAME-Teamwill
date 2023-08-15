package com.yt.backend.service;
import com.yt.backend.model.Question;
import com.yt.backend.model.Test;
import com.yt.backend.model.User;
import com.yt.backend.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private   UserService userService;

    @Override
    public Test addTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Test getTestById(long idtest) {
        return testRepository.findById(idtest).get() ;
    }

    @Override
    public List<Test> getTests() {
        return (List<Test>) testRepository.findAll();
    }

    @Override
    public void deleteTest(long idtest) {testRepository.deleteById(idtest);

    }
    private final TestRepository testRepository;
    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }
    @Override
    public Test updateTest(Test test) {
        return testRepository.save(test);
    }




}
