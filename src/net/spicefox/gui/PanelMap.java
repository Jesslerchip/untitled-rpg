package net.spicefox.gui;

import net.spicefox.util.Game;

import javax.swing.*;

public class PanelMap extends JPanel {
    private JButton mapTitleButton;
    private JButton mapBattleButton;
    private JLabel mapPlayerName;
    public  PanelMap(Game game) {
        refreshMap(game);
        mapTitleButton = new JButton("Title");
        mapTitleButton.addActionListener(e->GUI.changeActivePanel("TITLE"));
        this.add(mapTitleButton);
        mapBattleButton = new JButton("Battle");
        mapBattleButton.addActionListener(e->GUI.changeActivePanel("BATTLE"));
        this.add(mapBattleButton);
    }

    public void refreshMap(Game game) {
        mapPlayerName = new JLabel(game.getPlayer().getName());
        this.add(mapPlayerName);
    }


}
