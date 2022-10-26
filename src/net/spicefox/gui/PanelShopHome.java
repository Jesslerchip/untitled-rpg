package net.spicefox.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelShopHome extends JPanel {
    private JButton shopBackButton;
    private JButton shopBuyButton;
    private JButton shopSellButton;

    public PanelShopHome() {
        shopBackButton = new JButton("Back");
        shopBuyButton = new JButton("Buy");
        shopSellButton = new JButton("Sell");

        shopBackButton.setFocusable(false);
        shopBuyButton.setFocusable(false);
        shopSellButton.setFocusable(false);

        this.add(shopBackButton);
        this.add(shopBuyButton);
        this.add(shopSellButton);
    }

    public void addPanelListener(ActionListener listener) {
        shopBackButton.addActionListener(listener);
        shopBuyButton.addActionListener(listener);
        shopSellButton.addActionListener(listener);
    }

    public JButton getShopBackButton() { return shopBackButton; }
    public JButton getShopBuyButton() { return shopBuyButton; }
    public JButton getShopSellButton() { return shopSellButton; }

}
