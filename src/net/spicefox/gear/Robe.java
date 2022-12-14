package net.spicefox.gear;

public class Robe implements Equippable {

    private int durability;
    private int cost;
    private int modHp;
    private int modMana;


    // Getters
    public int getDurability() { return durability; }
    public int getCost() { return cost; }
    public int getModHp() { return modHp; }
    public int getModMana() { return modMana; }


    // Setters
    public void setDurability(int durability) { this.durability = durability; }
    public void setCost(int cost) { this.cost = cost; }
    public void setModHp(int modHp) { this.modHp = modHp; }
    public void setModMana(int modMana) { this.modMana = modMana; }

    public void changeDurability(int damage) { durability -= damage; }

}
