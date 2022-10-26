package net.spicefox.util;

import net.spicefox.entity.*;
import java.io.Serializable;

public class Game implements Serializable {
    private Player player;
    private Mob mob;
    private Battle battle;

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

    public Battle getBattle() { return battle; }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setBattle() {

    }

    public void battleInit() {
        genMob();
        battle = new Battle(player, mob);
    }

}