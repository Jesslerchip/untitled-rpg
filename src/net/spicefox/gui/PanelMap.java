package net.spicefox.gui;

import net.spicefox.util.Game;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelMap extends JPanel {
    private JButton mapTitleButton;
    private JButton mapBattleButton;
    private JButton mapShopButton;
    private JButton mapInventoryButton;
    private JLabel mapPlayerName;
    public  PanelMap() {
        mapTitleButton = new JButton("Title");
        mapBattleButton = new JButton("Battle");
        mapShopButton = new JButton("Shop");
        mapInventoryButton = new JButton("Inventory");
        mapPlayerName = new JLabel();

        mapTitleButton.setFocusable(false);
        mapBattleButton.setFocusable(false);
        mapShopButton.setFocusable(false);
        mapInventoryButton.setFocusable(false);

        this.add(mapTitleButton);
        this.add(mapBattleButton);
        this.add(mapShopButton);
        this.add(mapInventoryButton);
        this.add(mapPlayerName);
    }

    public void addPanelListener(ActionListener listener) {
        mapBattleButton.addActionListener(listener);
        mapTitleButton.addActionListener(listener);
        mapShopButton.addActionListener(listener);
        mapInventoryButton.addActionListener(listener);
    }

    public void setMapPlayerName(String name) {
        mapPlayerName.setText(name);
    }

    public JButton getMapBattleButton() {
        return mapBattleButton;
    }

    public JButton getMapTitleButton() { return mapTitleButton; }

    public JButton getMapShopButton() { return mapShopButton; }

    public JButton getMapInventoryButton() { return mapInventoryButton; }
}
