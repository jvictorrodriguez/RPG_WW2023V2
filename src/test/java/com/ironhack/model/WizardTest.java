package com.ironhack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {
    Wizard wizard, wizard1, wizard2;

    @BeforeEach
    void setUp() {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, 6, 25);
        Wizard wizard2 = new Wizard("Harry Potter2", 75, 4, 25);
    }

    @Test
    void getPowerHitFromAttacker() {


    }
    @Test
    void getEnergyHeavyAttackFromAttacker() {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, 6, 25);
        Wizard wizard2 = new Wizard("Harry Potter2", 75, 4, 25);

        assertEquals(25, wizard1.getEnergyHeavyAttackFromAttacker());
    }
    @Test
    void getEnergyWeakAttackFromAttacker() {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, 4, 25);
        Wizard wizard2 = new Wizard("Harry Potter2", 75, 4, 25);
        wizard1.attack(wizard2);
        assertEquals((75 - wizard1.getEnergyWeakAttackFromAttacker()), wizard2.getHp());

    }

    @Test
    void decreaseHpDefendant() {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, 4, 25);
        Wizard wizard2 = new Wizard("Harry Potter2", 75, 6, 25);
        wizard1.attack(wizard2);
        assertEquals(75 - 1, wizard2.getHp());
        wizard2.attack(wizard1);
        assertEquals(75 - 25, wizard1.getHp());
    }

    @Test
    void increaseEnergyAttacker() {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, 4, 25);
        Wizard wizard2 = new Wizard("Harry Potter2", 75, 6, 25);
        wizard1.attack(wizard2);
        assertEquals(5, wizard1.getMana());

    }

    @Test
    void decreaseEnergyAttacker() {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, 4, 25);
        Wizard wizard2 = new Wizard("Harry Potter2", 75, 6, 25);
        wizard2.attack(wizard1);
        assertEquals(1, wizard2.getMana());
    }
}