package net.spicefox.entity;

import net.spicefox.gear.*;

import java.util.ArrayList;

public class Mob extends Entity{

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
