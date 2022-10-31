package net.spicefox.gear;

public class ShieldDefault extends Shield{
    public ShieldDefault() {

        setDurability(0);
        setModDefense(0);
        setModWardMaxHp(15);
        setModWardCost(0);

    }
    @Override
    public String toString() {
        return "None";
    }
}
