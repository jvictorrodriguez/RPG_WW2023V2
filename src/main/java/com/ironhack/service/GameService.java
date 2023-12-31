package com.ironhack.service;

import com.ironhack.enums.Type;
import com.ironhack.model.*;
import com.ironhack.utils.Console;
import com.ironhack.utils.Input;
import com.ironhack.utils.Question;
import com.ironhack.utils.Titles;

import java.util.*;


public class GameService {

    private Team teamOne=new Team();
    private Team teamTwo=new Team();
    private final static int numberOfCharactersByTeam = 3;
    private static Locale idiomaActual = new Locale("es", "ES");
    //    private static Locale idiomaEnglish = Locale.ENGLISH;
//        private static ResourceBundle mensajes = ResourceBundle.getBundle("mensajes", idiomaActual);
//        private static ResourceBundle mensajes = ResourceBundle.getBundle("mensajes", idiomaEnglish);
    static List<Question> questionList = new ArrayList<>();

    static List<Statistics> statisticsList = new ArrayList<>();

    public GameService() {
    }

    public GameService(Team teamOne, Team teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    public void setUpGame() {
//        Team teamOne, teamTwo;

//
//        Console.clear();
//        System.out.println(Titles.warriorsWizards());

        //Creates the teams
//        teamOne = new Team("Team A");
//        teamTwo = new Team("Team B");

        //Create questions
//        createQuestions();

        fillTeamCustomized(teamOne);


        fillTeamWithRandomAttackers(teamOne);
        fillTeamWithRandomAttackers(teamTwo);

        System.out.println("\nTeam One");
        teamOne.getAttackerList().forEach(Attacker::print);
        System.out.println("\nTeam Two");

        teamTwo.getAttackerList().forEach(Attacker::print);


        fight(teamOne, teamTwo);
    }



    public  void fillTeamCustomized(Team teamOne) {


        for (int i = 0; i < numberOfCharactersByTeam; i++) {
            int idQuestion = 0;
            do {
                System.out.println("Attacker "+(i+1));
                //Takes the question from the questionList
                Question question = questionList.get(idQuestion);
                //Asks the question
                Input.getInput(question);

                //Checks the answer if the user doesn't type "BACK"
                //And adjusts the idQuestion and i counter
                if (!question.getAnswer().toString().equalsIgnoreCase("BACK"))
                {
                    idQuestion++;
                }
                //If the answer is BACK
                else {
                    //Goes back 1 question
                    if (idQuestion>0)   idQuestion--;
                    //Goes back to previous attacker
                    //and to the last question
                    else if (idQuestion==0 && i>0){
                        idQuestion=questionList.size()-1;
                        i--;
                    }
                }
            } while (idQuestion< questionList.size());

//                    boolean isACorrectAnswer = question.getPredicate().test(question.getAnswer());
//                    if (isACorrectAnswer)


            }
        }



    private static void fillTeamWithRandomAttackers(Team team) {
        //Fill the team with attackers
        Attacker attacker;
        for (int i = 0; i < numberOfCharactersByTeam; i++) {
            attacker = MiniFactoryRandom.createRandomAttacker();
            team.addAttacker(attacker);
        }
    }


    public static void fight(Team teamOne, Team teamTwo) {
        List<Team> teamList = Arrays.asList(teamOne, teamTwo);


        do {
            Attacker attackerTeamOne = teamList.get(0).getAttackerList().get(0);
            Attacker attackerTeamTwo = teamList.get(1).getAttackerList().get(0);
            do {
                statisticsList.add(attackerTeamOne.attack(attackerTeamTwo));
                statisticsList.add(attackerTeamTwo.attack(attackerTeamOne));
            } while (attackerTeamOne.isAlive() && attackerTeamTwo.isAlive());

            if (attackerTeamOne.isAlive()) System.out.println(teamList.get(0).getTeamName() + " wins");
            else if (attackerTeamTwo.isAlive()) System.out.println(teamList.get(1).getTeamName() + " wins");
            else System.out.println("Tie, both attacker are dead");

            if (!attackerTeamOne.isAlive()) teamList.get(0).removeAttacker(attackerTeamOne);
            if (!attackerTeamTwo.isAlive()) teamList.get(1).removeAttacker(attackerTeamTwo);


            System.out.println(attackerTeamOne);
            System.out.println(attackerTeamTwo);
        } while (teamList.get(0).getAttackerList().size() > 0 && teamList.get(1).getAttackerList().size() > 0);
        System.out.println("****************");
        teamList.forEach(team -> System.out.println(team.getAttackerList().size()));
        teamList.forEach(team -> System.out.println(team));
        System.out.println("****************");
        System.out.println(statisticsList);
    }

}
