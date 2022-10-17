import java.io.*;

public class Serializer{

    // deserializes and returns a settings file if exists in save directory, otherwise returns null
    public static Settings dserSettings() throws IOException, ClassNotFoundException {
        String settingsPath = "save/Settings.ser";
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
        String settingsPath = "save/Settings.ser";
        FileOutputStream fileOut = new FileOutputStream(settingsPath);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        objectOut.writeObject(settings);

        fileOut.close();
        objectOut.close();

    }
}
