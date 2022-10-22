package net.spicefox.gui;

import javax.swing.*;

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

        //attackButton.addActionListener();
        //shieldButton.addActionListener();
        //potionButton.addActionListener();
        //familiarButton.addActionListener();

        this.add(attackButton);
        this.add(shieldButton);
        this.add(potionButton);
        this.add(familiarButton);
    }
}
