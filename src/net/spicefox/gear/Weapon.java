package net.spicefox.gear;

public class Weapon {

    private int durability;
    private int modAttack;
    private int modAccuracy;


    // Getters
    public int getDurability() { return durability; }

    public int getModAccuracy() { return modAccuracy; }

    public int getModAttack() { return modAttack; }


    // Setters
    public void setDurability(int durability) { this.durability = durability; }
    public void setModAccuracy(int modAccuracy) { this.modAccuracy = modAccuracy; }
    public void setModAttack(int modAttack) { this.modAttack = modAttack; }
    public void changeDurability(int damage) { durability -= damage; }
}