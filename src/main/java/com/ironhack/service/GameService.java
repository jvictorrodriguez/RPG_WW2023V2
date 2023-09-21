package com.ironhack.service;

import com.ironhack.exceptions.IncorrectValuesException;
import com.ironhack.model.Attacker;
import com.ironhack.model.MiniFactoryRandom;
import com.ironhack.model.Statistics;
import com.ironhack.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GameService {


    private final static int numberOfCharactersByTeam = 3;
    private static Locale idiomaActual = new Locale("es", "ES");
//    private static ResourceBundle mensajes = ResourceBundle.getBundle("mensajes", idiomaActual);

    static List<Team> teams = new ArrayList<>();
    static List<Statistics> statisticsList= new ArrayList<>();


    public static void setUpGame() {

        teams.add(new Team("Team A"));
        teams.add(new Team("Team B"));

        Attacker attacker;
        for (int j = 0; j < teams.size(); j++) {
            for (int i = 0; i < numberOfCharactersByTeam; i++) {
                attacker = MiniFactoryRandom.createRandomAttacker();
                teams.get(j).addAttacker(attacker);
            }
        }

        teams.forEach(team -> System.out.println(team));
        war();
    }

    public static void war() {

        do {
            Attacker attackerTeamOne = teams.get(0).getAttackerList().get(0);
            Attacker attackerTeamTwo = teams.get(1).getAttackerList().get(0);
            do {
                statisticsList.add(attackerTeamOne.attack(attackerTeamTwo));
                statisticsList.add(attackerTeamTwo.attack(attackerTeamOne));
            } while (attackerTeamOne.isAlive() && attackerTeamTwo.isAlive());

            if (attackerTeamOne.isAlive()) System.out.println(teams.get(0).getTeamName() + " wins");
            else if (attackerTeamTwo.isAlive()) System.out.println(teams.get(1).getTeamName() + " wins");
            else System.out.println("Tie, both attacker are dead");

            if (!attackerTeamOne.isAlive()) teams.get(0).removeAttacker(attackerTeamOne);
            if (!attackerTeamTwo.isAlive()) teams.get(1).removeAttacker(attackerTeamTwo);


            System.out.println(attackerTeamOne);
            System.out.println(attackerTeamTwo);
        }while (teams.get(0).getAttackerList().size()>0 && teams.get(1).getAttackerList().size()>0);
        System.out.println("****************");
        teams.forEach(team -> System.out.println(team.getAttackerList().size()));
        teams.forEach(team -> System.out.println(team));
        System.out.println("****************");
        System.out.println(statisticsList);
    }

}
