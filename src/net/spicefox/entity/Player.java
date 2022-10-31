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
    public void setModMaxHp() { modMaxHp = 1 * getActiveFamiliar().getModMaxHp(); }
    @Override
    public void setModMaxMana() { modMaxMana = 1 * getActiveFamiliar().getModMaxMana(); }
    @Override
    public void setModSpeed() { modSpeed = 1 * getActiveFamiliar().getModSpeed(); }
    @Override
    public void setModAttack() { modAttack = 1 * getActiveFamiliar().getModAttack(); }
    @Override
    public void setModDefense() { modDefense = 1 * getActiveFamiliar().getModDefense(); }
    @Override
    public void setModAccuracy() { modAccuracy = 1 * getActiveFamiliar().getModAccuracy(); }
    @Override
    public void setModCritChance() { modCritChance = 1 * getActiveFamiliar().getModCritChance(); }
    @Override
    public void setModSecondStrikeChance() {
        modSecondStrikeChance = 1 * getActiveFamiliar().getModSecondStrikeChance();
    }
    @Override
    public void setModEvasion() { modEvasion = 0 + getActiveFamiliar().getModEvasion(); }

}
