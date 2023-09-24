package com.ironhack.utils;


import com.ironhack.utils.color.Formato;

import java.text.MessageFormat;
import java.util.*;

import static com.ironhack.utils.Console.print;
import static com.ironhack.utils.color.Coloreando.*;


public class Input {
    private static Locale idiomaEnglish = Locale.ENGLISH;
    private static ResourceBundle mensajes =
            ResourceBundle.getBundle("mensajes", idiomaEnglish);
    static Scanner scanner = new Scanner(System.in);
    public static String BACK = "BACK";
    public static String EXIT = "EXIT"; //TODO


    public static String getInput(String message) {
        System.out.println(mensajes.getString(message));
        return scanner.nextLine();
    }

    public static String getInput(Question question) {

        String answer="";
        boolean isACorrectAnswer = false;
        //Loops the question until there is  correctAnswer ,BACK or EXIT
        do {
            try {
                //Asks the question received by parameter
                printQuestions(question, VERDE_NEGRITA);
                answer = scanner.nextLine();
                isACorrectAnswer = checkAnswer(answer, question);

            //if we answer a string in place of a integer it throws the exception
            } catch (NumberFormatException ex) {
                print(ROJO, mensajes.getString("BadAnswer"),0);
            }
        } while (!isACorrectAnswer);
        return answer;

    }

    public static boolean checkAnswer(String answer, Question question) {
        //If the answer is BACK return to the previous question
        if (answer.equalsIgnoreCase(BACK) || answer.equalsIgnoreCase(EXIT)) {
            question.setAnswer(answer);
            return true;
        }
        //Depending on the question, stores an Integer o a String value
        switch (question.getType()) {
            case INTEGER -> question.setAnswer(Integer.parseInt(answer));
            case STRING -> question.setAnswer(answer);
        }
        //Checks the predicate
        boolean isCorrect = question.getPredicate().test(question.getAnswer());
        if (!isCorrect)
            print(ROJO, mensajes.getString("BadAnswer"),0);
//            System.out.println(MessageFormat.format(mensajes.getString(question.getErrorMessage()), answer));
        return isCorrect;
    }

    public static void printQuestions(Question question) {
        printQuestions(question, WHITE);
    }

    public static void printQuestions(Question question, Formato color) {
        StringBuilder stringBuilder = new StringBuilder();
        //Prints to ask the question
        stringBuilder.append(mensajes.getString(question.getQuestion())).append("\n");

        //If there are options it prints them too
        List<String> options = question.getOptions();
        List<Iterator> ite = question.getOptions();//todo clean this mess

        for (String option : options) {
            stringBuilder.append(
//                    option.indexOf(option)+1)
                    ite.indexOf(option) + 1)
                    .append(")").append(mensajes.getString(option)).append("\n");
        }
        print(color, stringBuilder.toString());


    }
}

