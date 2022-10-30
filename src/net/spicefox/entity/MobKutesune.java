package net.spicefox.entity;

public class MobKutesune extends Mob {

    public MobKutesune() {
        setName("Kutesune");
        setKutesuneSkills();
        setStats();
        behavior = "CUTE";
        setDropChanceFamiliar(100);
        setDropBits(2);
        setDropXP(2);
    }

    public void setKutesuneSkills() {
        setVitality(0);
        setMagick(0);
        setDexterity(1);
        setStrength(1);
        setResistance(0);
        setFocus(0);
    }

}
