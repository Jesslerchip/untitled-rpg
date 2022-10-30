package net.spicefox.gear;

public class WeaponDummy extends Weapon {
    public WeaponDummy() {
        setDurability(0);
        setModAccuracy(0);
        setModAttack(0);
    }
    @Override
    public String toString() {
        return "None";
    }
}
