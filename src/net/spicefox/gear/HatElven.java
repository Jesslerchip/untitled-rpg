package net.spicefox.gear;

public class HatElven extends Hat {
    public HatElven() {

        setDurability(200);
        setCost(5);
        setModSecondStrikeChance(3);
        setModCriticalChance(0);
    }
    @Override
    public String toString() {
        return "Elf Hat";
    }
}