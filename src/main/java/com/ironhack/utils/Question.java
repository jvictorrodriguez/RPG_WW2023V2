package com.ironhack.utils;

import com.ironhack.enums.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Question <T>{
    private String question;
    private Type type;
    private List<String> options= new ArrayList<>();
    private T answer;
    private String errorMessage="BadAnswer";
    private Predicate<T> predicate;

    //***** CONSTRUCTOR ****

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

    public List<String> getOptions() {
        return options;
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
    public void addAnswerOptions(String option) {
        options.add(option);
    }
}
