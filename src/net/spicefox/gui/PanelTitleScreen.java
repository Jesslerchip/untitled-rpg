package net.spicefox.gui;

import net.spicefox.util.Game;

import javax.swing.*;

public class PanelTitleScreen extends JPanel{
    private JButton titleNewGameButton;
    public PanelTitleScreen(Game game, Game game1, Game game2, Game game3) {
        titleNewGameButton = new JButton("New Game");
        titleNewGameButton.addActionListener(e->newGame(game));
        this.add(titleNewGameButton);
        titleNewGameButton = new JButton("Load Game");
        titleNewGameButton.addActionListener(e->GUI.changeActivePanel("MAP"));
        this.add(titleNewGameButton);
    }

    public void newGame(Game game) {
        game = new Game();
        GUI.changeActivePanel("NAME_ENTRY");
    }
}
