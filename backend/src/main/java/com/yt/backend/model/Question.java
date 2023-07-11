package com.yt.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="question_table")
public class Question {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idquest;
    private String type;
    private String question;

    public long getIdquest() {
        return idquest;
    }

    public void setIdquest(long idquest) {
        this.idquest = idquest;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


}
