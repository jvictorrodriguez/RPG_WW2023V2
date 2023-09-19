package com.ironhack.model;

import com.ironhack.enums.AttackType;


public interface Attacker {
    int requiredEnergyToHeavyAttack = 5;
    int subtractEnergy = 5;
    int addEnergy = 1;

    default Statistics attack(Attacker defendant) {

        int damage;
        AttackType attackType;
        if (getPowerHitFromAttacker() >= requiredEnergyToHeavyAttack) {
            attackType = AttackType.HEAVY_ATTACK;
            damage = getEnergyHeavyAttackFromAttacker();
            decreaseEnergyAttacker(subtractEnergy);

        } else {
            attackType = AttackType.WEAK_ATTACK;
            damage = getEnergyWeakAttackFromAttacker();
            increaseEnergyAttacker(addEnergy);
        }

        defendant.decreaseHpDefendant(damage);
        return new Statistics(this, defendant, attackType, damage, defendant.getHp());
    }


    int getPowerHitFromAttacker();

    int getEnergyWeakAttackFromAttacker();
    int getEnergyHeavyAttackFromAttacker();

    int getHp();

    void decreaseHpDefendant(int damage);

    void increaseEnergyAttacker(int addEnergy);

    void decreaseEnergyAttacker(int subtractEnergy);


}
