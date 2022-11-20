package net.spicefox.gear;

public class ShieldElven extends Shield{
    public ShieldElven() {

        setDurability(200);
        setCost(10);
        setModDefense(1);
        setModWardMaxHp(5);
        setModWardCost(2);

    }
    @Override
    public String toString() {
        return "Elven Shield";
    }
}
