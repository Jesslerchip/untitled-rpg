package net.spicefox.util;

import java.io.*;

public class Serializer{

    // deserializes and returns a settings file if exists in save directory, otherwise returns null
    public static Settings dserSettings() {
        String settingsPath = "save/Settings.sav";
        File settingsFile = new File(settingsPath);
        if (settingsFile.exists()) {
            Settings settings = null;
            try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(settingsPath))) {
                settings = (Settings) objectIn.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("dserSettings: File couldn't be opened!");
            }
            return settings;
        }
        else {
            return null;
        }
    }

    // Serializes a settings object into a file in save directory
    public static void serSettings(Settings settings) throws IOException {
        ensureSaveDirectory();
        String settingsPath = "save/Settings.sav";

        FileOutputStream fileOut = new FileOutputStream(settingsPath);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        objectOut.writeObject(settings);

        fileOut.close();
        objectOut.close();

    }

    // deserializes and returns a settings file if exists in save directory, otherwise returns null
    public static Game dserGame(String gamePath) {
        File gameFile = new File(gamePath);
        if (gameFile.exists()) {
            Game game = null;
            try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(gamePath))) {
                game = (Game) objectIn.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("dserGame: File couldn't be opened!");
            }
            return game;
        }
        else {
            return null;
        }
    }

    // Serializes a game object into a file in save directory
    public static void serGame(Game game) throws IOException {
        ensureSaveDirectory();
        String gamePath = "save/Game.sav";

        FileOutputStream fileOut = new FileOutputStream(gamePath);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        objectOut.writeObject(game);

        fileOut.close();
        objectOut.close();

    }

    //Checks for the existence of a save directory; creates one if it doesn't exist
    private static void ensureSaveDirectory() {
        File saveFolder = new File ("save");
        if (!saveFolder.exists()) {
            System.out.println("Save directory created: " + saveFolder.mkdir());
        }
    }

}