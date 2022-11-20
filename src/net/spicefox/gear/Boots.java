package net.spicefox.gear;

public class Boots implements Equippable {

    private int durability;
    private int cost;
    private int modSpeed;

    private int modEvasion;


    // Getters
    public int getDurability() { return durability; }
    public int getCost() { return cost; }
    public int getModSpeed() { return modSpeed; }

    public int getModEvasion() { return modEvasion; }


    // Setters
    public void setDurability(int durability) { this.durability = durability; }
    public void setCost(int cost) { this.cost = cost; }
    public void setModSpeed(int modSpeed) { this.modSpeed = modSpeed; }
    public void setModEvasion(int modEvasion) { this.modEvasion = modEvasion; }

    public void changeDurability(int damage) { durability -= damage; }

}
