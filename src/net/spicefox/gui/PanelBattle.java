package net.spicefox.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelBattle extends JPanel {
    JButton attackButton;
    JButton shieldButton;
    JButton potionButton;
    JButton familiarButton;
    public PanelBattle() {
        attackButton = new JButton("Attack");
        shieldButton = new JButton("Shield");
        potionButton = new JButton("Potion");
        familiarButton = new JButton("Familiar");

        attackButton.setFocusable(false);
        shieldButton.setFocusable(false);
        potionButton.setFocusable(false);
        familiarButton.setFocusable(false);

        this.add(attackButton);
        this.add(shieldButton);
        this.add(potionButton);
        this.add(familiarButton);
    }

    public void addPanelListener(ActionListener listener) {
        attackButton.addActionListener(listener);
        shieldButton.addActionListener(listener);
        potionButton.addActionListener(listener);
        familiarButton.addActionListener(listener);
    }

    public JButton getAttackButton() {
        return attackButton;
    }

}
