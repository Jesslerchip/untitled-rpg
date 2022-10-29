package net.spicefox.gear;

public class BootsDummy extends Boots {
    public BootsDummy() {

        setDurability(0);
        setModSpeed(0);
        setModEvasion(0);

    }
    @Override
    public String toString() {
        return "Dummy boots";
    }
}
