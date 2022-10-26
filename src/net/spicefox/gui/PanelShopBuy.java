package net.spicefox.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelShopBuy extends JPanel {
    private JButton buyBackButton;
    private JLabel tempBuyLabel;
    public PanelShopBuy() {
        buyBackButton = new JButton("Back");
        tempBuyLabel = new JLabel("BUY");

        buyBackButton.setFocusable(false);

        this.add(buyBackButton);
        this.add(tempBuyLabel);
    }

    public void addPanelListener(ActionListener listener) {
        buyBackButton.addActionListener(listener);
    }

    public JButton getBuyBackButton() { return buyBackButton; }
}
