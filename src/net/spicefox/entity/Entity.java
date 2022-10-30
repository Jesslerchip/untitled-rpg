package net.spicefox.entity;

import net.spicefox.gear.*;
import net.spicefox.inventory.Inventory;
import net.spicefox.potions.Consumable;

public abstract class Entity {
    private String name;

    // Stats
    int maxHp;
    int hp;
    int maxMana;
    int mana;
    int speed;
    int attack;
    int defense;
    private int accuracy;
    private int critChance;
    private int secondStrikeChance;
    private int evasion;

    // Skills
    int vitality;
    int magick;
    int dexterity;
    int strength;
    int resistance;
    private int focus;

    // Gear
    Boots boots;
    Robe robe;
    private Hat hat;
    Shield shield;
    Weapon weapon;

    int wardMaxHp;
    int wardHp;

    // Modifiers
    double modMaxHp;
    double modMaxMana;
    double modSpeed;
    double modAttack;
    double modDefense;
    private double modAccuracy;
    private double modCritChance;
    private double modSecondStrikeChance;

    // Gets added rather than multiplied
    private int modEvasion;

    Inventory inventory;

    // GETTERS
    public String getName() { return name; }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxMana() {
        return maxMana;
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

    public int getAccuracy() {
        return accuracy;
    }

    public int getCritChance() {
        return critChance;
    }

    public int getSecondStrikeChance() { return secondStrikeChance; }

    public int getEvasion() { return evasion; }

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

    public Boots getBoots() { return this.boots; }

    public Robe getRobe() {
        return this.robe;
    }

    public Hat getHat() { return this.hat; }

    public Shield getShield() {
        return shield;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getWardMaxHp() { return wardMaxHp; }
    public int getWardHp() { return wardHp; }

    public double getModMaxHp() { return modMaxHp; }
    public double getModMaxMana() { return modMaxMana; }
    public double getModSpeed() { return modSpeed; }
    public double getModAttack() { return modAttack; }
    public double getModDefense() { return modDefense; }
    public double getModAccuracy() { return modAccuracy; }
    public double getModCritChance() { return modCritChance; }

    public double getModSecondStrikeChance() { return modSecondStrikeChance; }

    public double getModEvasion() { return modEvasion; }


    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHp() {
        double hpPercent = hp / maxHp;
        maxHp = (int)(90 + (vitality * 10) * modMaxHp) + robe.getModHp();
        int newHp = (int) (hpPercent * maxHp);
        setHp(newHp);
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxMana() {
        double manaPercent = mana / maxMana;
        maxMana = (int)(90 + (magick * 10) * modMaxMana) + robe.getModMana();
        int newMana = (int) (manaPercent * maxMana);
        setMana(newMana);
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public void setMana(int mana) { this.mana = mana; }

    public void setSpeed() {
        speed = (int)(90 + (dexterity * 10) * modSpeed) + boots.getModSpeed();
    }

    public void setAttack() {
        attack = (int)(90 + (strength * 10) * modAttack) + weapon.getModAttack();
    }

    public void setDefense() {
        defense = (int)(90 + (resistance * 10) * modDefense) + shield.getModDefense();
    }

    public void setAccuracy() {
        accuracy = (int)(65 + (focus * 5) * modAccuracy) + weapon.getModAccuracy();
    }

    public void setCritChance() {
        critChance = focus + hat.getModCriticalChance();
    }

    public void setSecondStrikeChance() {
        secondStrikeChance = dexterity + hat.getModSecondStrikeChance() ;
    }

    public void setEvasion() { evasion = boots.getModEvasion() + modEvasion; }

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

    public void setHat(Hat hat) {
        this.hat = hat;
    }

    public void setRobe(Robe robe) {
        this.robe = robe;
    }

    public void setBoots(Boots boots) {
        this.boots = boots;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public void setWardMaxHP() {
        wardMaxHp = defense + shield.getModWardMaxHp();
        wardHp = wardMaxHp;
    }
    public void setWardHp(int wardHp) { this.wardHp = wardHp; }
    public void setModMaxHp() { this.modMaxHp = 1; }
    public void setModMaxMana() { this.modMaxMana = 1; }
    public void setModSpeed() { this.modSpeed = 1; }
    public void setModAttack() { this.modAttack = 1; }
    public void setModDefense() { this.modDefense = 1; }
    public void setModAccuracy() { this.modAccuracy = 1; }
    public void setModCritChance() { this.modCritChance = 1; }
    public void setModSecondStrikeChance() { this.modSecondStrikeChance = 1; }
    public void setModEvasion() { this.modEvasion = 0; }

    public void setStats() {
        setModMaxHp();
        setModMaxMana();
        setModSpeed();
        setModAttack();
        setModDefense();
        setModAccuracy();
        setModCritChance();
        setModSecondStrikeChance();
        setModEvasion();
        setMaxHp();
        setMaxMana();
        setSpeed();
        setAttack();
        setDefense();
        setAccuracy();
        setCritChance();
        setSecondStrikeChance();
        setEvasion();
    }

    // MISC
    public void changeHp(int change) {
        this.hp += change;
    }
    public void changeMana(int change) { this.mana += change; }

    public Inventory getInventory() {
        return inventory;
    }

    //Add gear
    public void addToInventory(Equippable item) {
        inventory.addToEquipment(item);
    }

    //Add potion
    public void addToInventory(String item) {
        inventory.addToSatchel(item);
    }
}
