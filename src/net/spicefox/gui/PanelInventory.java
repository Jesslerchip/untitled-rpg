package net.spicefox.gui;

import net.spicefox.gear.Equippable;
import net.spicefox.inventory.Inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelInventory extends JPanel {
    private JButton dummyPrintButton;
    private JButton inventoryBackButton;
    private JScrollPane scrollPane;
    private JPanel inventory;
    public PanelInventory() {
        dummyPrintButton = new JButton("Print Inventory");
        inventoryBackButton = new JButton("Back");

        inventory = new JPanel();
        inventory.setLayout(new BoxLayout(inventory, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(inventory, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(500, 100));

        dummyPrintButton.setFocusable(false);
        inventoryBackButton.setFocusable(false);

        this.add(dummyPrintButton);
        this.add(inventoryBackButton);
        this.add(scrollPane);
    }

    public void addPanelListener(ActionListener listener) {
        dummyPrintButton.addActionListener(listener);
        inventoryBackButton.addActionListener(listener);
    }

    public void setupInventory(Inventory inv) {
        inventory.removeAll();
        for (int i = 0; i < inv.getEquipmentSize(); i++) {
            final Equippable item = inv.getEquipmentAtIndex(i);
            JButton button = new JButton(inv.getEquipmentAtIndex(i).toString());
            button.addActionListener(e->{inv.remove(item); setupInventory(inv);});
            inventory.add(button);
        }
        repaint();
        revalidate();
    }

    public JButton getDummyPrintButton() { return dummyPrintButton; }
    public JButton getInventoryBackButton() { return inventoryBackButton; }
}
