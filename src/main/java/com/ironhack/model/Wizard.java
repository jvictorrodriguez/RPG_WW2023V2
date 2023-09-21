package com.ironhack.model;

import com.ironhack.exceptions.IncorrectValuesException;

public class Wizard extends Character {
    public final static int HP_MAX = 100;
    public final static int HP_MIN = 50;
    public final static int MANA_MAX = 50;
    public final static int MANA_MIN = 10;
    public final static int INTELLIGENCE_MAX = 50;
    public final static int INTELLIGENCE_MIN = 1;


    private int mana;
    private int intelligence;

    // ********* CONSTRUCTORS *********
    public Wizard() {
    }

    public Wizard(String name, int hp, int mana, int intelligence) throws IncorrectValuesException {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }
    // ********* GETTERS *********

    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    // ********* SETTERS *********

    public void setMana(int mana) throws IncorrectValuesException {
        if (mana < MANA_MIN || MANA_MAX < mana)
            throw new IncorrectValuesException(this, "Value for Mana incorrect");
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) throws IncorrectValuesException {
        if (intelligence < INTELLIGENCE_MIN ||  INTELLIGENCE_MAX < intelligence)
            throw new IncorrectValuesException(this, "Value for Intelligence incorrect");
        this.intelligence = intelligence;
    }

    public void setHp(int hp) throws IncorrectValuesException {
        if (hp < HP_MIN || HP_MAX < hp)
            throw new IncorrectValuesException(this, "Value for HP incorrect");
        super.setHp(hp);
    }

    // ********* IMPLEMENTATIONS getter ATTACKER *********
    @Override
    public int getEnergyFromAttacker() {
        return getMana();
    }

    @Override
    public int getEnergyWeakAttackFromAttacker() {
        return 1;
    }

    @Override
    public int getEnergyHeavyAttackFromAttacker() {
        return getIntelligence();
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
        mana += addEnergy;
    }

    @Override
    public void decreaseEnergyAttacker(int subtractEnergy) {
        mana = mana > subtractEnergy ? mana - subtractEnergy : 0;
    }
    // ********* TO STRING *********

    @Override
    public String toString() {
        return "\nWizard{" +
                "mana=" + mana +
                ", intelligence=" + intelligence +
                "} " + super.toString();
    }
}
