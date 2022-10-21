package net.spicefox.util;

import net.spicefox.gui.GUI;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Stored settings for resolution and audio
        System.setProperty( "sun.java2d.uiScale", "1.0" ); // Forces UI scale to 1.0
        setup(Serializer.dserSettings()); // setup leads to title screen
    }

    // Responsible for launching title based on settings and creating settings if they don't exist
    public static void setup(Settings settings) {

        if (settings != null) {
            new GUI(settings); // net.spicefox.util.Settings.sav found, use constructor with net.spicefox.util.Settings (launches game)
        }
        else {
            new GUI(); // No net.spicefox.util.Settings.sav found, use constructor without net.spicefox.util.Settings (adds a settings prompt for user)
        }
    }
}
