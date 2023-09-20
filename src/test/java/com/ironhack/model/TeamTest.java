package com.ironhack.model;

import com.ironhack.exceptions.IncorrectValuesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    Team team= new Team("Team A");
    @Test
    void getTeamName() {

        assertEquals("Team A", team.getTeamName());
    }



    @Test
    void addAttacker() throws IncorrectValuesException {
        Attacker attacker1 = new Warrior("Warrior1",100,50,10);
        team.addAttacker(attacker1);
        assertEquals(1, team.getAttackerList().size());
    }

    @Test
    void removeAttacker() throws IncorrectValuesException {
        Attacker attacker1 = new Warrior("Warrior1",100,50,10);
        team.addAttacker(attacker1);
        team.removeAttacker(attacker1);
        assertEquals(0, team.getAttackerList().size());
    }
}