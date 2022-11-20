package net.spicefox.gear;

public class WeaponElven extends Weapon {
    public WeaponElven() {
        setDurability(200);
        setCost(5);
        setModAccuracy(5);
        setModAttack(0);
    }
    @Override
    public String toString() {
        return "Elven Wand";
    }
}
