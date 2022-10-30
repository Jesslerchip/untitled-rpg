package net.spicefox.potions;

public class HealthPotion implements Consumable {
    private String effectType;
    private int effectMod;

    public HealthPotion() {
        effectType = "HEAL";
        effectMod = 25;
    }

    public int getEffectMod() {
        return effectMod;
    }

    public String getEffectType() {
        return effectType;
    }

    @Override
    public String toString() {
        return "HEALTH POTION";
    }
}
