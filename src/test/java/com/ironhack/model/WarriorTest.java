package com.ironhack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    Warrior warrior1Attack, warrior2Defendant;
    @BeforeEach
    void setUp() {
        warrior1Attack = new Warrior("Warrior1", 150, 25,5);
        warrior2Defendant = new Warrior("Warrior1", 150, 25,5);

    }


    @Test
    void getPowerHitFromAttacker() {
        warrior1Attack = new Warrior("Warrior1", 150, 25,5);
        assertEquals(25, warrior1Attack.getPowerHitFromAttacker());
    }

    @Test
    void getEnergyWeakAttackFromAttacker() {
        assertEquals(2, warrior1Attack.getEnergyWeakAttackFromAttacker());
    }

    @Test
    void decreaseHpDefendant() {
        Warrior warrior3Attack = new Warrior("Warrior1", 150, 25,5);
        Warrior warrior4Defendant = new Warrior("Warrior1", 150, 25,5);
        warrior3Attack.attack(warrior4Defendant);
        assertEquals((150-5),warrior4Defendant.getHp());

    }

    @Test
    void increaseEnergyAttacker() {
        Warrior warrior3Attack = new Warrior("Warrior1", 150, 25,5);
        Warrior warrior4Defendant = new Warrior("Warrior1", 150, 25,5);
        warrior3Attack.increaseEnergyAttacker(1);
        assertEquals(26, warrior3Attack.getStamina());
    }

    @Test
    void decreaseEnergyAttacker() {
        Warrior warrior3Attack = new Warrior("Warrior1", 150, 25,5);
        Warrior warrior4Defendant = new Warrior("Warrior1", 150, 25,5);
        warrior3Attack.decreaseEnergyAttacker(5);
        assertEquals(20, warrior3Attack.getStamina());
    }




}