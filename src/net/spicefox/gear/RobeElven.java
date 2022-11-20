package net.spicefox.gear;

public class RobeElven extends Robe {
    public RobeElven() {

        setDurability(200);
        setCost(5);
        setModHp(0);
        setModMana(10);

    }
    @Override
    public String toString() {
        return "Elf Robe";
    }
}
