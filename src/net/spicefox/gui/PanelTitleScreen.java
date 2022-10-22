package net.spicefox.gui;

import javax.swing.*;
import java.awt.*;

public class PanelTitleScreen extends JPanel{
    private JButton titleNewGameButton;
    public PanelTitleScreen() {
        titleNewGameButton = new JButton("New Game");
        titleNewGameButton.addActionListener(e->titleNewGame());
        this.add(titleNewGameButton);
    }

    public void titleNewGame() {
        GUI.changeActivePanel("MAP");
    }
}
