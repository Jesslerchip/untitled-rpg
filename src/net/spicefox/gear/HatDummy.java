package net.spicefox.gear;

public class HatDummy extends Hat {
    public HatDummy() {

        setDurability(0);
        setModSecondStrikeChance(0);
        setModCriticalChance(0);
    }
    @Override
    public String toString() {
        return "None";
    }
}
