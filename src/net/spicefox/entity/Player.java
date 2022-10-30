package net.spicefox.entity;

import net.spicefox.gear.*;
import net.spicefox.inventory.Inventory;

public class Player extends Entity{
    private int spirit;
    private int numFamiliars;
    private double modFamiliarXpRate;
    private double modFamiliarDropRate;

    public Player(String name) {
        setMaxHp(1);
        setHp(getMaxHp());
        setMaxMana(1);
        setMana(getMaxMana());
        this.setName(name);
        this.setHat(new HatDummy());
        this.setRobe(new RobeDummy());
        this.setBoots(new BootsDummy());
        this.setShield(new ShieldDummy());
        this.setWeapon(new WeaponDummy());
        this.setVitality(1);
        this.setMagick(1);
        this.setDexterity(1);
        this.setStrength(1);
        this.setResistance(1);
        this.setFocus(1);
        this.setSpirit(1);
        this.setPlayerStats();
        this.setHp(getMaxHp());
        this.setMana(getMaxMana());

        this.inventory = new Inventory();
    }

    public int getSpirit() {
        return spirit;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }

    public void setModFamiliarXpRate() {
        modFamiliarXpRate = spirit * 2.5;
    }

    public void setModFamiliarDropRate() {
        modFamiliarXpRate = spirit * 1.3;
    }

    public void setMaxHp() {
        double hpPercent = hp / maxHp;
        if (numFamiliars < 1) {
            maxHp = (int) (90 + (vitality * 10) * modMaxHp) + robe.getModHp();
        }
        else {
            maxHp = (int) ((90 + (vitality * 10) * modMaxHp) * Math.pow(numFamiliars, 1.01)) + robe.getModHp();
        }
        int newHp = (int) (hpPercent * maxHp);
        setHp(newHp);
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxMana() {
        double manaPercent = mana / maxMana;
        if (numFamiliars < 1) {
            maxMana = (int) (90 + (magick * 10) * modMaxMana) + robe.getModMana();
        }
        else {
            maxMana = (int) ((90 + (magick * 10) * modMaxMana) * Math.pow(numFamiliars, 1.01)) + robe.getModMana();
        }
        int newMana = (int) (manaPercent * maxMana);
        setMana(newMana);
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public void setMana(int mana) { this.mana = mana; }

    public void setSpeed() {
        speed = (int)(90 + (dexterity * 10) * modSpeed) + boots.getModSpeed();
    }

    public void setAttack() {
        attack = (int)(90 + (strength * 10) * modAttack) + weapon.getModAttack();
    }

    public void setDefense() {
        defense = (int)(90 + (resistance * 10) * modDefense) + shield.getModDefense();
    }

    public void setPlayerStats() {
        setModFamiliarXpRate();
        setModFamiliarDropRate();
        setStats();
    }

}
