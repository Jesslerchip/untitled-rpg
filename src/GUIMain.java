import javax.swing.*;

public class GUIMain {

    private static Settings guiSettings; // Stored settings for resolution and audio
    private static JFrame activeWindow;


    // Responsible for launching title based on settings and calling settingsWindow if settings do not exist
    public static void setup(Settings settings) {
        if (settings != null) {
            guiSettings = settings;
            launchTitleScreen();
        }
        else {
            activeWindow = new GUISettings(); // No settings found, prompt user for settings
        }
    }

    public static void launchTitleScreen() {
        activeWindow = new GUITitleScreen(guiSettings); // Launches the Title Screen Window
    }

}
