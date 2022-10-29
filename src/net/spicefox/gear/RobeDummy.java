package net.spicefox.gear;

public class RobeDummy extends Robe {
    public RobeDummy() {

        setDurability(0);
        setModHp(0);
        setModMana(0);

    }
    @Override
    public String toString() {
        return "Dummy robe";
    }
}
