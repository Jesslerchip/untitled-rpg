package net.spicefox.entity;

import net.spicefox.familiar.Familiar;
import net.spicefox.gear.*;

import java.util.ArrayList;

public class Mob extends Entity{

    private double dropChanceFamiliar;
    private int dropBits;
    private int dropXP;

    private Familiar familiarDrop;
    ArrayList<Boots> bootsList = new ArrayList<>();
    ArrayList<Robe> robeList = new ArrayList<>();
    ArrayList<Hat> hatList = new ArrayList<>();
    ArrayList<Shield> shieldList = new ArrayList<>();
    ArrayList<Weapon> weaponList = new ArrayList<>();

    String behavior;

    // TODO: Should take in location and pull mob type from the appropriate list
    public Mob() {
        setName("Dummy");
        bootsList.add(new BootsDummy());
        robeList.add(new RobeDummy());
        hatList.add(new HatDummy());
        shieldList.add(new ShieldDummy());
        weaponList.add(new WeaponDummy());
        setDropChanceFamiliar(0);
        setDropBits(0);
        setDropXP(0);
        setFamiliarDrop(new Familiar());
    }

    // Getters
    public double getDropChanceFamiliar() { return dropChanceFamiliar; }
    public int getDropBits() { return dropBits; }
    public int getDropXP() { return dropXP; }
    public String getBehavior() { return behavior; }
    public Familiar getFamiliarDrop() { return familiarDrop; }

    // Setters
    public void setDropChanceFamiliar(int dropChanceFamiliar) {
        this.dropChanceFamiliar = dropChanceFamiliar;
    }
    public void setDropBits(int dropBits) {
        this.dropBits = dropBits;
    }
    public void setDropXP(int dropXP) {
        this.dropXP = dropXP;
    }
    public void setFamiliarDrop(Familiar familiarDrop) { this.familiarDrop = familiarDrop; }

}
