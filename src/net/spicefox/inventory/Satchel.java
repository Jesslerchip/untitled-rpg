package net.spicefox.inventory;

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
        satchel.put(healthPotion, 0);
    }

    public void addToSatchel(String item) {
        switch (item) {
            case "HEALTH POTION":
                satchel.put(healthPotion, satchel.get(healthPotion) + 1);
                break;
            default:
                break;
        }
    }

    public Consumable takeFromSatchel(String item) {
        switch (item) {
            case "HEALTH POTION":
                satchel.put(healthPotion, satchel.get(healthPotion) - 1);
                return healthPotion;
            default:
                return null;
        }
    }

    public boolean satchelHas(String item) {
        switch (item) {
            case "HEALTH POTION":
                if (satchel.get(healthPotion) > 0) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        String returnString = "";
        for (Consumable c : satchel.keySet()) {
            if (satchel.get(c) > 0) {
                returnString += c + " x" + satchel.get(c) + "\n";
            }
        }
        return returnString;
    }

}
