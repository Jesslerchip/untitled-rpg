package net.spicefox.util;

import net.spicefox.entity.*;

public class Battle {
    //Obviously will not function like this in final version; this is for testing purposes

    public static boolean getTurnOrder(Player player, Mob mob) {
        if (player.getSpeed() > mob.getSpeed()) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void takeTurn(Entity attacker, Entity defender, String action) {
        switch (action) {
            case "ATTACK":
                turnAttack(attacker, defender);
                break;
            default:
                break;
        }
    }

    public static void turnAttack(Entity attacker, Entity defender) {

        int damage = (int) (attacker.getAttack() * 1.1 - defender.getDefense());
        if (damage < 1) {
            damage = 1;
        }
        // TODO: Make method to change all gear durabilities on use
        damageGear(attacker, defender, damage);
    }

    public static void turnShield(Entity attacker, Entity defender) {

    }

    public static void turnPotion(Entity attacker, Entity defender) {

    }

    public static void turnFamiliar(Entity attacker, Entity defender) {

    }

    private static void damageGear(Entity attacker, Entity defender, int damage) {
        defender.setHp(defender.getHp() - damage);
        defender.getBoots().setDurability(defender.getBoots().getDurability() - damage);
        defender.getRobe().setDurability(defender.getRobe().getDurability() - damage);
        defender.getHat().setDurability(defender.getHat().getDurability() - damage);
        attacker.getWeapon().setDurability(attacker.getWeapon().getDurability() - damage);
    }

}
