package com.yt.backend.controller;

import com.yt.backend.model.Question;
import com.yt.backend.model.Reponse;

public class QuestionAndReponseDTO {
    private Question question;
    private Reponse reponse;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Reponse getReponse() {
        return reponse;
    }

    public void setReponse(Reponse reponse) {
        this.reponse = reponse;
    }
}
