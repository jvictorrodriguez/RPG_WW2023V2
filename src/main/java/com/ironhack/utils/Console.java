package com.ironhack.utils;

import com.ironhack.enums.AttackerType;
import com.ironhack.enums.Type;
import com.ironhack.exceptions.IncorrectValuesException;
import com.ironhack.model.Attacker;
import com.ironhack.model.MiniFactoryRandom;
import com.ironhack.model.Team;
import com.ironhack.model.Warrior;
import com.ironhack.service.GameService;
import com.ironhack.utils.color.Formato;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.ironhack.utils.Input.getInput;
import static com.ironhack.utils.Input.printOption;
import static com.ironhack.utils.color.Coloreando.*;
import static com.ironhack.utils.color.Formato.RESET;


public class Console {
    //    static List<String> questionsKeyList = new ArrayList<>();
    static HashMap<String, Question> questionsHashMap = new HashMap<>();
    public final static int DELAY = 10;


    public static void main(String[] args) {
        clear();
        print(ROJO, Titles.warriorsWizards(), DELAY);
        createAllQuestions();


        List<String> answersMainMenu = showMenu(List.of("modeGame", "howToCreateTheTeam"));


        Integer modeGameAnswer = (Integer) questionsHashMap.get("modeGame").getAnswer();
        Integer howToCreateTheTeamAnswer = (Integer) questionsHashMap.get("howToCreateTheTeam").getAnswer();

        //Human vs Human
        if (modeGameAnswer == 1) {
            if (howToCreateTheTeamAnswer == 1) {
                showMenu(List.of("nameTheTeam"));
                Team team = new Team(questionsHashMap.get("nameTheTeam").getAnswer().toString());

                showMenu(List.of("attackerKind","nameAttacker",
                        "hpAttacker", "energyAttacker", "strengthAttacker"));
                switch (questionsHashMap.get("attackerKind").getAnswer().toString()){
                    case "1"-> {
                        try {
                            Attacker attacker = new Warrior(questionsHashMap.get("nameAttacker").getAnswer().toString(),
                                    Integer.parseInt(questionsHashMap.get("hpAttacker").getAnswer().toString()),
                                    Integer.parseInt(questionsHashMap.get("energyAttacker").getAnswer().toString()),
                                    Integer.parseInt(questionsHashMap.get("strengthAttacker").getAnswer().toString()));
                        } catch (IncorrectValuesException e) {
                            print(ROJO,"BadAnswer");
                        }
                    }
                }
            }


            String nameTheTeam = (String) questionsHashMap.get("nameTheTeam").getAnswer();
            Team teamOne = new Team(nameTheTeam);

//            showMenu(List.of("");
        }


//        GameService gs= new GameService();
//        System.out.println( questionsHashMap.get("hotToCreateTheTeam").getAnswer();
//        int option= Integer.parseInt(questionsHashMap.get("modeGame").getAnswer().toString());
//        String optionDetail= questionsHashMap.get("modeGame").getOptions().get(option-1).toString();
//        switch (option){
//            case 1-> {
//                System.out.println("**********************");
//                //Human vs Human
//                printOption(optionDetail);
//                if ()
//
//
//
//                gs.fillTeamCustomized(gs.tea);
//            }
//            case 2-> System.out.println("case 2");
//            //Human Vs CPU
//            case 3-> System.out.println("case 3");
//            // CPU VS CPU
//        }
    }

    private static List<String> showMenu(List<String> questionsKeyList) {
        List<String> answerList = new ArrayList<>();
        int idQuestion = 0;
        String answer;
        do {
            System.out.println(idQuestion);
            String getQuestionKeyFromQuestionKeyList = questionsKeyList.get(idQuestion);
            Question questionToAsk = questionsHashMap.get(getQuestionKeyFromQuestionKeyList);
            answer = Input.getInput(questionToAsk);

            if (answer.equalsIgnoreCase("EXIT")) break;
            if (answer.equalsIgnoreCase("BACK") && idQuestion > 0) idQuestion--;
            else {
                idQuestion++;
                answerList.add(answer);
            }

        } while (idQuestion < questionsKeyList.size());
        return answerList;
    }


    public static void createAllQuestions() {

        //SelectModeGame
        Question<Integer> modeGame = new Question("SelectModeGame", Type.INTEGER);
        modeGame.addAnswerOptions("HumanVsHuman");
        modeGame.addAnswerOptions("HumanVsCPU");
        modeGame.addAnswerOptions("CPUVsCPU");
        modeGame.addPredicate(option -> option > 0);
        modeGame.addPredicate(option -> option <= modeGame.getOptions().size());
        questionsHashMap.put("modeGame", modeGame);

        //HowToCreateTheTeam
        Question<Integer> howToCreateTheTeam = new Question<>("howToCreateTheTeam", Type.INTEGER);
        howToCreateTheTeam.addAnswerOptions("CustomizedByYou");
        howToCreateTheTeam.addAnswerOptions("Random");
        howToCreateTheTeam.addAnswerOptions("ImportFromFile");
        howToCreateTheTeam.addPredicate(option -> option > 0);
        howToCreateTheTeam.addPredicate(option -> option <= howToCreateTheTeam.getOptions().size());
        questionsHashMap.put("howToCreateTheTeam", howToCreateTheTeam);

        //NameTheTeam
        Question<String> nameTheTeam = new Question<>("nameTheTeam", Type.STRING);
        nameTheTeam.addPredicate(word -> word.length() > 0);
        nameTheTeam.addPredicate(word -> word.length() <= 10);
        nameTheTeam.setErrorMessage("NameLengthBetween0and10");
        questionsHashMap.put("nameTheTeam", nameTheTeam);

        //AttackerKind
        Question<Integer> attackerKind = new Question<>("attackerKind", Type.INTEGER);
        for (AttackerType attacker : AttackerType.values()) {
            attackerKind.addAnswerOptions(attacker.toString());
        }
        attackerKind.addPredicate(attacker -> attacker > 0);
        attackerKind.addPredicate(attacker -> attacker <= AttackerType.values().length);
        questionsHashMap.put("attackerKind", attackerKind);


        //nameAttacker
        Question<String> nameAttacker = new Question<>("nameAttacker", Type.STRING);
        nameAttacker.addPredicate(name -> name.length() > 0);
        nameAttacker.addPredicate(name -> name.length() <= 10);
        nameAttacker.setErrorMessage("NameLengthBetween0and10");
        questionsHashMap.put("nameAttacker", nameAttacker);

        //hpAttacker
        Question<Integer> hpAttacker = new Question<>("hpAttacker", Type.INTEGER);
        hpAttacker.addPredicate(value -> value > 0);
        questionsHashMap.put("hpAttacker", hpAttacker);

        //energyAttacker
        Question<Integer> energyAttacker = new Question<>("energyAttacker", Type.INTEGER);
        energyAttacker.addPredicate(value -> value > 0);
        questionsHashMap.put("energyAttacker", energyAttacker);

        //strengthAttacker
        Question<Integer> strengthAttacker = new Question<>("strengthAttacker", Type.INTEGER);
        strengthAttacker.addPredicate(value -> value > 0);
        questionsHashMap.put("strengthAttacker", strengthAttacker);

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
