package net.spicefox.gear;

public class HatDefault extends Hat {
    public HatDefault() {

        setDurability(0);
        setModSecondStrikeChance(0);
        setModCriticalChance(0);
    }
    @Override
    public String toString() {
        return "None";
    }
}
