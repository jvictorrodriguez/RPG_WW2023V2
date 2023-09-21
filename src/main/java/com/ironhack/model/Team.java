package com.ironhack.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Attacker> attackerList = new ArrayList<>();

    // ********* CONSTRUCTORS *********
    public Team() {
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    // ********* GETTERS *********
    public String getTeamName() {
        return teamName;
    }

    public List<Attacker> getAttackerList() {
        return attackerList;
    }

    // ********* MORE METHODS *********
    public void addAttacker(Attacker attacker) {
        attackerList.add(attacker);
    }

    public void removeAttacker(Attacker attacker) {
        attackerList.remove(attacker);
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", attackerList=" + attackerList +
                '}';
    }
}
