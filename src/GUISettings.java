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
    GUISettings () {
        // Frame settings
        settingsFrame = new JFrame("Settings");
        settingsFrame.setSize(300, 85);
        settingsFrame.setLayout(new FlowLayout());

        // Maps user's resolution choice to integers
        String[] resolutionStrings = {"1920x1080", "2560x1440"};
        resolutions = new HashMap<>();
        resolutions.put("1920x1080", new int[]{1920, 1080});
        resolutions.put("2560x1440", new int[]{2560, 1440});

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
