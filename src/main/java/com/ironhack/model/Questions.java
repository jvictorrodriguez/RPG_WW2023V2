package com.ironhack.model;

import java.util.function.Predicate;

public class Questions {
    private String question;
    private Predicate predicate;
    private String answer;

    //****************** CONSTRUCTORS ******************
    public Questions(String question) {
        this.question = question;
    }

    public Questions() {
    }

    //****************** GETTERS ******************

    public String getQuestion() {
        return question;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public String getAnswer() {
        return answer;
    }

    //****************** SETTERS ******************

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
