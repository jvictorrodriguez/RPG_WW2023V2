package com.ironhack.utils;

import com.ironhack.enums.Type;
import com.ironhack.utils.color.Formato;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static com.ironhack.utils.color.Coloreando.*;
import static com.ironhack.utils.color.Formato.RESET;


public class Console {
    static List<String> questionsKeyList = new ArrayList<>();
    static HashMap<String, Question> questionsHashMap = new HashMap<>();
    public final static int DELAY = 10;



    public static void main(String[] args) {
        clear();
        print(ROJO, Titles.warriorsWizards(), DELAY);



        selectModeGame();
        setUpTeamA();
        questionsKeyList.add("modeGame");
        questionsKeyList.add("howToCreateTheTeam");


        int idQuestion=0;
        String answer;
        do{
            String getQuestionKeyFromQuestionKeyList= questionsKeyList.get(idQuestion);
            Question questionToAsk= questionsHashMap.get(getQuestionKeyFromQuestionKeyList);
            answer= Input.getInput(questionToAsk);
            if (answer.equalsIgnoreCase("EXIT")) break;
            if (answer.equalsIgnoreCase("BACK") && idQuestion>0) idQuestion--;
            else idQuestion++;

        }while (idQuestion<questionsKeyList.size());





    }

    public static void selectModeGame() {
        Question<Integer> modeGame = new Question("SelectModeGame", Type.INTEGER);
        modeGame.addAnswerOptions("HumanVsHuman");
        modeGame.addAnswerOptions("HumanVsCPU");
        modeGame.addAnswerOptions("CPUVsCPU");
        modeGame.addPredicate(option -> option > 0);
        modeGame.addPredicate(option -> option < modeGame.getOptions().size());
        questionsHashMap.put("modeGame", modeGame);
    }

    private static void setUpTeamA() {
        Question<Integer> howToCreateTheTeam = new Question<>("howToCreateTheTeam", Type.INTEGER);
        howToCreateTheTeam.addAnswerOptions("CustomizedByYou");
        howToCreateTheTeam.addAnswerOptions("Random");
        howToCreateTheTeam.addAnswerOptions("ImportFromFile");
        howToCreateTheTeam.addPredicate(option -> option > 0);
        howToCreateTheTeam.addPredicate(option -> option < howToCreateTheTeam.getOptions().size());
        questionsHashMap.put("howToCreateTheTeam", howToCreateTheTeam);
    }

    public static void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println("\n");

        }
    }

    public static void sleep(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
            System.out.println("InterruptedException");
        }
    }

    public static void print(Formato color, String str, int miliseconds) {
        for (String line : str.split("\\n")) {
            sleep(miliseconds);
            System.out.println(color + line + RESET);
        }
    }

    public static void print(Formato color, String str) {
        System.out.println(color + str + RESET);
    }
}
