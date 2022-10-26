package net.spicefox.util;

import net.spicefox.entity.*;

public class Battle {
    public static void playerTurnAttack(Player player, Mob mob) {
        player.setHp(player.getHp() - 1);
    }

    public static void playerTurnShield(Player player, Mob mob) {

    }

    public static void playerTurnPotion(Player player, Mob mob) {

    }

    public static void playerTurnFamiliar(Player player, Mob mob) {

    }
}
