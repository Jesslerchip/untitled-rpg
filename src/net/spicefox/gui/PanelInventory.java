package net.spicefox.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelInventory extends JPanel {
    public JButton dummyAddButton;
    public JButton dummyRemoveButton;
    public JButton dummyPrintButton;
    public JButton inventoryBackButton;
    public PanelInventory() {
        dummyAddButton = new JButton("Add (DUMMY)");
        dummyRemoveButton = new JButton("Remove (DUMMY)");
        dummyPrintButton = new JButton("Print (DUMMY)");
        inventoryBackButton = new JButton("Back");

        dummyAddButton.setFocusable(false);
        dummyRemoveButton.setFocusable(false);
        dummyPrintButton.setFocusable(false);
        inventoryBackButton.setFocusable(false);

        this.add(dummyAddButton);
        this.add(dummyRemoveButton);
        this.add(dummyPrintButton);
        this.add(inventoryBackButton);
    }

    public void addPanelListener(ActionListener listener) {
        dummyAddButton.addActionListener(listener);
        dummyRemoveButton.addActionListener(listener);
        dummyPrintButton.addActionListener(listener);
        inventoryBackButton.addActionListener(listener);
    }

    public JButton getDummyAddButton() { return dummyAddButton; }
    public JButton getDummyRemoveButton() { return dummyRemoveButton; }
    public JButton getDummyPrintButton() { return dummyPrintButton; }
    public JButton getInventoryBackButton() { return inventoryBackButton; }
}
