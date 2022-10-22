package net.spicefox.entity;

import net.spicefox.gear.*;

public class Player extends Entity{
    private int spirit;

    private Robe robe;
    private Shield shield;
    private Weapon weapon;

    public Player() {

    }

    public int getSpirit() {
        return spirit;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }

    public Robe getRobe() {
        return robe;
    }

    public void setRobe(Robe robe) {
        this.robe = robe;
    }
    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

}
