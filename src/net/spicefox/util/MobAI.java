package net.spicefox.util;
import net.spicefox.entity.Mob;
import net.spicefox.entity.Player;

public class MobAI {

    public static void getAction(Mob mob, Player player) {
         Battle.turnAttack(mob, player);
    }

}
