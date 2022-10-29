package net.spicefox.potions;

public class Potion {
  private int heal;

  public Potion() {
      heal = 25;
  }

  public int getHeal() {
      return heal;
  }

  @Override
  public String toString() {
      return "Health Potion";
  }
}
