package net.spicefox.gui;

import net.spicefox.util.Game;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelMap extends JPanel {
    private JButton mapTitleButton;
    private JButton mapBattleButton;
    private JLabel mapPlayerName;
    public  PanelMap(Game game) {
        mapTitleButton = new JButton("Title");
        mapBattleButton = new JButton("Battle");
        mapPlayerName = new JLabel();

        this.add(mapTitleButton);
        this.add(mapBattleButton);
        this.add(mapPlayerName);
    }

    public void addPanelListener(ActionListener listener) {
        mapBattleButton.addActionListener(listener);
        mapTitleButton.addActionListener(listener);
    }

    public void setMapPlayerName(String name) {
        mapPlayerName.setText(name);
    }
}
