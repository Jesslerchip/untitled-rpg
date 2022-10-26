package net.spicefox.util;

import net.spicefox.entity.*;
import java.io.Serializable;

public class Game implements Serializable {
    private Player player;
    private Mob mob;
    public Game () {
        player = new Player("Dummy");
    }

    public void genMob() {
        mob = new Mob();
    }

    public Player getPlayer() {
        return player;
    }

    public Mob getMob() {
        return mob;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}