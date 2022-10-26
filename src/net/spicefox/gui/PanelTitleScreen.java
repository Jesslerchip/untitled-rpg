package net.spicefox.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelTitleScreen extends JPanel{
    private JButton titleNewGameButton;
    private JButton titleLoadGameButton;
    public PanelTitleScreen() {
        titleNewGameButton = new JButton("New Game");
        titleLoadGameButton = new JButton("Load Game");

        titleNewGameButton.setFocusable(false);
        titleLoadGameButton.setFocusable(false);

        this.add(titleNewGameButton);
        this.add(titleLoadGameButton);
    }

    public void addPanelListener(ActionListener listener) {
        titleNewGameButton.addActionListener(listener);
        titleLoadGameButton.addActionListener(listener);
    }

    public JButton getTitleNewGameButton() {
        return titleNewGameButton;
    }

    public JButton getTitleLoadGameButton() {
        return titleLoadGameButton;
    }
}
