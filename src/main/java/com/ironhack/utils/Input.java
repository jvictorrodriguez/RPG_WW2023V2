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
        do {
            try {
                System.out.println(mensajes.getString(question.getQuestion()));
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase(BACK)) {
                    question.setAnswer(answer);
                    return;
                }
                switch (question.getType()) {
                    case INTEGER -> question.setAnswer(Integer.parseInt(answer));
                    case STRING -> question.setAnswer(answer);
                }
                isACorrectAnswer = question.getPredicate().test(question.getAnswer());
                if (!isACorrectAnswer) System.out.println(mensajes.getString("BadAnswer"));
            } catch (NumberFormatException ex) {
                System.out.println(mensajes.getString("BadAnswer"));
            }
        } while (!isACorrectAnswer);
    }
}
