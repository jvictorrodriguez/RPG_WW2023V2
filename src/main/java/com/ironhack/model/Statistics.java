package com.ironhack.model;

import com.ironhack.enums.AttackType;

public class Statistics {
    private Attacker attacker;
    private Attacker defendant;
    private AttackType attackType;
    private int levelAttack;
    private int hpDefendant;

    public Statistics(Attacker attacker, Attacker defendant, AttackType attackType, int levelAttack, int hpDefendant) {
        this.attacker = attacker;
        this.defendant = defendant;
        this.attackType = attackType;
        this.levelAttack = levelAttack;
        this.hpDefendant = hpDefendant;
    }

    @Override
    public String toString() {
        return "\n***********************" +
                "\nAttacker=" + attacker.getName() +
                "\nDefendant=" + defendant.getName() +
                "\nattackType=" + attackType +
                ", levelAttack=" + levelAttack +
                ", hpDefendant=" + hpDefendant;
    }
}
