package net.spicefox.entity;

import net.spicefox.familiar.Familiar;

import java.util.HashSet;

public class Player extends Entity{
    private int spirit;
    private int bits;

    private int numFamiliars;
    private HashSet<Familiar> bestiary;
    private Familiar activeFamiliar;
    private int modFamiliarXpRate;
    private int modFamiliarDropRate;

    public Player() {
        setSpirit(1);
        setPlayerStats();
        bestiary = new HashSet<>();
    }

    // Getters
    public int getSpirit() {
        return spirit;
    }
    public int getBits() { return bits; }
    public HashSet<Familiar> getBestiary() { return bestiary; }
    public Familiar getActiveFamiliar() { return activeFamiliar; }

    public int getModFamiliarDropRate() { return modFamiliarDropRate; }

    // Setters
    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }
    public void setBits(int bits) { this.bits = bits; }

    public void setModFamiliarXpRate() {
        modFamiliarXpRate = (int) (spirit * 2.5);
    }

    public void setModFamiliarDropRate() {
        modFamiliarDropRate = (int) (spirit * 1.3);
    }

    public void setPlayerStats() {
        setModFamiliarXpRate();
        setModFamiliarDropRate();
    }

    @Override
    public void setModMaxHp() {
        if (getActiveFamiliar() != null) {
            modMaxHp = 1 * getActiveFamiliar().getModMaxHp();
        }
        else {
            modMaxHp = 1;
        }
    }
    @Override
    public void setModMaxMana() {
        if (getActiveFamiliar() != null) {
            modMaxMana = 1 * getActiveFamiliar().getModMaxMana();
        } else {
            modMaxMana = 1;
        }
    }
    @Override
    public void setModSpeed() {
        if (getActiveFamiliar() != null) {
            modSpeed = 1 * getActiveFamiliar().getModSpeed();
        } else {
            modSpeed = 1;
        }
    }
    @Override
    public void setModAttack() {
        if (getActiveFamiliar() != null) {
            modAttack = 1 * getActiveFamiliar().getModAttack();
        } else {
            modAttack = 1;
        }
    }
    @Override
    public void setModDefense() {
        if (getActiveFamiliar() != null) {
            modDefense = 1 * getActiveFamiliar().getModDefense();
        } else {
            modDefense = 1;
        }
    }
    @Override
    public void setModAccuracy() {
        if (getActiveFamiliar() != null) {
            modAccuracy = 1 * getActiveFamiliar().getModAccuracy();
        } else {
            modAccuracy = 1;
        }
    }
    @Override
    public void setModCritChance() {
        if (getActiveFamiliar() != null) {
            modCritChance = 1 * getActiveFamiliar().getModCritChance();
        } else {
            modCritChance = 1;
        }
    }
    @Override
    public void setModSecondStrikeChance() {
        if (getActiveFamiliar() != null) {
            modSecondStrikeChance = 1 * getActiveFamiliar().getModSecondStrikeChance();
        } else {
            modSecondStrikeChance = 1;
        }
    }
    @Override
    public void setModEvasion() {
        if (getActiveFamiliar() != null) {
            modEvasion = 0 + getActiveFamiliar().getModEvasion();
        } else {
            modEvasion = 0;
        }
    }

}
