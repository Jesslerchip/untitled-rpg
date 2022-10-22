package net.spicefox.gui;

import javax.swing.*;

public class PanelTitleScreen extends JPanel{
    private JButton titleNewGameButton;
    public PanelTitleScreen() {
        titleNewGameButton = new JButton("New Game");
        titleNewGameButton.addActionListener(e->GUI.changeActivePanel("MAP"));
    }

}
