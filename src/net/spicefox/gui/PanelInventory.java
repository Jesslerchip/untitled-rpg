package net.spicefox.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelInventory extends JPanel {
    public JButton dummyPrintButton;
    public JButton inventoryBackButton;
    public PanelInventory() {
        dummyPrintButton = new JButton("Print Inventory");
        inventoryBackButton = new JButton("Back");

        dummyPrintButton.setFocusable(false);
        inventoryBackButton.setFocusable(false);

        this.add(dummyPrintButton);
        this.add(inventoryBackButton);
    }

    public void addPanelListener(ActionListener listener) {
        dummyPrintButton.addActionListener(listener);
        inventoryBackButton.addActionListener(listener);
    }

    public JButton getDummyPrintButton() { return dummyPrintButton; }
    public JButton getInventoryBackButton() { return inventoryBackButton; }
}
