package net.spicefox.gear;

public class Hat implements Equippable {

    private int durability;
    private int modSecondStrikeChance;
    private int modCriticalChance;


    // Getters
    public int getDurability() { return durability; }

    public int getModSecondStrikeChance() { return modSecondStrikeChance; }

    public int getModCriticalChance() { return modCriticalChance; }


    // Setters
    public void setDurability(int durability) { this.durability = durability; }
    public void setModSecondStrikeChance(int modSecondStrikeChance) { this.modSecondStrikeChance = modSecondStrikeChance; }
    public void setModCriticalChance(int modCriticalChance) { this.modCriticalChance = modCriticalChance; }

    public void changeDurability(int damage) { durability -= damage; }

}
