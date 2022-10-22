package net.spicefox.util;

import java.io.*;

public class Serializer{

    // deserializes and returns a settings file if exists in save directory, otherwise returns null
    public static Settings dserSettings() throws IOException, ClassNotFoundException {
        String settingsPath = "save/Settings.sav";
        File settingsFile = new File(settingsPath);
        if (settingsFile.exists()) {
            FileInputStream fileIn = new FileInputStream(settingsPath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Settings settings = (Settings)objectIn.readObject();

            fileIn.close();
            objectIn.close();

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
    public static Game dserGame() throws IOException, ClassNotFoundException {
        String gamePath = "save/Game.sav";
        File gameFile = new File(gamePath);
        if (gameFile.exists()) {
            FileInputStream fileIn = new FileInputStream(gamePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Game game = (Game)objectIn.readObject();

            fileIn.close();
            objectIn.close();

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