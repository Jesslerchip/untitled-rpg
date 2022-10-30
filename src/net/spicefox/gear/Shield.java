package net.spicefox.gear;

public class Shield implements Equippable {

    private int durability;
    private int modDefense;
    private int modWardMaxHp;
    private int wardCost;


    // Getters
    public int getDurability() { return durability; }

    public int getModDefense() { return modDefense; }

    public int getModWardMaxHp() { return modWardMaxHp; }

    public int getWardCost() { return wardCost; }


    // Setters
    public void setDurability(int durability) { this.durability = durability; }
    public void setModDefense(int modDefense) { this.modDefense = modDefense; }
    public void setModWardMaxHp(int modWardMaxHp) { this.modWardMaxHp = modWardMaxHp; }
    public void setWardCost(int wardCost) { this.wardCost = wardCost; }

    public void changeDurability(int damage) { durability -= damage; }

}