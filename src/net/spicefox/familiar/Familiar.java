package net.spicefox.familiar;

public class Familiar {

    private int level;
    private int xp;
    private int xpMax;

    // Modifiers
    private double modHP;
    private double modMana;
    private double modSpeed;
    private double modAttack;
    private double modDefense;
    private double modAccuracy;
    private double modCritChance;

    // Flags
    private boolean isUnlocked;

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
    public double getModHP() { return this.modHP; }
    public double getModMana() { return this.modMana; }
    public double getModSpeed() { return this.modSpeed; }
    public double getModAttack() { return this.modAttack; }
    public double getModDefense() { return this.modDefense; }
    public double getModAccuracy() { return this.modAccuracy; }
    public double getModCritChance() { return this.modCritChance; }

    // SETTERS
    public void setModHP(double modHP) { this.modHP = modHP; }
    public void setModMana(double modMana) { this.modMana = modMana; }
    public void setModSpeed(double modSpeed) { this.modSpeed = modSpeed; }
    public void setModAttack(double modAttack) { this.modAttack = modAttack; }
    public void setModDefense(double modDefense) { this.modDefense = modDefense; }
    public void setModAccuracy(double modAccuracy) { this.modAccuracy = modAccuracy; }
    public void setModCritChance(double modCritChance) { this.modCritChance = modCritChance; }


}
