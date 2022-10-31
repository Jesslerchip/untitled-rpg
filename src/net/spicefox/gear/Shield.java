package net.spicefox.gear;

public class Shield implements Equippable {

    private int durability;
    private int modDefense;
    private int modWardMaxHp;
    private int modWardCost;


    // Getters
    public int getDurability() { return durability; }

    public int getModDefense() { return modDefense; }

    public int getModWardMaxHp() { return modWardMaxHp; }

    public int getModWardCost() { return modWardCost; }


    // Setters
    public void setDurability(int durability) { this.durability = durability; }
    public void setModDefense(int modDefense) { this.modDefense = modDefense; }
    public void setModWardMaxHp(int modWardMaxHp) { this.modWardMaxHp = modWardMaxHp; }
    public void setModWardCost(int wardCost) { this.modWardCost = wardCost; }

    public void changeDurability(int damage) { durability -= damage; }

}