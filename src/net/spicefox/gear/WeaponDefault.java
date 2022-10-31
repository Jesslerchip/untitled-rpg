package net.spicefox.gear;

public class WeaponDefault extends Weapon {
    public WeaponDefault() {
        setDurability(0);
        setModAccuracy(0);
        setModAttack(0);
    }
    @Override
    public String toString() {
        return "None";
    }
}
