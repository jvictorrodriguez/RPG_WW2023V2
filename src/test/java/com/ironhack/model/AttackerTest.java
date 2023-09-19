package com.ironhack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttackerTest {

    Warrior warrior1Attack, warrior2Defendant;

    @BeforeEach
    void setUp() {
        warrior1Attack = new Warrior("Warrior1", 150, 25,5);
        warrior2Defendant = new Warrior("Warrior1", 150, 25,5);

    }
    @Test
    void attack() {
        warrior1Attack.attack(warrior2Defendant);
        assertEquals(145,warrior2Defendant.getHp());
    }
}