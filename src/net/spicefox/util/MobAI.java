package net.spicefox.util;
import net.spicefox.entity.Mob;
import net.spicefox.entity.Player;

import java.util.Random;

public class MobAI {

    static Random random = new Random();

    public static void getAction(Mob mob, Player player) {
        int randomNum = random.nextInt(2);
        switch (randomNum) {
            case 0:
                Battle.turnAttack(mob, player);
                break;
            case 1:
                Battle.turnWard(mob);
                break;
            default:
                break;
        }

    }



}
