package net.spicefox.gear;

public class Robe {

    private int durability;
    private int modHP;
    private int modSpeed;


    // Getters
    public int getDurability() { return durability; }

    public int getModHP() { return modHP; }

    public int getModSpeed() { return modSpeed; }


    // Setters
    public void setDurability(int damage) { durability -= damage; }

}
