package com.ironhack.model;

import com.ironhack.enums.AttackerType;
import com.ironhack.exceptions.IncorrectValuesException;
import net.datafaker.Faker;

import java.util.Random;

public class MiniFactoryRandom {



    static Faker faker = new Faker();

    static Random random = new Random();
    private static int numberOfCharacterTypes = AttackerType.values().length;

    public static Attacker createRandomAttacker() {

        int option = random.nextInt(0, numberOfCharacterTypes);
        switch (option) {
            case 0:
                return crearRandomWarrior();
            case 1:
                return crearRandomWizard();
        }

        return null;
    }

    public static Attacker crearRandomWarrior() {

        try {
            Warrior warrior = new Warrior(faker.lordOfTheRings().character(),
                    random.nextInt(Warrior.HP_MIN, Warrior.HP_MAX + 1),
                    random.nextInt(Warrior.STAMINA_MIN, Warrior.STAMINA_MAX + 1),
                    random.nextInt(Warrior.STRENGTH_MIN, Warrior.STRENGTH_MAX + 1));
            return warrior;
        } catch (IncorrectValuesException e) {
            System.out.println("Error in random Warrior");
        }
        return null;
    }

    public static Attacker crearRandomWizard() {
        try {
            Wizard wizard = new Wizard(faker.harryPotter().character(),
                    random.nextInt(Wizard.HP_MIN, Wizard.HP_MAX + 1),
                    random.nextInt(Wizard.MANA_MIN, Wizard.MANA_MAX + 1),
                    random.nextInt(Wizard.INTELLIGENCE_MIN, Wizard.INTELLIGENCE_MAX + 1));
            return wizard;
        } catch (IncorrectValuesException e) {
            System.out.println("Error in random Wizard");
        }
        return null;
    }
}
