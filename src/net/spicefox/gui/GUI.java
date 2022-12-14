package net.spicefox.gui;

import net.spicefox.entity.Mob;
import net.spicefox.entity.Player;
import net.spicefox.familiar.Familiar;
import net.spicefox.util.*;
import net.spicefox.gear.*;
import net.spicefox.potions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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

    private Game game;
    private Game gameSave1;
    private Game gameSave2;
    private Game gameSave3;

    public GUI(Settings guiSettings) {
        Game gameSave1 = Serializer.dserGame("save/Game1.sav");
        Game gameSave2 = Serializer.dserGame("save/Game2.sav");
        Game gameSave3 = Serializer.dserGame("save/Game3.sav");

        //Set up GamePanel container
        gameFrame = new JFrame("Untitled RPG Game");
        gamePanel = new JPanel();
        cardLayout = new CardLayout();
        gamePanel.setLayout(cardLayout);

        //Create instances of each game screen
        titleScreenPanel = new PanelTitleScreen();
        nameEntryPanel = new PanelNameEntry();
        battlePanel = new PanelBattle();
        bestiaryPanel = new PanelBestiary();
        inventoryPanel = new PanelInventory();
        mapPanel = new PanelMap();
        saveSlotsPanel = new PanelSaveSlots();
        settingsInGamePanel = new PanelSettingsInGame();
        shopHomePanel = new PanelShopHome();
        shopBuyPanel = new PanelShopBuy();
        shopSellPanel = new PanelShopSell();

        //Add GUI as an ActionListener to panels
        titleScreenPanel.addPanelListener(e->titleScreenAction(e));
        nameEntryPanel.addPanelListener(e->nameEntryAction(e));
        battlePanel.addPanelListener(e->battleAction(e));
        bestiaryPanel.addPanelListener(e->bestiaryAction(e));
        inventoryPanel.addPanelListener(e->inventoryAction(e));
        mapPanel.addPanelListener(e->mapAction(e));
        saveSlotsPanel.addPanelListener(e->saveSlotsAction(e));
        settingsInGamePanel.addPanelListener(e->settingsInGameAction(e));
        shopHomePanel.addPanelListener(e->shopHomeAction(e));
        shopBuyPanel.addPanelListener(e->shopBuyAction(e));
        shopSellPanel.addPanelListener(e->shopSellAction(e));

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
        gamePanel.add(titleScreenPanel, "TITLE");

        // Add everything to gameFrame
        cardLayout.show(gamePanel, "TITLE");
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

    //Responses to events in titleScreenPanel
    private void titleScreenAction(ActionEvent e) {
        if (e.getSource() == titleScreenPanel.getTitleNewGameButton()) {
            game = new Game();
            game.getPlayer().addToInventory("HEALTH POTION"); // TODO TESTING
            cardLayout.show(gamePanel, "NAME_ENTRY");
        }
        if (e.getSource() == titleScreenPanel.getTitleLoadGameButton()) {
            saveSlotsPanel.setGameSlots(gameSave1, gameSave2, gameSave3);
            cardLayout.show(gamePanel, "SAVE_SLOTS");
        }
    }

    //Responses to events in nameEntryPanel
    private void nameEntryAction(ActionEvent e) {
        if (e.getSource() == nameEntryPanel.getSubmitButton()) {
            game.getPlayer().setName(nameEntryPanel.getNameEntryText());
            mapPanel.setMapPlayerName(game.getPlayer().getName());
            cardLayout.show(gamePanel, "MAP");
        }
    }

    //Responses to events in battlePanel
    private void battleAction(ActionEvent e) {
        boolean playerFirst = game.getBattle().isPlayerFirst();

        if (e.getActionCommand().equals("FAMILIAR_SUMMON")) {
            if (game.getPlayer().getActiveFamiliar() != null) {
                System.out.println(game.getPlayer().getName() + " already has an active Familiar!");
            }
            else {
                cardLayout.show(gamePanel, "BESTIARY");
            }
        }
        else if (e.getActionCommand().equals("WARD") && game.getPlayer().getMana() <
                game.getPlayer().getWardCost()) {
            System.out.println("Not enough mana to cast a Ward!");
        }
        else if (e.getActionCommand().equals("POTION") && !game.getPlayer().getInventory().checkForItem("HEALTH POTION")) {
            System.out.println(game.getPlayer().getName() + " has no potions!");
        }
        else if (playerFirst) {
            playerTurn(e);
            mobTurn();
            game.getBattle().endTurn(game.getPlayer(), game.getMob());
        }
        else {
            mobTurn();
            playerTurn(e);
            game.getBattle().endTurn(game.getPlayer(), game.getMob());
        }
    }

    public void playerTurn(ActionEvent e) {
        game.getBattle().takeTurn(game.getPlayer(), game.getMob(), e.getActionCommand());
        battlePanel.refreshStats(game.getPlayer(), game.getMob());
        checkBattleStatus();
    }

    public void mobTurn() {
        String action = MobAI.getAction(game.getMob(), game.getPlayer());
        game.getBattle().takeTurn(game.getMob(), game.getPlayer(), action);
        checkBattleStatus();
        battlePanel.refreshStats(game.getPlayer(), game.getMob());
    }

    // TODO: Add code for taking gear damage and losing bits
    private void checkBattleStatus() {
        Player player = game.getPlayer();
        Mob mob = game.getMob();
        if (player.getHp() <= 0) {
            cardLayout.show(gamePanel, "MAP");
            player.setHp(player.getMaxHp()); //NOT PERMANENT? Resets player at map
        }
        if (mob.getHp() <= 0) {
            // Add bits
            int mobBits = mob.getDropBits();
            System.out.println(player.getName() + " earned " + mobBits + " bits!");
            player.setBits(player.getBits() + mobBits);

            //Add familiar if passed check
            Random random = new Random();
            int familiarChance = random.nextInt(0, 100);
            if (familiarChance <= mob.getDropChanceFamiliar() + player.getModFamiliarDropRate() &&
                    player.getBestiary().get(mob.getName().toUpperCase()) == null) {
                player.getBestiary().put(mob.getName().toUpperCase(),
                        mob.getFamiliarDrop());
                System.out.println(player.getName() + " recovered a " +
                        mob.getFamiliarDrop().getName() + " Familiar!");
            }
            cardLayout.show(gamePanel, "MAP");
            player.setMana(player.getMaxMana());
        }

        // Broken gear check
        if (player.getBoots().toString() != "None" && player.getBoots().getDurability() <= 0) {
            player.setBoots(new BootsDefault());
        }
        if (player.getRobe().toString() != "None" && player.getRobe().getDurability() <= 0) {
            player.setRobe(new RobeDefault());
        }
        if (player.getHat().toString() != "None" && player.getHat().getDurability() <= 0) {
            player.setHat(new HatDefault());
        }
        if (player.getShield().toString() != "None" && player.getShield().getDurability() <= 0) {
            player.setShield(new ShieldDefault());
        }
        if (player.getWeapon().toString() != "None" && player.getWeapon().getDurability() <= 0) {
            player.setWeapon(new WeaponDefault());
        }
    }

    //Responses to events in bestiaryPanel
    private void bestiaryAction(ActionEvent e) {
        boolean playerFirst = game.getBattle().isPlayerFirst();
        if (e.getActionCommand().equals("BACK")) {
            cardLayout.show(gamePanel, "BATTLE");
        }
        else {
            Familiar familiar = game.getPlayer().getBestiary().get(e.getActionCommand());
            if (game.getPlayer().getMana() < familiar.getCost()) {
                System.out.println(game.getPlayer().getName() +
                        " doesn't have enough Mana to summon " + familiar.getName() + "!");
            }
            else if (playerFirst) {
                cardLayout.show(gamePanel, "BATTLE");
                game.getBattle().turnFamiliar(game.getPlayer(), familiar);
                battlePanel.refreshStats(game.getPlayer(), game.getMob());
                mobTurn();
                game.getBattle().endTurn(game.getPlayer(), game.getMob());
            } else {
                cardLayout.show(gamePanel, "BATTLE");
                mobTurn();
                game.getBattle().turnFamiliar(game.getPlayer(), familiar);
                battlePanel.refreshStats(game.getPlayer(), game.getMob());
                game.getBattle().endTurn(game.getPlayer(), game.getMob());
            }
        }
    }

    //Responses to events in inventoryPanel
    private void inventoryAction(ActionEvent e) {
        if (e.getSource() == inventoryPanel.getDummyPrintButton()) {
            game.getPlayer().getInventory().printInventory();
        }
        if (e.getSource() == inventoryPanel.getInventoryBackButton()) {
            cardLayout.show(gamePanel, "MAP");
        }
    }

    //Responses to events in mapPanel
    private void mapAction(ActionEvent e) {
        if (e.getSource() == mapPanel.getMapBattleButton()) {
            game.battleInit();
            battlePanel.refreshStats(game.getPlayer(), game.getMob());
            cardLayout.show(gamePanel, "BATTLE");
        }
        if (e.getSource() == mapPanel.getMapTitleButton()) {
            cardLayout.show(gamePanel, "TITLE");
        }
        if (e.getSource() == mapPanel.getMapShopButton()) {
            cardLayout.show(gamePanel, "SHOP_HOME");
        }
        if (e.getSource() == mapPanel.getMapInventoryButton()) {
            inventoryPanel.setupInventory(game.getPlayer().getInventory());
            cardLayout.show(gamePanel, "INVENTORY");
        }
    }

    //Responses to events in saveSlotsPanel
    private void saveSlotsAction(ActionEvent e) {
        if (e.getSource() == saveSlotsPanel.getSaveSlotsBackButton()) {
            cardLayout.show(gamePanel, "TITLE");
        }
    }

    //Responses to events in settingsInGamePanel
    private void settingsInGameAction(ActionEvent e) {

    }

    //Responses to events in shopHomePanel
    private void shopHomeAction(ActionEvent e) {
        if (e.getSource() == shopHomePanel.getShopBackButton()) {
            cardLayout.show(gamePanel, "MAP");
        }
        if (e.getSource() == shopHomePanel.getShopBuyButton()) {
            cardLayout.show(gamePanel, "SHOP_BUY");
        }
        if (e.getSource() == shopHomePanel.getShopSellButton()) {
            cardLayout.show(gamePanel, "SHOP_SELL");
        }
    }

    //Responses to events in shopBuyPanel
    private void shopBuyAction(ActionEvent e) {
        if (e.getSource() == shopBuyPanel.getBuyBackButton()) {
            cardLayout.show(gamePanel, "SHOP_HOME");
        }
    }

    //Responses to events in shopSellPanel
    private void shopSellAction(ActionEvent e) {
        if (e.getSource() == shopSellPanel.getSellBackButton()) {
            cardLayout.show(gamePanel, "SHOP_HOME");
        }
    }
}
