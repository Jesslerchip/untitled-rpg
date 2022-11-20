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
        }
    }

    public void removeEquipment(Equippable item) {
        if (equipment.contains(item)) {
            equipment.remove(item);
        }
    }

    public Equippable getEquipmentAtIndex (int index) {
        return equipment.get(index);
    }

    public int getSize () {
        return equipment.size();
    }

    public boolean equipmentHas(Equippable item) {
        return equipment.contains(item);
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
