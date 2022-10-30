package net.spicefox.util;

import net.spicefox.entity.*;
import java.io.Serializable;

public class Game implements Serializable {
    private Player player;
    private Mob mob;
    private Battle battle;

    public Game () {
        player = new Player();
    }

    // TODO: Take in location and select from a list of available mobs
    public void genMob() {
        mob = new MobKutesune();
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