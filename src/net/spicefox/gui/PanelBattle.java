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
    public PanelBattle() {
        attackButton = new JButton("Attack");
        shieldButton = new JButton("Shield");
        potionButton = new JButton("Potion");
        familiarButton = new JButton("Familiar");

        playerHPLabel = new JLabel();
        playerManaLabel = new JLabel();

        attackButton.setFocusable(false);
        shieldButton.setFocusable(false);
        potionButton.setFocusable(false);
        familiarButton.setFocusable(false);

        this.add(attackButton);
        this.add(shieldButton);
        this.add(potionButton);
        this.add(familiarButton);
        this.add(playerHPLabel);
        this.add(playerManaLabel);
    }

    public void addPanelListener(ActionListener listener) {
        attackButton.addActionListener(listener);
        shieldButton.addActionListener(listener);
        potionButton.addActionListener(listener);
        familiarButton.addActionListener(listener);
    }

    public void refreshStats(Player player) {
        playerHPLabel.setText("HP: " + player.getHp());
        playerManaLabel.setText("Mana: " + player.getMana());
    }

    public JButton getAttackButton() {
        return attackButton;
    }

}
