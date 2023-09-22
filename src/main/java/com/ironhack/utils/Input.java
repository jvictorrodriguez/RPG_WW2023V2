package com.ironhack.utils;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Input {
    private static Locale idiomaEnglish = Locale.ENGLISH;
    private static ResourceBundle mensajes =
            ResourceBundle.getBundle("mensajes", idiomaEnglish);
    static Scanner scanner = new Scanner(System.in);
    public static String BACK = "BACK";

    public static String getInput(String message) {
        System.out.println(mensajes.getString(message));
        return scanner.nextLine();
    }

    public static void getInput(Question question) {
        boolean isACorrectAnswer=false;
        //Loops the question until there is  correctAnswer or BACK
        do {
            try {
                //Asks the question received by parameter
                System.out.println(mensajes.getString(question.getQuestion()));
                String answer = scanner.nextLine();
                //If the answer is BACK return to the previous question
                if (answer.equalsIgnoreCase(BACK)) {
                    question.setAnswer(answer);
                    return;
                }
                //Depending on the question, stores an Integer o a String value
                switch (question.getType()) {
                    case INTEGER -> question.setAnswer(Integer.parseInt(answer));
                    case STRING -> question.setAnswer(answer);
                }
                //Looks the requirement of the Predicate
                // and check if it's a correct anwer
                isACorrectAnswer = question.getPredicate().test(question.getAnswer());
                if (!isACorrectAnswer)
                    System.out.println(mensajes.getString(question.getErrorMessage()));
                //if we answer a string in place of a integer it throws the exception
            } catch (NumberFormatException ex) {
                System.out.println(mensajes.getString("BadAnswer"));
            }
        } while (!isACorrectAnswer);
    }
}
