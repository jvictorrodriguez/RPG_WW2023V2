package com.ironhack.service;

import com.ironhack.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GameService {


    private final static int numberOfCharactersByTeam = 3;
    private static Locale idiomaActual = new Locale("es", "ES");
//    private static ResourceBundle mensajes = ResourceBundle.getBundle("mensajes", idiomaActual);


    static List<Statistics> statisticsList = new ArrayList<>();


    public static void setUpGame() {
        Team teamOne, teamTwo;

        //Creates the teams
        teamOne = new Team("Team A");
        teamTwo = new Team("Team B");


        fillTeamCustomized(teamOne);


        fillTeamWithRandomAttackers(teamOne);
        fillTeamWithRandomAttackers(teamTwo);

        System.out.println("\nTeam One");
        teamOne.getAttackerList().forEach(Attacker::print);
        System.out.println("\nTeam Two");

        teamTwo.getAttackerList().forEach(Attacker::print);


        fight(teamOne, teamTwo);
    }

    private static void fillTeamCustomized(Team teamOne) {

        for (int i = 0; i < numberOfCharactersByTeam; i++) {
            Questions name = new Questions("Input a name for the Attacker");

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
