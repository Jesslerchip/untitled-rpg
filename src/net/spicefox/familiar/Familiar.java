package net.spicefox.familiar;

public class Familiar {

    private int level = 1;
    private int xp = 0;
    private int xpMax = 20;

    // HP, Mana, Speed, Damage, Defense, Accuracy Modifiers
    private double[] modifiers = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0};

    // Flags
    private boolean isUnlocked = false;

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
