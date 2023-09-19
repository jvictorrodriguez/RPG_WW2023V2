package com.ironhack.model;

public class Wizard extends Character{
    public final static int WIZARD_MAX_HP=100;
    public final static int WIZARD_MIN_HP=50;
    public final static int WIZARD_MAX_MANA=50;
    public final static int WIZARD_MIN_MANA=10;
    public final static int WIZARD_MAX_INTELLIGENCE=50;
    public final static int WIZARD_MIN_INTELLIGENCE=1;

    private int mana;
    private int intelligence;

    // ********* CONSTRUCTORS *********
    public Wizard() {
    }

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }
    // ********* GETTERS *********

    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    // ********* SETTERS *********

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    // ********* TO STRING *********

    @Override
    public String toString() {
        return "Wizard{" +
                "mana=" + mana +
                ", intelligence=" + intelligence +
                "} " + super.toString();
    }
}