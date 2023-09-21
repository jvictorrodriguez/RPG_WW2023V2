package com.ironhack.model;

import com.ironhack.exceptions.IncorrectValuesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.ironhack.model.Warrior.*;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    Warrior warrior1Attack, warrior2Defendant;

    @BeforeEach
    void setUp() throws IncorrectValuesException {
        warrior1Attack = new Warrior("Warrior1", 150, 25, 5);
        warrior2Defendant = new Warrior("Warrior1", 150, 25, 5);
    }

    @Test
    void getPowerHitFromAttacker() throws IncorrectValuesException {
        warrior1Attack = new Warrior("Warrior1", 150, 25, 5);
        assertEquals(25, warrior1Attack.getEnergyFromAttacker());
    }

    @Test
    void getEnergyWeakAttackFromAttacker() {
        assertEquals(2, warrior1Attack.getEnergyWeakAttackFromAttacker());
    }

    @Test
    void decreaseHpDefendant() throws IncorrectValuesException {
        Warrior warrior3Attack = new Warrior("Warrior1", 150, 25, 5);
        Warrior warrior4Defendant = new Warrior("Warrior1", 150, 25, 5);
        warrior3Attack.attack(warrior4Defendant);
        assertEquals((150 - 5), warrior4Defendant.getHp());

    }

    @Test
    void increaseEnergyAttacker() throws IncorrectValuesException {
        Warrior warrior3Attack = new Warrior("Warrior1", 150, 25, 5);
        Warrior warrior4Defendant = new Warrior("Warrior1", 150, 25, 5);
        warrior3Attack.increaseEnergyAttacker(1);
        assertEquals(26, warrior3Attack.getStamina());
    }

    @Test
    void decreaseEnergyAttacker() throws IncorrectValuesException {
        Warrior warrior3Attack = new Warrior("Warrior1", 150, 25, 5);
        Warrior warrior4Defendant = new Warrior("Warrior1", 150, 25, 5);
        warrior3Attack.decreaseEnergyAttacker(5);
        assertEquals(20, warrior3Attack.getStamina());
    }


    @Test
    void StrengthMaxValueDoesNotThrowException() throws IncorrectValuesException {
        Warrior warrior3Attack = new Warrior("Warrior1", 150, 25, 10);
        assertDoesNotThrow(() -> warrior3Attack.setStrength(10));
        assertEquals(10, warrior3Attack.getStrength());
    }
    @Test
    void StrenthMinValueDoesNotThrowException() throws IncorrectValuesException {
        Warrior warrior3Attack = new Warrior("Warrior1", 150, 25, 1);
        assertDoesNotThrow(() -> warrior3Attack.setStamina(10));
        assertEquals(10, warrior3Attack.getStamina());
    }
    @Test
    void StrengthOverMaxValueThrowsException() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Warrior("New Warrior", 150, 51,11));
    }
    @Test
    void StaminaUnderMinValueThrowsException() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Warrior("New Warrior", 150, 9,5));
    }
    @Test
    void StaminaNegativeValueThrowsException() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Warrior("New Warrior", 150, -29,5));
    }
    @Test
    void StaminaMaxValueDoesNotThrowException() throws IncorrectValuesException {
        Warrior warrior3Attack = new Warrior("Warrior1", 150, 25, 5);
        assertDoesNotThrow(() -> warrior3Attack.setStamina(50));
        assertEquals(50, warrior3Attack.getStamina());
    }
    @Test
    void StaminaMinValueDoesNotThrowException() throws IncorrectValuesException {
        Warrior warrior3Attack = new Warrior("Warrior1", 150, 25, 5);
        assertDoesNotThrow(() -> warrior3Attack.setStamina(10));
        assertEquals(10, warrior3Attack.getStamina());
    }
    @Test
    void StaminaOverMaxValueThrowsException() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Warrior("New Warrior", 150, 51,11));
    }
    @Test
    void StrengthUnderMinValueThrowsException() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Warrior("New Warrior", 150, 9,0));
    }
    @Test
    void StrengthNegativeValueThrowsException() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Warrior("New Warrior", 150, -29,-20));
    }


    @Test
    void setHpOverMaxValue() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Warrior("New Warrior", HP_MAX+1, STAMINA_MAX,STRENGTH_MAX));

    }
    @Test
    void setHpUnderMinValue() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Warrior("New Warrior", HP_MIN-1, STAMINA_MAX,STRENGTH_MAX));
    }
    @Test
    void setHpNegativeValue() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Warrior("New Warrior", -1, STAMINA_MAX,STRENGTH_MAX));
    }
    @Test
    void setHpMaxValue() throws IncorrectValuesException {
        assertDoesNotThrow(()->new Warrior("New Warrior", HP_MAX, STAMINA_MAX,STRENGTH_MAX) );

    }
    @Test
    void setHpMinValue() throws IncorrectValuesException {
        assertDoesNotThrow(()->new Warrior("New Warrior", HP_MIN, STAMINA_MAX,STRENGTH_MAX) );
    }
}