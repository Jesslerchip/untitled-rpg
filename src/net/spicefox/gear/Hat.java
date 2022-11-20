package net.spicefox.gear;

public class Hat implements Equippable {

    private int durability;
    private int cost;
    private int modSecondStrikeChance;
    private int modCriticalChance;


    // Getters
    public int getDurability() { return durability; }
    public int getCost() { return cost; }

    public int getModSecondStrikeChance() { return modSecondStrikeChance; }

    public int getModCriticalChance() { return modCriticalChance; }


    // Setters
    public void setDurability(int durability) { this.durability = durability; }
    public void setCost(int cost) { this.cost = cost; }
    public void setModSecondStrikeChance(int modSecondStrikeChance) { this.modSecondStrikeChance = modSecondStrikeChance; }
    public void setModCriticalChance(int modCriticalChance) { this.modCriticalChance = modCriticalChance; }
    public void changeDurability(int damage) { durability -= damage; }

}
