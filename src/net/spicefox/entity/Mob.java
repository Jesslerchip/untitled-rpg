package net.spicefox.entity;

import net.spicefox.gear.*;

import java.util.ArrayList;

public class Mob extends Entity{

    // TODO: Should take in location and pull mob type from the appropriate list
    public Mob() {
        setMaxHp(1);
        setHp(getMaxHp());
        setMaxMana(1);
        setMana(getMaxMana());
        this.setName("Dummy");
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
        this.setStats();
        this.setHp(getMaxHp());
        this.setMana(getMaxMana());
    }

    private double dropChanceFamiliar;
    private int dropBits;
    private int dropXP;
    private ArrayList<Robe> robeList = new ArrayList<>();
    private ArrayList<Shield> shieldList = new ArrayList<>();
    private ArrayList<Weapon> weaponList = new ArrayList<>();

    // Getters
    public double getDropChanceFamiliar() { return dropChanceFamiliar; }

    public int getDropBits() { return dropBits; }

    public int getDropXP() { return dropXP; }

    public ArrayList<Robe> getRobeList() { return robeList; }
    public ArrayList<Shield> getShieldList() { return shieldList; }
    public ArrayList<Weapon> getWeaponList() { return weaponList; }

}
