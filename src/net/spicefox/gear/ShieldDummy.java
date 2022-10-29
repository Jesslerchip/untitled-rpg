package net.spicefox.gear;

public class ShieldDummy extends Shield{
    public ShieldDummy() {

        setDurability(0);
        setModDefense(0);
        setModWardMaxHp(15);
        setWardCost(15);

    }
    @Override
    public String toString() {
        return "Dummy shield";
    }
}
