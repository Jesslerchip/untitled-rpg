import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITitleScreen extends JFrame implements ActionListener {

    JFrame titleScreenFrame;

    // Title Screen Window
    GUITitleScreen (Settings guiSettings) {

        // Frame settings
        titleScreenFrame = new JFrame("Title Screen");
        titleScreenFrame.setSize(guiSettings.getX(), guiSettings.getY());
        titleScreenFrame.setResizable(false);


        titleScreenFrame.setVisible(true);
        titleScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
