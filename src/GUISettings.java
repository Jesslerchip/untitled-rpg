import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

public class GUISettings extends JFrame implements ActionListener {

    private final JFrame settingsFrame;
    private final JComboBox<String> settingsComboBox;
    private final JButton submitButton;
    private final HashMap<String, int[]> resolutions;


    // GUI for settings prompt if no settings exist
    public GUISettings () {

        // Frame settings
        settingsFrame = new JFrame("Settings");
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
        submitButton = new JButton("Submit");
        submitButton.setSize(100, 20);
        submitButton.addActionListener(this);

        // Adds components
        settingsFrame.add(settingsComboBox);
        settingsFrame.add(submitButton);

        // Forces the program to close if they don't select settings and try to skip this window
        settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settingsFrame.pack();
        settingsFrame.setVisible(true);
    }

    // Submit button stores choices in GUIMain's Settings field
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            int[] newResolution = resolutions.get((String)settingsComboBox.getSelectedItem());
            Settings settings = new Settings (newResolution[0], newResolution[1]);
            GUIMain.setup(settings); // Trigger title screen with new settings object
            try {
                Serializer.serSettings(settings);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            settingsFrame.dispose(); // Murder the window when its deed is done
        }
    }
}
