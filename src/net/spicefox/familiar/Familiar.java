package net.spicefox.familiar;

public class Familiar {

    private int level;
    private int xp;
    private int xpMax;

    // Modifiers
    private double modMaxHp;
    private double modMaxMana;
    private double modSpeed;
    private double modAttack;
    private double modDefense;
    private double modAccuracy;
    private double modCritChance;
    private double modSecondStrikeChance;
    private int modEvasion;

    // Level Up Methods
    public void addLevel() {
        level++;
        if (level < 5) {
            xpMax *= 3;
        }
        else {
            xp = xpMax;
        }
    }

    public void addXp(int xpGain) {
        if (level < 5) {
            xp += xpGain;
            if (xp >= xpMax) {
                addLevel();
            }
        }
    }

    // GETTERS
    public int getLevel() { return level; }
    public int getXP() { return xp; }
    public int getXPMax() { return xpMax; }
    public double getModMaxHp() { return modMaxHp; }
    public double getModMaxMana() { return modMaxMana; }
    public double getModSpeed() { return modSpeed; }
    public double getModAttack() { return modAttack; }
    public double getModDefense() { return modDefense; }
    public double getModAccuracy() { return modAccuracy; }
    public double getModCritChance() { return modCritChance; }
    public double getModSecondStrikeChance() { return modSecondStrikeChance; }
    public int getModEvasion() { return modEvasion; }

    // SETTERS
    public void setModMaxHp(double modMaxHp) { this.modMaxHp = modMaxHp; }
    public void setModMana(double modMaxMana) { this.modMaxMana = modMaxMana; }
    public void setModSpeed(double modSpeed) { this.modSpeed = modSpeed; }
    public void setModAttack(double modAttack) { this.modAttack = modAttack; }
    public void setModDefense(double modDefense) { this.modDefense = modDefense; }
    public void setModAccuracy(double modAccuracy) { this.modAccuracy = modAccuracy; }
    public void setModCritChance(double modCritChance) { this.modCritChance = modCritChance; }
    public void setModSecondStrikeChance(double modSecondStrikeChance) { this.modSecondStrikeChance = modSecondStrikeChance; }
    public void setModEvasion(int modEvasion) { this.modEvasion = modEvasion; }


}
