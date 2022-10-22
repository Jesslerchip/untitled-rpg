package net.spicefox.gui;

import javax.swing.*;

public class PanelBattle extends JPanel {
    JButton attackButton;
    JButton shieldButton;
    JButton potionButton;
    JButton familiarButton;
    public PanelBattle() {
        attackButton = new JButton("attack");
        shieldButton = new JButton("shield");
        potionButton = new JButton("potion");
        familiarButton = new JButton("familiar");

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
