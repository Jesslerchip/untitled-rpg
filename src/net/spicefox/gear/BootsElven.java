package net.spicefox.gear;

public class BootsElven extends Boots {
    public BootsElven() {

        setDurability(200);
        setCost(5);
        setModSpeed(2);
        setModEvasion(1);

    }
    @Override
    public String toString() {
        return "Elven Boots";
    }
}
