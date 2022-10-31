package net.spicefox.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelBestiary extends JPanel {

    private JLabel kutesuneLabel;
    private JButton summonKutesuneButton;
    private JButton backButton;

    public PanelBestiary () {
        kutesuneLabel = new JLabel("Kutesune");
        summonKutesuneButton = new JButton("Summon");
        summonKutesuneButton.setFocusable(false);
        summonKutesuneButton.setActionCommand("KUTESUNE");
        backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.setActionCommand("BACK");

        this.add(kutesuneLabel);
        this.add(summonKutesuneButton);
        this.add(backButton);
    }

    public void addPanelListener(ActionListener listener) {
        summonKutesuneButton.addActionListener(listener);
        backButton.addActionListener(listener);
    }
}