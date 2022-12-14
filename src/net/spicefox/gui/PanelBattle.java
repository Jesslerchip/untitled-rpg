package net.spicefox.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import net.spicefox.entity.*;

public class PanelBattle extends JPanel {
    private JButton attackButton;
    private JButton wardButton;
    private JButton potionButton;
    private JButton familiarButton;

    private JLabel playerHPLabel;
    private JLabel playerManaLabel;
    private JLabel mobHPLabel;
    private JLabel mobManaLabel;
    private JLabel imgLabel;

    public PanelBattle() {
        setLayout(new FlowLayout());

        // Buttons
        attackButton = new JButton("Attack");
        wardButton = new JButton("Ward");
        potionButton = new JButton("Potion");
        familiarButton = new JButton("Familiar");
        attackButton.setFocusable(false);
        wardButton.setFocusable(false);
        potionButton.setFocusable(false);
        familiarButton.setFocusable(false);
        attackButton.setActionCommand("ATTACK");
        wardButton.setActionCommand("WARD");
        potionButton.setActionCommand("POTION");
        familiarButton.setActionCommand("FAMILIAR_SUMMON");

        imgLabel = new JLabel(new ImageIcon("src/net/spicefox/assets/kutesune.png"));

        // Labels
        playerHPLabel = new JLabel();
        playerManaLabel = new JLabel();
        mobHPLabel = new JLabel();
        mobManaLabel = new JLabel();

        this.add(attackButton);
        this.add(wardButton);
        this.add(potionButton);
        this.add(familiarButton);
        this.add(playerHPLabel);
        this.add(playerManaLabel);
        this.add(mobHPLabel);
        this.add(mobManaLabel);
        this.add(imgLabel);
    }

    public void addPanelListener(ActionListener listener) {
        attackButton.addActionListener(listener);
        wardButton.addActionListener(listener);
        potionButton.addActionListener(listener);
        familiarButton.addActionListener(listener);
    }

    public void refreshStats(Player player, Mob mob) {
        playerHPLabel.setText(player.getName() + " HP: " + player.getHp());
        playerManaLabel.setText(player.getName() + " Mana: " + player.getMana());
        mobHPLabel.setText(mob.getName() + " HP: " + mob.getHp());
        mobManaLabel.setText(mob.getName() + " Mana: " + mob.getMana());
        if (player.getBestiary().isEmpty()) {
            familiarButton.setEnabled(false);
        }
        else {
            familiarButton.setEnabled(true);
        }
    }

}
