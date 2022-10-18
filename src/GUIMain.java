public class GUIMain {

    private static Settings guiSettings; // Stored settings for resolution and audio


    // Responsible for launching title based on settings and calling settingsWindow if settings do not exist
    public static void setup(Settings settings) {
        if (settings != null) {
            guiSettings = settings;
            new GUIGame(guiSettings); // Launches the Title Screen Window
        }
        else {
            new GUISettings(); // No settings found, prompt user for settings
        }
    }

}
