package net.spicefox.gui;

import net.spicefox.util.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class GUI extends JFrame {

    // Variables, objects, etc.
    private JFrame gameFrame;
    private static JPanel gamePanel;
    private static CardLayout cardLayout;
    private JFrame settingsFrame;
    private JComboBox<String> settingsComboBox;
    private HashMap<String, int[]> resolutions;
    private PanelBattle battlePanel;
    private PanelBestiary bestiaryPanel;
    private PanelInventory inventoryPanel;
    private PanelMap mapPanel;
    private PanelNameEntry nameEntryPanel;
    private PanelSaveSlots saveSlotsPanel;
    private PanelSettingsInGame settingsInGamePanel;
    private PanelShopHome shopHomePanel;
    private PanelShopBuy shopBuyPanel;
    private PanelShopSell shopSellPanel;
    private PanelTitleScreen titleScreenPanel;


    // Constructor for the game window if net.spicefox.util.Settings object exists
    public GUI(Settings guiSettings) {

        Game game = new Game();
        Game game1 = Serializer.dserGame("save/Game1.sav");
        Game game2 = Serializer.dserGame("save/Game2.sav");
        Game game3 = Serializer.dserGame("save/Game3.sav");

        // Frame and panel setup
        gameFrame = new JFrame("Untitled RPG Game");
        gamePanel = new JPanel();
        titleScreenPanel = new PanelTitleScreen(game, game1, game2, game3);
        cardLayout = new CardLayout();
        gamePanel.setLayout(cardLayout);
        gamePanel.add(titleScreenPanel, "TITLE");
        cardLayout.show(gamePanel, "TITLE"); // Show the title screen first

        nameEntryPanel = new PanelNameEntry(game);
        battlePanel = new PanelBattle();
        bestiaryPanel = new PanelBestiary();
        inventoryPanel = new PanelInventory();
        mapPanel = new PanelMap(game);
        saveSlotsPanel = new PanelSaveSlots();
        settingsInGamePanel = new PanelSettingsInGame();
        shopHomePanel = new PanelShopHome();
        shopBuyPanel = new PanelShopBuy();
        shopSellPanel = new PanelShopSell();


        // Organize panels in the gamePanel
        gamePanel.add(battlePanel, "BATTLE");
        gamePanel.add(bestiaryPanel, "BESTIARY");
        gamePanel.add(inventoryPanel, "INVENTORY");
        gamePanel.add(mapPanel, "MAP");
        gamePanel.add(nameEntryPanel, "NAME_ENTRY");
        gamePanel.add(saveSlotsPanel, "SAVE_SLOTS");
        gamePanel.add(settingsInGamePanel, "SETTINGS_IG");
        gamePanel.add(shopHomePanel, "SHOP_HOME");
        gamePanel.add(shopBuyPanel, "SHOP_BUY");
        gamePanel.add(shopSellPanel, "SHOP_SELL");

        // Add everything to gameFrame
        gameFrame.add(gamePanel);
        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(guiSettings.getX(), guiSettings.getY()); // Res based on user input
        gameFrame.setVisible(true);
    }

    // gui.GUI for settings prompt if no settings exist
    public GUI () {

        // Frame settings
        settingsFrame = new JFrame("net.spicefox.util.Settings");
        settingsFrame.setSize(300, 85);
        settingsFrame.setLayout(new FlowLayout());

        // Maps user's resolution choice to integers
        String[] resolutionStrings =
                {"800x600", "1024x768", "1152x864", "1176x664", "1280x720", "1280x768", "1280x800",
                        "1280x960", "1280x1024", "1360x768", "1366x768", "1440x900", "1600x900", "1600x1024",
                        "1600x1200", "1680x1050", "1920x1080", "1920x1200", "1920x1440", "2560x1440",
                        "3840x2160", "7680x4320"};

        resolutions = new HashMap<>();
        resolutions.put("800x600", new int[]{800, 600});
        resolutions.put("1024x768", new int[]{1024, 768});
        resolutions.put("1152x864", new int[]{1152, 864});
        resolutions.put("1176x664", new int[]{1176, 664});
        resolutions.put("1280x720", new int[]{1280, 720});
        resolutions.put("1280x768", new int[]{1280, 768});
        resolutions.put("1280x800", new int[]{1280, 800});
        resolutions.put("1280x960", new int[]{1280, 960});
        resolutions.put("1280x1024", new int[]{1280, 1024});
        resolutions.put("1360x768", new int[]{1360, 768});
        resolutions.put("1366x768", new int[]{1366, 768});
        resolutions.put("1440x900", new int[]{1440, 900});
        resolutions.put("1600x900", new int[]{1600, 900});
        resolutions.put("1600x1024", new int[]{1600, 1024});
        resolutions.put("1600x1200", new int[]{1600, 1200});
        resolutions.put("1680x1050", new int[]{1680, 1050});
        resolutions.put("1920x1080", new int[]{1920, 1080});
        resolutions.put("1920x1200", new int[]{1920, 1200});
        resolutions.put("1920x1440", new int[]{1920, 1440});
        resolutions.put("2560x1440", new int[]{2560, 1440});
        resolutions.put("3840x2160", new int[]{3840, 2160});
        resolutions.put("7680x4320", new int[]{7680, 4320});

        settingsComboBox = new JComboBox<>(resolutionStrings);

        // Submit button settings
        JButton submitButton = new JButton("Submit");
        submitButton.setSize(100, 20);
        submitButton.addActionListener(e->resolutionSubmit());

        // Adds components
        settingsFrame.add(settingsComboBox);
        settingsFrame.add(submitButton);

        // Forces the program to close if they don't select settings and try to skip this window
        settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settingsFrame.pack();
        settingsFrame.setVisible(true);
    }

    //Switches visible panel
    public static void changeActivePanel(String panelName){ cardLayout.show(gamePanel, panelName); }

    public PanelMap getMapPanel() {
        return mapPanel;
    }

    // Submit button stores choices in GUIMain's Settings field
    public void resolutionSubmit () {
        int[] newResolution = resolutions.get((String)settingsComboBox.getSelectedItem());
        Settings settings = new Settings(newResolution[0], newResolution[1]);
        Main.setup(settings); // Trigger title screen with new settings object
        try {
            Serializer.serSettings(settings);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        settingsFrame.dispose(); // Murder the window when its deed is done
    }
}
