package net.spicefox.gui;

import javax.swing.*;

public class PanelMap extends JPanel {
    private JButton mapTitleButton;
    public  PanelMap() {
        mapTitleButton = new JButton("Title");
        mapTitleButton.addActionListener(e->GUI.changeActivePanel("TITLE"));
        this.add(mapTitleButton);
    }
}
