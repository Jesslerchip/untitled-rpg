package net.spicefox.inventory;

import net.spicefox.gear.*;

import java.util.ArrayList;

public class Equipment {
    private int size;
    private ArrayList<Equippable> equipment;

    public Equipment() {
        size = 10;
        equipment = new ArrayList<>();
    }

    public void addEquipment(Equippable item) {
        if (equipment.size() < size) {
            equipment.add(item);
            size++;
        }
    }

    @Override
    public String toString() {
        String returnString = "";
        for (Equippable e : equipment) {
            returnString += e + ", " + e.getDurability() + "\n";
        }
        return returnString;
    }
}
