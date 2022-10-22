package net.spicefox.gui;

import net.spicefox.entity.Player;
import net.spicefox.util.Game;

import javax.swing.*;

public class PanelNameEntry extends JPanel {
    private JTextField nameEntryField;
    private JButton submitButton;
    public PanelNameEntry(Game game) {
        nameEntryField = new JTextField();
        nameEntryField.setSize(100, 20);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e->newPlayer(game));

        this.add(nameEntryField);
        this.add(submitButton);
    }

    private void newPlayer(Game game) {
        game.setPlayer(new Player(nameEntryField.getText()));
        GUI.getMapPanel().refreshMap(game);
        GUI.changeActivePanel("MAP");
    }
}
