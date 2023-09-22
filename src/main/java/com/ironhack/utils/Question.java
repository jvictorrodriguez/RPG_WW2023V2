package com.ironhack.utils;

import com.ironhack.enums.Type;

import java.util.function.Predicate;

public class Question <T>{
    private String question;
    private Type type;
    private T answer;
    private String errorMessage;
    private Predicate<T> predicate;

    //***** CONSTRUCTOR ****
    public Question(String question) {
        this.question = question;
    }

    public Question(String question, Type type) {
        this.question = question;
        this.type = type;
    }

    //***** GETTER ****
    public String getQuestion() {
        return question;
    }

    public Type getType() {
        return type;
    }

    public T getAnswer() {
        return answer;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Predicate<T> getPredicate() {
        return predicate;
    }

    //***** SETTER ****

    public void setType(Type type) {
        this.type = type;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(T answer) {
        this.answer = answer;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    //***** OTHER METHODS ****
    public void addPredicate(Predicate <T> predicate) {
        if (this.predicate==null)
            this.predicate=predicate;
        this.predicate= this.predicate.and(predicate);
    }






}
