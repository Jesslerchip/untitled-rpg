package net.spicefox.util;

import net.spicefox.entity.*;

public class Battle {
    //Obviously will not function like this in final version; this is for testing purposes

    private Player player;
    private Mob mob;

    public Battle(Player player, Mob mob) {
        this.player = player;
        this.mob = mob;
    }

    public boolean isPlayerFirst() {
        if (player.getSpeed() > mob.getSpeed()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void playerTurn(String action) {
        switch (action) {
            case "ATTACK":
                turnAttack(player, mob);
                break;
            case "WARD":
                turnWard(player);
            default:
                break;
        }
    }

    public static void turnAttack(Entity attacker, Entity defender) {
        int damage = (int) (attacker.getAttack() * 1.1);

        if (defender.getWardHp() > 0) {
            int wardHp = defender.getWardHp();
            defender.setWardHp(wardHp - damage);
            damage -= wardHp;
        }

        if (damage > 0) {
            damage -= defender.getDefense();
            if (damage < 1) {
                damage = 1;
            }
            defender.setHp(defender.getHp() - damage);
        }

        damageGear(attacker, defender, damage);
    }

    public static void turnWard(Entity attacker) {

        attacker.setWardMaxHP();
        attacker.setMana(attacker.getMana() - attacker.getShield().getWardCost());
        System.out.println(attacker.getName() + " cast a Ward!");

    }

    public static void turnPotion(Entity attacker, Entity defender) {

    }

    public static void turnFamiliar(Entity attacker, Entity defender) {

    }

    private static void damageGear(Entity attacker, Entity defender, int damage) {
        defender.getBoots().setDurability(defender.getBoots().getDurability() - damage);
        defender.getRobe().setDurability(defender.getRobe().getDurability() - damage);
        defender.getHat().setDurability(defender.getHat().getDurability() - damage);
        defender.getShield().setDurability(defender.getShield().getDurability() - damage);
        attacker.getWeapon().setDurability(attacker.getWeapon().getDurability() - damage);
    }

}
