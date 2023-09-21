package com.ironhack.model;

import com.ironhack.exceptions.IncorrectValuesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.ironhack.model.Wizard.*;
import static org.junit.jupiter.api.Assertions.*;

class WizardTest {
    Wizard wizard, wizard1, wizard2;

    @BeforeEach
    void setUp() throws IncorrectValuesException {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, 10, 25);
        Wizard wizard2 = new Wizard("Harry Potter2", 75, 10, 25);
    }

    @Test
    void getPowerHitFromAttacker() {


    }
    @Test
    void getEnergyHeavyAttackFromAttacker() throws IncorrectValuesException {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, 10, 25);
        Wizard wizard2 = new Wizard("Harry Potter2", 75, 10, 25);

        assertEquals(25, wizard1.getEnergyHeavyAttackFromAttacker());
    }
    @Test
    void getEnergyWeakAttackFromAttacker() throws IncorrectValuesException {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, 10, 25);
        Wizard wizard2 = new Wizard("Harry Potter2", 75, 10, 25);
        wizard1.attack(wizard2); //heavy attack -25
        wizard1.attack(wizard2); //heavy attack -25
        wizard1.attack(wizard2); //weak attack -1

        assertEquals((75-25-25  - wizard1.getEnergyWeakAttackFromAttacker()), wizard2.getHp());

    }

    @Test
    void decreaseHpDefendant() throws IncorrectValuesException {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, 10, 25);
        Wizard wizard2 = new Wizard("Harry Potter2", 75, 10, 25);
        wizard1.attack(wizard2); //heavy attack -25
        assertEquals(75 - 25, wizard2.getHp());
        wizard1.attack(wizard2);  //heavy attack -25
        assertEquals(75 - 25 - 25 , wizard2.getHp());
        wizard1.attack(wizard2);  //weak attack -1
        assertEquals(75 - 25 - 25 - 1, wizard2.getHp());
    }

    @Test
    void increaseEnergyAttacker() throws IncorrectValuesException {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, 10, 25);
        Wizard wizard2 = new Wizard("Harry Potter2", 75, 10, 25);
        wizard1.attack(wizard2);
        assertEquals(5, wizard1.getMana());

    }

    @Test
    void decreaseEnergyAttacker() throws IncorrectValuesException {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, 10, 25);
        Wizard wizard2 = new Wizard("Harry Potter2", 75, 10, 25);
        wizard2.attack(wizard1);
        assertEquals(5, wizard2.getMana());
    }
    @Test
    void ManaMaxValueDoesNotThrowException() throws IncorrectValuesException {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, MANA_MAX, 25);
        assertDoesNotThrow(() -> wizard1.setMana(MANA_MAX));
        assertEquals(MANA_MAX, wizard1.getMana());
    }
    @Test
    void manaMinValueDoesNotThrowException() throws IncorrectValuesException {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, MANA_MAX, 25);
        assertDoesNotThrow(() -> wizard1.setMana(MANA_MIN));
        assertEquals(MANA_MIN, wizard1.getMana());
    }
    @Test
    void manaOverMaxValueThrowsException() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Wizard("Harry Potter1", 75, MANA_MAX+1, 25));
    }
    @Test
    void manaUnderMinValueThrowsException() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Wizard("Harry Potter1", 75, MANA_MIN-1, 25));
    }
    @Test
    void manaNegativeValueThrowsException() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Wizard("Harry Potter1", 75, -50, 25));
    }
    @Test
    void manaMaxValueDoesNotThrowException() throws IncorrectValuesException {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, MANA_MAX, 25);
        assertDoesNotThrow(() -> wizard1.setMana(MANA_MAX));
        assertEquals(MANA_MAX, wizard1.getMana());
    }
    @Test
    void intelligenceMinValueDoesNotThrowException() throws IncorrectValuesException {
        Wizard wizard1 = new Wizard("Harry Potter1", 75, MANA_MAX, 25);
        assertDoesNotThrow(() -> wizard1.setIntelligence(INTELLIGENCE_MIN));
        assertEquals(INTELLIGENCE_MIN, wizard1.getIntelligence());
    }
    @Test
    void intelligenceOverMaxValueThrowsException() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class,
                ()-> new Wizard("Harry Potter1", 75, 50, INTELLIGENCE_MAX+1));
    }
    @Test
    void intelligenceUnderMinValueThrowsException() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class,
                ()-> new Wizard("Harry Potter1", 75, 50, INTELLIGENCE_MIN-1));
    }
    @Test
    void intelligenceNegativeValueThrowsException() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class,
                ()-> new Wizard("Harry Potter1", 75, 50, -1));
    }

    @Test
    void setHpOverMaxValue() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Wizard("New Wizard", HP_MAX+1, MANA_MAX,INTELLIGENCE_MAX));

    }
    @Test
    void setHpUnderMinValue() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Wizard("New Wizard", HP_MIN-1, MANA_MAX,INTELLIGENCE_MAX));
    }
    @Test
    void setHpNegativeValue() throws IncorrectValuesException {
        assertThrows(IncorrectValuesException.class, ()-> new Wizard("New Wizard", -1, MANA_MAX,INTELLIGENCE_MAX));
    }
    @Test
    void setHpMaxValue() throws IncorrectValuesException {
        assertDoesNotThrow(()->new Wizard("New Wizard", HP_MAX, MANA_MAX,INTELLIGENCE_MAX) );

    }
    @Test
    void setHpMinValue() throws IncorrectValuesException {
        assertDoesNotThrow(()->new Wizard("New Wizard", HP_MIN, MANA_MAX,INTELLIGENCE_MAX) );
    }

}