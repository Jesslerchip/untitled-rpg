package net.spicefox.util;
import net.spicefox.entity.Mob;
import net.spicefox.entity.Player;

import java.util.Random;

public class MobAI {

    static Random random = new Random();

    public static String getAction(Mob mob, Player player) {

        int scoreAttack = genScoreAttack(mob, player);
        int scoreWard = genScoreWard(mob, player);
        String action = chooseAction(scoreAttack, scoreWard);

        return action;

    }

    public static int genScoreAttack(Mob mob, Player player) {

        int scoreAttack = 0;

        int rng = random.nextInt(51);
        scoreAttack += rng;

        if (mob.getHp() <= 0.3 * mob.getMaxHp()) { scoreAttack += 10; }
        if (mob.getAttack() * 1.1 - player.getWardHp() < 0) { scoreAttack += 20; }
        if (mob.getAttack() * 1.1 - player.getWardHp() - player.getDefense() >= player.getHp() && mob.getSpeed() >=
                player.getSpeed()) { scoreAttack += 1000; }
        else if (mob.getAttack() * 1.1 - player.getWardHp() - player.getDefense() >=
                player.getHp()) { scoreAttack += 500; }

        return scoreAttack;

    }

    public static int genScoreWard(Mob mob, Player player) {

        int scoreWard = 0;

        int rng = random.nextInt(51);
        scoreWard += rng;

        if (mob.getWardHp() >= 0.5 * mob.getWardMaxHp()) { scoreWard -= 10; }
        if (mob.getHp() >= 0.9 * mob.getMaxHp()) { scoreWard += 10; }
        if (mob.getWardHp() < (player.getAttack() * 1.1) && mob.getWardMaxHp() >=
                (player.getAttack() * 1.1) * 1.5) { scoreWard += 10; }
        if (mob.getMana() < mob.getShield().getWardCost()) { scoreWard = -1000; }

        return scoreWard;

    }

    public static String chooseAction(int scoreAttack, int scoreWard) {
        int scores[] = { scoreAttack, scoreWard };
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < scores.length; i++) {
            max = Math.max(max, scores[i]);
        }

        if (scoreAttack == max) {
            return "ATTACK";
        }
        else {
            return "WARD";
        }

    }



}
