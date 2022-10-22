package net.spicefox.gear;

public class Shield {

    private int durability;
    private int modDefense;
    private int modCost;


    // Getters
    public int getDurability() { return durability; }

    public int getModMana() { return modDefense; }

    public int getModAttack() { return modCost; }


    // Setters
    public void setDurability(int damage) { durability -= damage; }

}