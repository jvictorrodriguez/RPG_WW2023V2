package com.ironhack.model;

public class Warrior extends Character{
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

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }
    // ********* GETTERS *********

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    // ********* SETTERS *********

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    // ********* TO STRING *********

    @Override
    public String toString() {
        return "Warrior{" +
                "stamina=" + stamina +
                ", strength=" + strength +
                "} " + super.toString();
    }
}
