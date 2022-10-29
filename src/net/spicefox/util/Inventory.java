package net.spicefox.util;

import java.util.HashMap;

public class Inventory {
    private HashMap<Object, Integer> inventory;
    private int size;

    public Inventory() {
        inventory = new HashMap<>();
        size = 0;
    }

    //Adds an object to inventory: increments stack if existing, or creates new key-value pair with 1 item if not
    public void addItem(Object o) {
        inventory.put(o, inventory.getOrDefault(o, 0) + 1);
        size++;
    }

    public void removeItem(Object o) {
        if (inventory.get(o) != null) {
            if (inventory.get(o) == 1) {
                inventory.remove(o);
            } else {
                inventory.put(o, inventory.get(o) - 1);
            }
        }
    }

    //Print out every item in inventory
    public void iterate() {
        for (Object key : inventory.keySet()) {
            System.out.println(key + ", " + inventory.get(key));
        }
    }

    //Number of items in inventory
    public int getSize() {
        System.out.println(size + " items in inventory");
        return size;
    }

}
