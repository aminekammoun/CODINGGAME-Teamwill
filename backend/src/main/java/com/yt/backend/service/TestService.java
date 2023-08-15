package com.yt.backend.service;

import com.yt.backend.model.Question;
import com.yt.backend.model.Reponse;
import com.yt.backend.model.Test;
import com.yt.backend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TestService {

    public Test addTest (Test test);
    public Test getTestById(long idtest);
    public List<Test> getTests();
    public void deleteTest(long idtest);
    public Test updateTest (Test test);


}

