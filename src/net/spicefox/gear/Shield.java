package net.spicefox.gear;

public class Shield {

    private int durability;
    private int modDefense;
    private int cost;


    // Getters
    public int getDurability() { return durability; }

    public int getModDefense() { return modDefense; }

    public int getCost() { return cost; }


    // Setters
    public void setDurability(int durability) { this.durability = durability; }
    public void setModDefense(int modDefense) { this.modDefense = modDefense; }
    public void setCost(int cost) { this.cost = cost; }

    public void changeDurability(int damage) { durability -= damage; }

}