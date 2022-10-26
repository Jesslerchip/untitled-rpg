package net.spicefox.util;

import net.spicefox.entity.*;

public class Battle {
    //Obviously will not function like this in final version; this is for testing purposes
    public static void playerTurnAttack(Player player, Mob mob) {
        mob.setHp(mob.getHp() - 1);
    }

    public static void playerTurnShield(Player player, Mob mob) {

    }

    public static void playerTurnPotion(Player player, Mob mob) {

    }

    public static void playerTurnFamiliar(Player player, Mob mob) {

    }
}
