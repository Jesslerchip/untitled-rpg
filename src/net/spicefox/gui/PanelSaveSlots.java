package net.spicefox.gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import net.spicefox.util.Game;

public class PanelSaveSlots extends JPanel {
    private JButton saveSlotsBackButton;
    private JLabel slot1Label;
    private JLabel slot2Label;
    private JLabel slot3Label;
    public PanelSaveSlots() {
        saveSlotsBackButton = new JButton("Back");
        slot1Label = new JLabel();
        slot2Label = new JLabel();
        slot3Label = new JLabel();

        saveSlotsBackButton.setFocusable(false);

        this.add(saveSlotsBackButton);
        this.add(slot1Label);
        this.add(slot2Label);
        this.add(slot3Label);
    }

    public void addPanelListener(ActionListener listener) {
        saveSlotsBackButton.addActionListener(listener);
    }

    public JButton getSaveSlotsBackButton() { return saveSlotsBackButton; }
    public void setGameSlots(Game game1, Game game2, Game game3) {
        if (game1 != null) {
            slot1Label.setText(game1.getPlayer().getName());
        } else {
            slot1Label.setText("<No save file found>");
        }

        if (game2 != null) {
            slot2Label.setText(game2.getPlayer().getName());
        } else {
            slot2Label.setText("<No save file found>");
        }

        if (game3 != null) {
            slot3Label.setText(game3.getPlayer().getName());
        } else {
            slot3Label.setText("<No save file found>");
        }
    }
}

