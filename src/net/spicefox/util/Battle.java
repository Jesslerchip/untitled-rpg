package net.spicefox.util;

import net.spicefox.entity.*;
import net.spicefox.familiar.Familiar;
import net.spicefox.familiar.FamiliarKutesune;
import net.spicefox.potions.Consumable;

import java.util.Random;

public class Battle {
    //Obviously will not function like this in final version; this is for testing purposes

    private Player player;
    private Mob mob;

    static Random random = new Random();

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

    public void takeTurn(Entity attacker, Entity defender, String action) {
        switch (action) {
            case "ATTACK":
                // Second Strike roll
                int secondStrikeCheck = random.nextInt(0, 100);
                if (secondStrikeCheck <= attacker.getSecondStrikeChance()) {
                    turnAttack(attacker, defender);
                    System.out.println(attacker.getName() + " moved quickly and got a Second Strike!");
                }
                turnAttack(attacker, defender);
                break;
            case "WARD":
                turnWard(attacker);
                break;
            case "POTION":
                turnPotion(attacker);
                break;
            default:
                break;
        }
    }

    public static void turnAttack(Entity attacker, Entity defender) {
        int damage = (int) (attacker.getAttack() * 1.1);

        int accuracyCheck = random.nextInt(0, 100 + defender.getEvasion());
        if (accuracyCheck <= attacker.getAccuracy()) {
            if (defender.getWardHp() > 0) {
                int wardHp = defender.getWardHp();
                defender.setWardHp(wardHp - damage);
                if (defender.getWardHp() < 0) {
                    defender.setWardHp(0);
                    System.out.println(defender.getName() + "'s Ward has dissipated!");
                }
                damage -= wardHp;
            }

            if (damage > 0) {
                int criticalCheck = random.nextInt(0, 100);
                if (criticalCheck <= attacker.getCritChance()) {
                    damage *= 2;
                    System.out.println(attacker.getName() + " got a critical hit!");
                }
                damage -= defender.getDefense();
                if (damage < 1) {
                    damage = 1;
                }
                defender.setHp(defender.getHp() - damage);
            }

            damageGear(attacker, defender, damage);
        }
        else {
            System.out.println(attacker.getName() + "'s attack missed!");
        }
    }

    public static void turnWard(Entity attacker) {

        attacker.setWardHp(attacker.getWardMaxHp());
        attacker.setMana(attacker.getMana() - attacker.getWardCost());
        System.out.println(attacker.getName() + " cast a Ward!");

    }

    public static void turnPotion(Entity attacker) {
        Consumable c = attacker.getInventory().getFromSatchel("HEALTH POTION");
        if (c == null) { return; }
        if (c.getEffectType().equals("HEAL")) {
            attacker.setHp(attacker.getHp() + c.getEffectMod());
        }
    }

    public static void turnFamiliar(Player player, Familiar familiar) {
        player.setActiveFamiliar(familiar);
        player.setFamiliarTimer(3);
        player.setMana(player.getMana() - player.getActiveFamiliar().getCost());
        player.setPlayerStats();
        System.out.println(player.getName() + " summoned " + familiar.getName() + "!");
    }

    private static void damageGear(Entity attacker, Entity defender, int damage) {
        defender.getBoots().setDurability(defender.getBoots().getDurability() - damage);
        defender.getRobe().setDurability(defender.getRobe().getDurability() - damage);
        defender.getHat().setDurability(defender.getHat().getDurability() - damage);
        defender.getShield().setDurability(defender.getShield().getDurability() - damage);
        attacker.getWeapon().setDurability(attacker.getWeapon().getDurability() - damage);
    }

    public static void endTurn(Player player, Mob mob) {
        player.setMana(player.getMana() + (int) (player.getMaxMana() / 10));
        if (player.getMana() > player.getMaxMana()) {
            player.setMana(player.getMaxMana());
        }
        mob.setMana(mob.getMana() + (int) (mob.getMaxMana() / 10));
        if (mob.getMana() > mob.getMaxMana()) {
            mob.setMana(mob.getMaxMana());
        }
        if (player.getFamiliarTimer() != 0) {
            player.setFamiliarTimer(player.getFamiliarTimer() - 1);
            if (player.getFamiliarTimer() == 0) {
                System.out.println(player.getName() + "'s " + player.getActiveFamiliar().getName() + " disappeared!");
                player.setActiveFamiliar(null);
            }
        }
    }

}
