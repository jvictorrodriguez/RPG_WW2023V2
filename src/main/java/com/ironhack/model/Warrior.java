package com.ironhack.model;

import com.ironhack.exceptions.IncorrectValuesException;

public class Warrior extends Character {
    protected final static String E_HP="❤️";
    protected final static String E_STRENGTH="💪";
    protected final static String E_STAMINA="🪫";

    final static int STAMINA_MAX = 50;
    final static int STAMINA_MIN = 10;
    final static int STRENGTH_MAX = 10;
    final static int STRENGTH_MIN = 1;
    final static int HP_MAX = 200;
    final static int HP_MIN = 100;
    private int stamina;
    private int strength;

    // ********* CONSTRUCTORS *********
    public Warrior() {
    }

    public Warrior(String name, int hp, int stamina, int strength) throws IncorrectValuesException {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    // ********* SETTERS *********
    public void setStamina(int stamina) throws IncorrectValuesException {
        if (stamina < STAMINA_MIN || STAMINA_MAX < stamina) {
            throw new IncorrectValuesException(this, "Value for Stamina incorrect");
        }
        this.stamina = stamina;
    }

    public void setStrength(int strength) throws IncorrectValuesException {
        if (strength < STRENGTH_MIN || STRENGTH_MAX < strength)
            throw new IncorrectValuesException(this, "Value for Strength incorrect");
        this.strength = strength;
    }

    public void setHp(int hp) throws IncorrectValuesException {
        if (hp < HP_MIN || HP_MAX < hp)
            throw new IncorrectValuesException(this, "Value for HP incorrect");
        super.setHp(hp);
    }
    // ********* GETTERS *********

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    // ********* IMPLEMENTATIONS getter ATTACKER *********
    @Override
    public int getEnergyFromAttacker() {
        return getStamina();
    }

    @Override
    public int getEnergyWeakAttackFromAttacker() {
        return (int) strength / 2;
    }

    @Override
    public int getEnergyHeavyAttackFromAttacker() {
        return getStrength();
    }

    // ********* IMPLEMENTATIONS setter ATTACKER *********

    @Override
    public void decreaseHpDefendant(int damage) {
        if (hp < damage) {
            hp = 0;
            setAlive(false);
        } else {
            hp -= damage;
        }
    }

    @Override
    public void increaseEnergyAttacker(int addEnergy) {
        stamina += addEnergy;
    }


    @Override
    public void decreaseEnergyAttacker(int substractEnergy) {
        stamina = stamina > substractEnergy ? stamina - substractEnergy : 0;
    }

    // ********* TO STRING *********

    @Override
    public String toString() {
        return super.toString() + "Warrior{" +
                "stamina=" + stamina +
                ", strength=" + strength +
                "} ";
    }

    public void print() {
        System.out.printf("\nWarrior: %-20s HP: %8s%s  Strength:     %8s %S    Stamina: %5s%S\n",
                getName(), getHp(), E_HP,getStrength(),E_STRENGTH, getStamina(),E_STAMINA);
    }
}
