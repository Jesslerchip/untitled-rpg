package net.spicefox.entity;

import net.spicefox.familiar.Familiar;
import net.spicefox.util.Inventory;

public class Player extends Entity{
    private int spirit;
    private int bits;
    private Familiar activeFamiliar;
    private double modFamiliarXpRate;
    private double modFamiliarDropRate;

    public Player() {
        setSpirit(1);
        setPlayerStats();
        inventory = new Inventory();
    }

    // Getters
    public int getSpirit() {
        return spirit;
    }
    public int getBits() { return bits; }
    public Familiar getActiveFamiliar() { return activeFamiliar; }

    // Setters
    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }
    public void setBits(int bits) { this.bits = bits; }

    public void setModFamiliarXpRate() {
        modFamiliarXpRate = spirit * 2.5;
    }

    public void setModFamiliarDropRate() {
        modFamiliarXpRate = spirit * 1.3;
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
