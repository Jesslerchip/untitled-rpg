package net.spicefox.inventory;

import net.spicefox.gear.Equippable;
import net.spicefox.potions.Consumable;

public class Inventory {
    private Satchel satchel;
    private Equipment equipment;

    public Inventory() {
        satchel = new Satchel();
        equipment = new Equipment();
    }

    public void addToSatchel(String item) {
        satchel.addToSatchel(item);
    }

    public void addToEquipment(Equippable item) {
        equipment.addEquipment(item);
    }

    public Consumable getFromSatchel(String item) {
        if (satchel.satchelHas(item)) {
            return satchel.takeFromSatchel(item);
        } else {
            return null;
        }
    }

    public void printInventory() {
        System.out.println(satchel + "\n" + equipment);
    }
}
