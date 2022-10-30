package net.spicefox.util;

import java.util.HashMap;

public class Inventory {
    private Satchel satchel;
    private Equipment equipment;

    public Inventory() {
        satchel = new Satchel();
        equipment = new Equipment();
    }

}
