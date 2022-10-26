package net.spicefox.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelShopSell extends JPanel {
    private JButton sellBackButton;
    private JLabel tempSellLabel;
    public PanelShopSell() {
        sellBackButton = new JButton("Back");
        tempSellLabel = new JLabel("SELL");

        sellBackButton.setFocusable(false);

        this.add(sellBackButton);
        this.add(tempSellLabel);
    }

    public void addPanelListener(ActionListener listener) {
        sellBackButton.addActionListener(listener);
    }

    public JButton getSellBackButton() { return sellBackButton; }
}
