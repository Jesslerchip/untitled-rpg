package net.spicefox.gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import net.spicefox.entity.*;

public class PanelBattle extends JPanel {
    private JButton attackButton;
    private JButton shieldButton;
    private JButton potionButton;
    private JButton familiarButton;

    private JLabel playerHPLabel;
    private JLabel playerManaLabel;
    private JLabel mobHPLabel;
    private JLabel mobManaLabel;

    public PanelBattle() {

        // Buttons
        attackButton = new JButton("Attack");
        shieldButton = new JButton("Shield");
        potionButton = new JButton("Potion");
        familiarButton = new JButton("Familiar");
        attackButton.setFocusable(false);
        shieldButton.setFocusable(false);
        potionButton.setFocusable(false);
        familiarButton.setFocusable(false);
        attackButton.setActionCommand("ATTACK");
        shieldButton.setActionCommand("SHIELD");
        potionButton.setActionCommand("POTION");
        familiarButton.setActionCommand("FAMILIAR_SUMMON");

        // Labels
        playerHPLabel = new JLabel();
        playerManaLabel = new JLabel();
        mobHPLabel = new JLabel();
        mobManaLabel = new JLabel();

        this.add(attackButton);
        this.add(shieldButton);
        this.add(potionButton);
        this.add(familiarButton);
        this.add(playerHPLabel);
        this.add(playerManaLabel);
        this.add(mobHPLabel);
        this.add(mobManaLabel);
    }

    public void addPanelListener(ActionListener listener) {
        attackButton.addActionListener(listener);
        shieldButton.addActionListener(listener);
        potionButton.addActionListener(listener);
        familiarButton.addActionListener(listener);
    }

    public void refreshStats(Player player, Mob mob) {
        playerHPLabel.setText(player.getName() + " HP: " + player.getHp());
        playerManaLabel.setText(player.getName() + " Mana: " + player.getMana());
        mobHPLabel.setText(mob.getName() + " HP: " + mob.getHp());
        mobManaLabel.setText(mob.getName() + " Mana: " + mob.getMana());
    }

    public JButton getAttackButton() {
        return attackButton;
    }

}
