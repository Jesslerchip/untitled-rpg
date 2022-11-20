package net.spicefox.gear;

public class ShieldDefault extends Shield{
    public ShieldDefault() {

        setDurability(0);
        setCost(0);
        setModDefense(0);
        setModWardMaxHp(0);
        setModWardCost(0);

    }
    @Override
    public String toString() {
        return "Default Shield";
    }
}
