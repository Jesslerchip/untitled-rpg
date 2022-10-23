package net.spicefox.gui;

import net.spicefox.entity.Player;
import net.spicefox.util.Game;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelNameEntry extends JPanel {
    private JTextField nameEntryField;
    private JButton submitButton;
    public PanelNameEntry(Game game) {
        nameEntryField = new JTextField();
        nameEntryField.setColumns(10);
        submitButton = new JButton("Submit");

        this.add(nameEntryField);
        this.add(submitButton);
    }

    public void addPanelListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public String getNameEntryText() {
        return nameEntryField.getText();
    }
}
