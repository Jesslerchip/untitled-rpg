package net.spicefox.gui;

import javax.swing.*;

public class PanelNameEntry extends JPanel {
    private JTextField nameEntryField;
    private JButton submitButton;
    public PanelNameEntry() {
        nameEntryField = new JTextField();
        submitButton = new JButton();

        submitButton.addActionListener(e->newGameCreation());
    }

    private void newGameCreation() {

    }
}
