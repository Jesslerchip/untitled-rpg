package net.spicefox.entity;

public abstract class Entity {
    private String name;
    private int hp, mana, speed, attack, defense;
    private int vitality, magick, dexterity, strength, resistance, focus;
    private double critChance;

    // TODO: add gear

    // GETTERS
    public String getName() { return name; }

    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getVitality() {
        return vitality;
    }

    public int getMagick() {
        return magick;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public int getResistance() {
        return resistance;
    }

    public int getFocus() {
        return focus;
    }

    public double getCritChance() {
        return critChance;
    }


    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public void setMagick(int magick) {
        this.magick = magick;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }
}
