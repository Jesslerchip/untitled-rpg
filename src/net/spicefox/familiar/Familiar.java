package net.spicefox.familiar;

public class Familiar {

    private int level;
    private int xp;
    private int xpMax;

    // HP, Mana, Speed, Damage, Defense, Accuracy Modifiers
    private double[] modifiers;

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

    // Getters
    public int getLevel() { return level; }

    public int getXP() { return xp; }

    public int getXPMax() { return xpMax; }

}
