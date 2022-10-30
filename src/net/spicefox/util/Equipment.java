package net.spicefox.util;

import net.spicefox.gear.Equippable;

import java.util.ArrayList;

public class Equipment {
    private int size;
    private ArrayList<Equippable> equipment;

    public Equipment() {
        size = 10;
        equipment = new ArrayList<>();
    }

}
