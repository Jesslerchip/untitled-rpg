package net.spicefox.gui;

import javax.swing.*;

public class PanelMap extends JPanel {
    private JButton mapTitleButton;
    private JButton mapBattleButton;
    public  PanelMap() {
        mapTitleButton = new JButton("Title");
        mapTitleButton.addActionListener(e->GUI.changeActivePanel("TITLE"));
        this.add(mapTitleButton);
        mapBattleButton = new JButton("Battle");
        mapBattleButton.addActionListener(e->GUI.changeActivePanel("BATTLE"));
        this.add(mapBattleButton);
    }
}
