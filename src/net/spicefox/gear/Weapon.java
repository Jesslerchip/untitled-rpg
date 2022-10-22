package net.spicefox.gear;

public class Weapon {

    private int durability;
    private int modMana;
    private int modAttack;


    // Getters
    public int getDurability() { return durability; }

    public int getModMana() { return modMana; }

    public int getModAttack() { return modAttack; }


    // Setters
    public void setDurability(int damage) { durability -= damage; }

}