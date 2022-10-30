package net.spicefox.util;

import net.spicefox.potions.*;

import java.util.HashMap;

public class Satchel {
    private int size;
    private HashMap<Consumable, Integer> satchel;
    private HealthPotion healthPotion;
    public Satchel() {
        size = 1;
        satchel = new HashMap<>();
        healthPotion = new HealthPotion();
    }

}
